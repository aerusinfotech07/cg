import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';
import { login as authLogin } from '../services/authService';
import './components.css';

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(false);
  const { login } = useAuth();
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError(null);
    if (!username.trim() || !password) {
      setError('Username and password required');
      return;
    }
    setLoading(true);
    try {
      const { token, user: userData } = await authLogin(username.trim(), password);
      login(token, userData);
      navigate('/', { replace: true });
    } catch (err) {
      setError(err.response?.data?.message || err.message || 'Login failed');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="login-wrapper">
      <div className="card" style={{ maxWidth: 400, margin: '60px auto' }}>
        <div className="card-header">Sign in (JWT)</div>
        <div className="card-body">
          {error && (
            <div className="error-message">
              {error}
              <button type="button" className="close-btn" onClick={() => setError(null)}>×</button>
            </div>
          )}
          <form onSubmit={handleSubmit} className="form-container" style={{ padding: 0, boxShadow: 'none' }}>
            <div className="form-group">
              <label>Username</label>
              <input type="text" className="form-control" value={username} onChange={(e) => setUsername(e.target.value)} autoComplete="username" />
            </div>
            <div className="form-group">
              <label>Password</label>
              <input type="password" className="form-control" value={password} onChange={(e) => setPassword(e.target.value)} autoComplete="current-password" />
            </div>
            <button type="submit" className="btn btn-primary" style={{ width: '100%' }} disabled={loading}>{loading ? 'Signing in...' : 'Sign in'}</button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Login;
