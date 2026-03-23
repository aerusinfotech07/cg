import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { Table, Button, Card, Spinner, Alert } from 'react-bootstrap';
import userService from '../services/userService';

const UserList = () => {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [success, setSuccess] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
    try {
      setLoading(true);
      setError(null);
      const data = await userService.getAllUsers();
      setUsers(data);
    } catch (err) {
      const errorMessage = err?.message || err?.response?.data?.message || 'Failed to load users';
      setError(errorMessage);
      console.error('Error loading users:', err);
      // Don't refresh page on error
    } finally {
      setLoading(false);
    }
  };

  const handleEdit = (id) => {
    navigate(`/edit/${id}`);
  };

  const handleDelete = async (id, name) => {
    if (window.confirm(`Are you sure you want to delete user "${name}"?`)) {
      try {
        await userService.deleteUser(id);
        setSuccess(`User "${name}" deleted successfully`);
        setError(null);
        loadUsers();
        setTimeout(() => setSuccess(null), 3000);
      } catch (err) {
        setError(err.message || 'Failed to delete user');
        setSuccess(null);
      }
    }
  };

  const handleView = (id) => {
    navigate(`/view/${id}`);
  };

  if (loading) {
    return (
      <div className="loading-spinner">
        <Spinner animation="border" role="status">
          <span className="visually-hidden">Loading...</span>
        </Spinner>
      </div>
    );
  }

  return (
    <div>
      <div className="d-flex justify-content-between align-items-center mb-4">
        <h2>User Management</h2>
        <Button variant="primary" onClick={() => navigate('/create')}>
          <i className="bi bi-plus-circle"></i> Add New User
        </Button>
      </div>

      {error && (
        <Alert variant="danger" dismissible onClose={() => setError(null)}>
          {error}
        </Alert>
      )}

      {success && (
        <Alert variant="success" dismissible onClose={() => setSuccess(null)}>
          {success}
        </Alert>
      )}

      <Card>
        <Card.Header>
          <h5 className="mb-0">Users List ({users.length})</h5>
        </Card.Header>
        <Card.Body>
          {users.length === 0 ? (
            <div className="text-center py-5">
              <p className="text-muted">No users found. Click "Add New User" to create one.</p>
            </div>
          ) : (
            <div className="table-responsive">
              <Table striped bordered hover>
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>City</th>
                    <th>Company</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
                  {users.map((user) => (
                    <tr key={user.id}>
                      <td>{user.id}</td>
                      <td>{user.name}</td>
                      <td>{user.username}</td>
                      <td>{user.email}</td>
                      <td>{user.phone || '-'}</td>
                      <td>{user.address?.city || '-'}</td>
                      <td>{user.company?.name || '-'}</td>
                      <td>
                        <Button
                          variant="info"
                          size="sm"
                          onClick={() => handleView(user.id)}
                          className="btn-action"
                        >
                          View
                        </Button>
                        <Button
                          variant="warning"
                          size="sm"
                          onClick={() => handleEdit(user.id)}
                          className="btn-action"
                        >
                          Edit
                        </Button>
                        <Button
                          variant="danger"
                          size="sm"
                          onClick={() => handleDelete(user.id, user.name)}
                          className="btn-action"
                        >
                          Delete
                        </Button>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </Table>
            </div>
          )}
        </Card.Body>
      </Card>
    </div>
  );
};

export default UserList;
