import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import userService from '../services/userService';
import './components.css';

const UserList = () => {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [deleteConfirm, setDeleteConfirm] = useState(null);
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
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  const handleDelete = async (id) => {
    try {
      await userService.deleteUser(id);
      setDeleteConfirm(null);
      loadUsers();
    } catch (err) {
      setError(err.message);
    }
  };

  if (loading) {
    return (
      <div>
        <div className="page-header">
          <h1>User Management</h1>
        </div>
        <div className="loading-spinner">
          <div className="spinner"></div>
        </div>
      </div>
    );
  }

  return (
    <div>
      <div className="page-header">
        <h1>User Management</h1>
      </div>

      {error && (
        <div className="error-message">
          {error}
          <button className="close-btn" onClick={() => setError(null)}>Ã—</button>
        </div>
      )}

      <div className="table-container">
        <div className="action-buttons">
          <button className="btn btn-primary" onClick={() => navigate('/create')}>
            Create New User
          </button>
        </div>

        {users.length === 0 ? (
          <div className="empty-state">
            <h3>No users found</h3>
            <p>Click "Create New User" to add your first user.</p>
          </div>
        ) : (
          <table className="table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Username</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Website</th>
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
                  <td>{user.phone}</td>
                  <td>{user.website}</td>
                  <td>
                    <button
                      className="btn btn-info btn-sm"
                      onClick={() => navigate(`/view/${user.id}`)}
                    >
                      View
                    </button>
                    <button
                      className="btn btn-warning btn-sm"
                      onClick={() => navigate(`/edit/${user.id}`)}
                    >
                      Edit
                    </button>
                    {deleteConfirm === user.id ? (
                      <>
                        <button
                          className="btn btn-danger btn-sm"
                          onClick={() => handleDelete(user.id)}
                        >
                          Confirm
                        </button>
                        <button
                          className="btn btn-secondary btn-sm"
                          onClick={() => setDeleteConfirm(null)}
                        >
                          Cancel
                        </button>
                      </>
                    ) : (
                      <button
                        className="btn btn-danger btn-sm"
                        onClick={() => setDeleteConfirm(user.id)}
                      >
                        Delete
                      </button>
                    )}
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    </div>
  );
};

export default UserList;
