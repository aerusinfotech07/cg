import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import userService from '../services/userService';
import './components.css';

const UserView = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => { loadUser(); }, [id]);

  const loadUser = async () => {
    try {
      setLoading(true);
      setError(null);
      const data = await userService.getUserById(id);
      setUser(data);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  if (loading) return (<div><div className="page-header"><h1>User Details</h1></div><div className="loading-spinner"><div className="spinner" /></div></div>);
  if (error) return (<div><div className="page-header"><h1>User Details</h1></div><div className="error-message">{error}<button type="button" className="close-btn" onClick={() => navigate('/')}>×</button></div></div>);
  if (!user) return (<div><div className="page-header"><h1>User Details</h1></div><div className="error-message">User not found</div></div>);

  return (
    <div>
      <div className="page-header"><h1>User Details</h1></div>
      <div className="card">
        <div className="card-header">Basic Information</div>
        <div className="card-body">
          <div style={{ marginBottom: 15 }}><strong>ID:</strong> {user.id}</div>
          <div style={{ marginBottom: 15 }}><strong>Name:</strong> {user.name}</div>
          <div style={{ marginBottom: 15 }}><strong>Username:</strong> {user.username}</div>
          <div style={{ marginBottom: 15 }}><strong>Email:</strong> {user.email}</div>
          <div style={{ marginBottom: 15 }}><strong>Phone:</strong> {user.phone || 'N/A'}</div>
          <div style={{ marginBottom: 15 }}><strong>Website:</strong> {user.website || 'N/A'}</div>
        </div>
      </div>
      {user.address && (
        <div className="card">
          <div className="card-header">Address</div>
          <div className="card-body">
            <div style={{ marginBottom: 15 }}><strong>Street:</strong> {user.address.street || 'N/A'}</div>
            <div style={{ marginBottom: 15 }}><strong>Suite:</strong> {user.address.suite || 'N/A'}</div>
            <div style={{ marginBottom: 15 }}><strong>City:</strong> {user.address.city || 'N/A'}</div>
            <div style={{ marginBottom: 15 }}><strong>Zipcode:</strong> {user.address.zipcode || 'N/A'}</div>
            {user.address.geo && (
              <>
                <div style={{ marginBottom: 15 }}><strong>Latitude:</strong> {user.address.geo.lat || 'N/A'}</div>
                <div style={{ marginBottom: 15 }}><strong>Longitude:</strong> {user.address.geo.lng || 'N/A'}</div>
              </>
            )}
          </div>
        </div>
      )}
      {user.company && (
        <div className="card">
          <div className="card-header">Company</div>
          <div className="card-body">
            <div style={{ marginBottom: 15 }}><strong>Name:</strong> {user.company.name || 'N/A'}</div>
            <div style={{ marginBottom: 15 }}><strong>Catch Phrase:</strong> {user.company.catchPhrase || 'N/A'}</div>
            <div style={{ marginBottom: 15 }}><strong>BS:</strong> {user.company.bs || 'N/A'}</div>
          </div>
        </div>
      )}
      <div className="action-buttons">
        <button className="btn btn-warning" onClick={() => navigate(`/edit/${user.id}`)}>Edit User</button>
        <button className="btn btn-secondary" onClick={() => navigate('/')}>Back to List</button>
      </div>
    </div>
  );
};

export default UserView;
