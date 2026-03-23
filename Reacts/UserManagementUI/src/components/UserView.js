import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { Card, Button, Spinner, Alert, Row, Col, Badge } from 'react-bootstrap';
import userService from '../services/userService';

const UserView = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    loadUser();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [id]);

  const loadUser = async () => {
    try {
      setLoading(true);
      setError(null);
      const data = await userService.getUserById(id);
      setUser(data);
    } catch (err) {
      const errorMessage = err?.message || err?.response?.data?.message || 'Failed to load user';
      setError(errorMessage);
      console.error('Error loading user:', err);
      // Don't refresh page on error
    } finally {
      setLoading(false);
    }
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

  if (error) {
    return (
      <Alert variant="danger">
        {error}
        <div className="mt-3">
          <Button variant="primary" onClick={() => navigate('/')}>
            Back to List
          </Button>
        </div>
      </Alert>
    );
  }

  if (!user) {
    return null;
  }

  return (
    <div>
      <div className="page-header">
        <h1>User Details</h1>
      </div>

      <div className="d-flex justify-content-end mb-3">
        <Button variant="secondary" onClick={() => navigate('/')} className="me-2">
          Back to List
        </Button>
        <Button variant="warning" onClick={() => navigate(`/edit/${id}`)}>
          Edit User
        </Button>
      </div>

      <Row>
        <Col md={6}>
          <Card className="mb-3">
            <Card.Header>
              <h5 className="mb-0">Personal Information</h5>
            </Card.Header>
            <Card.Body>
              <p><strong>ID:</strong> {user.id}</p>
              <p><strong>Name:</strong> {user.name}</p>
              <p><strong>Username:</strong> <Badge bg="primary">{user.username}</Badge></p>
              <p><strong>Email:</strong> {user.email}</p>
              <p><strong>Phone:</strong> {user.phone || '-'}</p>
              <p><strong>Website:</strong> {user.website ? <a href={user.website} target="_blank" rel="noopener noreferrer">{user.website}</a> : '-'}</p>
            </Card.Body>
          </Card>
        </Col>

        <Col md={6}>
          <Card className="mb-3">
            <Card.Header>
              <h5 className="mb-0">Address Information</h5>
            </Card.Header>
            <Card.Body>
              {user.address ? (
                <>
                  <p><strong>Street:</strong> {user.address.street}</p>
                  <p><strong>Suite:</strong> {user.address.suite || '-'}</p>
                  <p><strong>City:</strong> {user.address.city}</p>
                  <p><strong>Zipcode:</strong> {user.address.zipcode}</p>
                  {user.address.geo && (
                    <>
                      <p><strong>Latitude:</strong> {user.address.geo.lat}</p>
                      <p><strong>Longitude:</strong> {user.address.geo.lng}</p>
                    </>
                  )}
                </>
              ) : (
                <p className="text-muted">No address information available</p>
              )}
            </Card.Body>
          </Card>
        </Col>
      </Row>

      <Card>
        <Card.Header>
          <h5 className="mb-0">Company Information</h5>
        </Card.Header>
        <Card.Body>
          {user.company ? (
            <>
              <p><strong>Company Name:</strong> {user.company.name}</p>
              <p><strong>Catch Phrase:</strong> {user.company.catchPhrase || '-'}</p>
              <p><strong>Business:</strong> {user.company.bs || '-'}</p>
            </>
          ) : (
            <p className="text-muted">No company information available</p>
          )}
        </Card.Body>
      </Card>
    </div>
  );
};

export default UserView;
