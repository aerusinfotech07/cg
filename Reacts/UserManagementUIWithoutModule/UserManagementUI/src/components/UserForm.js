import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { Form, Button, Card, Alert, Row, Col } from 'react-bootstrap';
import userService from '../services/userService';

const UserForm = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const isEditMode = !!id;

  const [formData, setFormData] = useState({
    name: '',
    username: '',
    email: '',
    phone: '',
    website: '',
    address: {
      street: '',
      suite: '',
      city: '',
      zipcode: '',
      geo: {
        lat: '',
        lng: ''
      }
    },
    company: {
      name: '',
      catchPhrase: '',
      bs: ''
    }
  });

  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [success, setSuccess] = useState(null);

  useEffect(() => {
    if (isEditMode) {
      loadUser();
    }
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [id]);

  const loadUser = async () => {
    try {
      setLoading(true);
      const user = await userService.getUserById(id);
      setFormData({
        name: user.name || '',
        username: user.username || '',
        email: user.email || '',
        phone: user.phone || '',
        website: user.website || '',
        address: {
          street: user.address?.street || '',
          suite: user.address?.suite || '',
          city: user.address?.city || '',
          zipcode: user.address?.zipcode || '',
          geo: {
            lat: user.address?.geo?.lat || '',
            lng: user.address?.geo?.lng || ''
          }
        },
        company: {
          name: user.company?.name || '',
          catchPhrase: user.company?.catchPhrase || '',
          bs: user.company?.bs || ''
        }
      });
    } catch (err) {
      setError(err.message || 'Failed to load user');
    } finally {
      setLoading(false);
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    const keys = name.split('.');
    
    if (keys.length === 1) {
      setFormData({ ...formData, [name]: value });
    } else if (keys.length === 2) {
      setFormData({
        ...formData,
        [keys[0]]: {
          ...formData[keys[0]],
          [keys[1]]: value
        }
      });
    } else if (keys.length === 3) {
      setFormData({
        ...formData,
        [keys[0]]: {
          ...formData[keys[0]],
          [keys[1]]: {
            ...formData[keys[0]][keys[1]],
            [keys[2]]: value
          }
        }
      });
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    e.stopPropagation();
    setError(null);
    setSuccess(null);
    setLoading(true);

    try {
      if (isEditMode) {
        await userService.updateUser(id, formData);
        setSuccess('User updated successfully!');
      } else {
        await userService.createUser(formData);
        setSuccess('User created successfully!');
      }
      
      setTimeout(() => {
        navigate('/');
      }, 1500);
    } catch (err) {
      const errorMessage = err?.message || err?.response?.data?.message || `Failed to ${isEditMode ? 'update' : 'create'} user`;
      setError(errorMessage);
      console.error('Error submitting form:', err);
      // Don't refresh page on error
    } finally {
      setLoading(false);
    }
  };

  return (
    <div>
      <div className="page-header">
        <h1>{isEditMode ? 'Edit User' : 'Create New User'}</h1>
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
          <h5 className="mb-0">{isEditMode ? 'Edit User Information' : 'User Information'}</h5>
        </Card.Header>
        <Card.Body>
          <Form onSubmit={handleSubmit} noValidate>
            <Row>
              <Col md={6}>
                <Form.Group className="mb-3">
                  <Form.Label>Name *</Form.Label>
                  <Form.Control
                    type="text"
                    name="name"
                    value={formData.name}
                    onChange={handleChange}
                    required
                    placeholder="Enter full name"
                  />
                </Form.Group>
              </Col>
              <Col md={6}>
                <Form.Group className="mb-3">
                  <Form.Label>Username *</Form.Label>
                  <Form.Control
                    type="text"
                    name="username"
                    value={formData.username}
                    onChange={handleChange}
                    required
                    placeholder="Enter username"
                  />
                </Form.Group>
              </Col>
            </Row>

            <Row>
              <Col md={6}>
                <Form.Group className="mb-3">
                  <Form.Label>Email *</Form.Label>
                  <Form.Control
                    type="email"
                    name="email"
                    value={formData.email}
                    onChange={handleChange}
                    required
                    placeholder="Enter email"
                  />
                </Form.Group>
              </Col>
              <Col md={6}>
                <Form.Group className="mb-3">
                  <Form.Label>Phone</Form.Label>
                  <Form.Control
                    type="text"
                    name="phone"
                    value={formData.phone}
                    onChange={handleChange}
                    placeholder="Enter phone number"
                  />
                </Form.Group>
              </Col>
            </Row>

            <Form.Group className="mb-3">
              <Form.Label>Website</Form.Label>
              <Form.Control
                type="text"
                name="website"
                value={formData.website}
                onChange={handleChange}
                placeholder="Enter website URL"
              />
            </Form.Group>

            <hr />
            <h5 className="mb-3">Address Information</h5>

            <Row>
              <Col md={6}>
                <Form.Group className="mb-3">
                  <Form.Label>Street *</Form.Label>
                  <Form.Control
                    type="text"
                    name="address.street"
                    value={formData.address.street}
                    onChange={handleChange}
                    required
                    placeholder="Enter street"
                  />
                </Form.Group>
              </Col>
              <Col md={6}>
                <Form.Group className="mb-3">
                  <Form.Label>Suite</Form.Label>
                  <Form.Control
                    type="text"
                    name="address.suite"
                    value={formData.address.suite}
                    onChange={handleChange}
                    placeholder="Enter suite"
                  />
                </Form.Group>
              </Col>
            </Row>

            <Row>
              <Col md={6}>
                <Form.Group className="mb-3">
                  <Form.Label>City *</Form.Label>
                  <Form.Control
                    type="text"
                    name="address.city"
                    value={formData.address.city}
                    onChange={handleChange}
                    required
                    placeholder="Enter city"
                  />
                </Form.Group>
              </Col>
              <Col md={6}>
                <Form.Group className="mb-3">
                  <Form.Label>Zipcode *</Form.Label>
                  <Form.Control
                    type="text"
                    name="address.zipcode"
                    value={formData.address.zipcode}
                    onChange={handleChange}
                    required
                    placeholder="Enter zipcode"
                  />
                </Form.Group>
              </Col>
            </Row>

            <h6 className="mb-3">Geographic Coordinates</h6>
            <Row>
              <Col md={6}>
                <Form.Group className="mb-3">
                  <Form.Label>Latitude</Form.Label>
                  <Form.Control
                    type="text"
                    name="address.geo.lat"
                    value={formData.address.geo.lat}
                    onChange={handleChange}
                    placeholder="Enter latitude"
                  />
                </Form.Group>
              </Col>
              <Col md={6}>
                <Form.Group className="mb-3">
                  <Form.Label>Longitude</Form.Label>
                  <Form.Control
                    type="text"
                    name="address.geo.lng"
                    value={formData.address.geo.lng}
                    onChange={handleChange}
                    placeholder="Enter longitude"
                  />
                </Form.Group>
              </Col>
            </Row>

            <hr />
            <h5 className="mb-3">Company Information</h5>

            <Form.Group className="mb-3">
              <Form.Label>Company Name *</Form.Label>
              <Form.Control
                type="text"
                name="company.name"
                value={formData.company.name}
                onChange={handleChange}
                required
                placeholder="Enter company name"
              />
            </Form.Group>

            <Form.Group className="mb-3">
              <Form.Label>Catch Phrase</Form.Label>
              <Form.Control
                type="text"
                name="company.catchPhrase"
                value={formData.company.catchPhrase}
                onChange={handleChange}
                placeholder="Enter catch phrase"
              />
            </Form.Group>

            <Form.Group className="mb-3">
              <Form.Label>Business</Form.Label>
              <Form.Control
                type="text"
                name="company.bs"
                value={formData.company.bs}
                onChange={handleChange}
                placeholder="Enter business description"
              />
            </Form.Group>

            <div className="d-flex justify-content-end gap-2">
              <Button
                variant="secondary"
                onClick={() => navigate('/')}
                disabled={loading}
              >
                Cancel
              </Button>
              <Button
                variant="primary"
                type="submit"
                disabled={loading}
              >
                {loading ? 'Saving...' : isEditMode ? 'Update User' : 'Create User'}
              </Button>
            </div>
          </Form>
        </Card.Body>
      </Card>
    </div>
  );
};

export default UserForm;
