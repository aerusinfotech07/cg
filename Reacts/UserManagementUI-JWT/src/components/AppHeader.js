import React from 'react';
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';
import './components.css';

const AppHeader = () => {
  const { isAuthenticated, user, logout } = useAuth();
  const navigate = useNavigate();
  if (!isAuthenticated) return null;
  return (
    <div className="app-header-bar">
      <span>Signed in as <strong>{user?.username}</strong></span>
      <button type="button" className="btn btn-secondary btn-sm" onClick={() => { logout(); navigate('/login', { replace: true }); }}>Logout</button>
    </div>
  );
};

export default AppHeader;
