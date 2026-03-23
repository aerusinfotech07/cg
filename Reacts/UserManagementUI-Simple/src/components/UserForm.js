import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import userService from '../services/userService';
import './components.css';

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
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    const keys = name.split('.');
    
    if (keys.length === 1) {
      setFormData(prev => ({ ...prev, [name]: value }));
    } else if (keys.length === 2) {
      setFormData(prev => ({
        ...prev,
        [keys[0]]: {
          ...prev[keys[0]],
          [keys[1]]: value
        }
      }));
    } else if (keys.length === 3) {
      setFormData(prev => ({
        ...prev,
        [keys[0]]: {
          ...prev[keys[0]],
          [keys[1]]: {
            ...prev[keys[0]][keys[1]],
            [keys[2]]: value
          }
        }
      }));
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    e.stopPropagation();
    
    try {
      setLoading(true);
      setError(null);
      setSuccess(null);

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
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  if (loading && isEditMode) {
    return (
      <div>
        <div className="page-header">
          <h1>{isEditMode ? 'Edit User' : 'Create User'}</h1>
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
        <h1>{isEditMode ? 'Edit User' : 'Create User'}</h1>
      </div>

      {error && (
        <div className="error-message">
          {error}
          <button className="close-btn" onClick={() => setError(null)}>Ã—</button>
        </div>
      )}

      {success && (
        <div className="success-message">
          {success}
        </div>
      )}

      <form className="form-container" onSubmit={handleSubmit} noValidate>
        <div className="form-group">
          <label htmlFor="name">Name *</label>
          <input
            type="text"
            id="name"
            name="name"
            className="form-control"
            value={formData.name}
            onChange={handleChange}
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="username">Username *</label>
          <input
            type="text"
            id="username"
            name="username"
            className="form-control"
            value={formData.username}
            onChange={handleChange}
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="email">Email *</label>
          <input
            type="email"
            id="email"
            name="email"
            className="form-control"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="phone">Phone</label>
          <input
            type="tel"
            id="phone"
            name="phone"
            className="form-control"
            value={formData.phone}
            onChange={handleChange}
          />
        </div>

        <div className="form-group">
          <label htmlFor="website">Website</label>
          <input
            type="url"
            id="website"
            name="website"
            className="form-control"
            value={formData.website}
            onChange={handleChange}
          />
        </div>

        <h3 style={{ marginTop: '30px', marginBottom: '20px', color: '#333' }}>Address</h3>

        <div className="form-group">
          <label htmlFor="address.street">Street</label>
          <input
            type="text"
            id="address.street"
            name="address.street"
            className="form-control"
            value={formData.address.street}
            onChange={handleChange}
          />
        </div>

        <div className="form-group">
          <label htmlFor="address.suite">Suite</label>
          <input
            type="text"
            id="address.suite"
            name="address.suite"
            className="form-control"
            value={formData.address.suite}
            onChange={handleChange}
          />
        </div>

        <div className="form-group">
          <label htmlFor="address.city">City</label>
          <input
            type="text"
            id="address.city"
            name="address.city"
            className="form-control"
            value={formData.address.city}
            onChange={handleChange}
          />
        </div>

        <div className="form-group">
          <label htmlFor="address.zipcode">Zipcode</label>
          <input
            type="text"
            id="address.zipcode"
            name="address.zipcode"
            className="form-control"
            value={formData.address.zipcode}
            onChange={handleChange}
          />
        </div>

        <h4 style={{ marginTop: '20px', marginBottom: '15px', color: '#555' }}>Geo Location</h4>

        <div className="form-group">
          <label htmlFor="address.geo.lat">Latitude</label>
          <input
            type="text"
            id="address.geo.lat"
            name="address.geo.lat"
            className="form-control"
            value={formData.address.geo.lat}
            onChange={handleChange}
          />
        </div>

        <div className="form-group">
          <label htmlFor="address.geo.lng">Longitude</label>
          <input
            type="text"
            id="address.geo.lng"
            name="address.geo.lng"
            className="form-control"
            value={formData.address.geo.lng}
            onChange={handleChange}
          />
        </div>

        <h3 style={{ marginTop: '30px', marginBottom: '20px', color: '#333' }}>Company</h3>

        <div className="form-group">
          <label htmlFor="company.name">Company Name</label>
          <input
            type="text"
            id="company.name"
            name="company.name"
            className="form-control"
            value={formData.company.name}
            onChange={handleChange}
          />
        </div>

        <div className="form-group">
          <label htmlFor="company.catchPhrase">Catch Phrase</label>
          <input
            type="text"
            id="company.catchPhrase"
            name="company.catchPhrase"
            className="form-control"
            value={formData.company.catchPhrase}
            onChange={handleChange}
          />
        </div>

        <div className="form-group">
          <label htmlFor="company.bs">BS</label>
          <input
            type="text"
            id="company.bs"
            name="company.bs"
            className="form-control"
            value={formData.company.bs}
            onChange={handleChange}
          />
        </div>

        <div className="action-buttons">
          <button type="submit" className="btn btn-success" disabled={loading}>
            {loading ? 'Saving...' : (isEditMode ? 'Update User' : 'Create User')}
          </button>
          <button type="button" className="btn btn-secondary" onClick={() => navigate('/')}>
            Cancel
          </button>
        </div>
      </form>
    </div>
  );
};

export default UserForm;
