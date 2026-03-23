import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import UserList from './components/UserList';
import UserForm from './components/UserForm';
import UserView from './components/UserView';
import ErrorBoundary from './components/ErrorBoundary';
import NetworkStatus from './components/NetworkStatus';
import './App.css';

function App() {
  // Prevent page refresh on errors
  React.useEffect(() => {
    const handleError = (event) => {
      event.preventDefault();
      console.error('Global error:', event.error);
      return false;
    };

    const handleUnhandledRejection = (event) => {
      event.preventDefault();
      console.error('Unhandled promise rejection:', event.reason);
      return false;
    };

    window.addEventListener('error', handleError);
    window.addEventListener('unhandledrejection', handleUnhandledRejection);

    return () => {
      window.removeEventListener('error', handleError);
      window.removeEventListener('unhandledrejection', handleUnhandledRejection);
    };
  }, []);

  return (
    <ErrorBoundary>
      <Router basename={process.env.PUBLIC_URL || ''}>
        <div className="app-container">
          <NetworkStatus />
          <Routes>
            <Route path="/" element={<UserList />} />
            <Route path="/create" element={<UserForm />} />
            <Route path="/edit/:id" element={<UserForm />} />
            <Route path="/view/:id" element={<UserView />} />
            <Route path="*" element={<Navigate to="/" replace />} />
          </Routes>
        </div>
      </Router>
    </ErrorBoundary>
  );
}

export default App;
