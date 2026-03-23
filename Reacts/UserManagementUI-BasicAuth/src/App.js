import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import { AuthProvider } from './context/AuthContext';
import UserList from './components/UserList';
import UserForm from './components/UserForm';
import UserView from './components/UserView';
import Login from './components/Login';
import AppHeader from './components/AppHeader';
import ProtectedRoute from './components/ProtectedRoute';
import ErrorBoundary from './components/ErrorBoundary';
import NetworkStatus from './components/NetworkStatus';
import './App.css';

function App() {
  React.useEffect(() => {
    const handleError = (e) => { e.preventDefault(); return false; };
    const handleRejection = (e) => { e.preventDefault(); return false; };
    window.addEventListener('error', handleError);
    window.addEventListener('unhandledrejection', handleRejection);
    return () => {
      window.removeEventListener('error', handleError);
      window.removeEventListener('unhandledrejection', handleRejection);
    };
  }, []);

  return (
    <ErrorBoundary>
      <AuthProvider>
        <Router basename={process.env.PUBLIC_URL || ''}>
          <div className="app-container">
            <AppHeader />
            <NetworkStatus />
            <Routes>
              <Route path="/login" element={<Login />} />
              <Route path="/" element={<ProtectedRoute><UserList /></ProtectedRoute>} />
              <Route path="/create" element={<ProtectedRoute><UserForm /></ProtectedRoute>} />
              <Route path="/edit/:id" element={<ProtectedRoute><UserForm /></ProtectedRoute>} />
              <Route path="/view/:id" element={<ProtectedRoute><UserView /></ProtectedRoute>} />
              <Route path="*" element={<Navigate to="/" replace />} />
            </Routes>
          </div>
        </Router>
      </AuthProvider>
    </ErrorBoundary>
  );
}

export default App;
