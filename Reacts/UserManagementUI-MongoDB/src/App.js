import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import UserList from './components/UserList';
import UserForm from './components/UserForm';
import UserView from './components/UserView';
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
