import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { Form, Button, Card, Alert } from 'react-bootstrap';
import { useAuth } from '../context/AuthContext';

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(false);
  const { login, isAuthenticated, authRequired } = useAuth();
  const navigate = useNavigate();

  useEffect(() => {
    if (!authRequired) {
      navigate('/', { replace: true });
      return;
    }
    if (isAuthenticated) {
      navigate('/', { replace: true });
    }
  }, [authRequired, isAuthenticated, navigate]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError(null);
    setLoading(true);
    try {
      await login(username.trim(), password);
      navigate('/', { replace: true });
    } catch (err) {
      const msg = err.response?.data?.message || err.message || 'Login failed';
      setError(msg);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="d-flex justify-content-center align-items-center" style={{ minHeight: '60vh' }}>
      <Card style={{ width: '100%', maxWidth: 400 }}>
        <Card.Header className="text-center">
          <h5 className="mb-0">User Management – Sign in</h5>
        </Card.Header>
        <Card.Body>
          {error && (
            <Alert variant="danger" dismissible onClose={() => setError(null)}>
              {error}
            </Alert>
          )}
          <Form onSubmit={handleSubmit}>
            <Form.Group className="mb-3">
              <Form.Label>Username</Form.Label>
              <Form.Control
                type="text"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                placeholder="Username"
                required
                autoComplete="username"
              />
            </Form.Group>
            <Form.Group className="mb-3">
              <Form.Label>Password</Form.Label>
              <Form.Control
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                placeholder="Password"
                required
                autoComplete="current-password"
              />
            </Form.Group>
            <Button variant="primary" type="submit" className="w-100" disabled={loading}>
              {loading ? 'Signing in...' : 'Sign in'}
            </Button>
          </Form>
        </Card.Body>
      </Card>
    </div>
  );
};

export default Login;
