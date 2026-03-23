import React from 'react';
import { useNavigate } from 'react-router-dom';
import { Button, Navbar, Container } from 'react-bootstrap';
import { useAuth } from '../context/AuthContext';

const AppHeader = () => {
  const { isAuthenticated, user, logout, authRequired } = useAuth();
  const navigate = useNavigate();

  if (!authRequired || !isAuthenticated) {
    return null;
  }

  const handleLogout = () => {
    logout();
    navigate('/login', { replace: true });
  };

  return (
    <Navbar bg="dark" variant="dark" className="mb-3">
      <Container fluid>
        <Navbar.Brand>User Management</Navbar.Brand>
        <Navbar.Collapse className="justify-content-end">
          <Navbar.Text className="me-3">
            {user?.username && <span>Signed in as <strong>{user.username}</strong></span>}
          </Navbar.Text>
          <Button variant="outline-light" size="sm" onClick={handleLogout}>
            Logout
          </Button>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default AppHeader;
