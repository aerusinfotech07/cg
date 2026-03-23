import React from 'react';
import ReactDOM from 'react-dom/client';
import 'bootstrap/dist/css/bootstrap.min.css';
import './index.css';
import App from './App';
import './utils/preventRefresh';

// Prevent page refresh on unhandled errors
if (typeof window !== 'undefined') {
  window.addEventListener('error', (event) => {
    event.preventDefault();
    event.stopPropagation();
    console.error('Unhandled error:', event.error);
    return false;
  }, true);

  window.addEventListener('unhandledrejection', (event) => {
    event.preventDefault();
    event.stopPropagation();
    console.error('Unhandled promise rejection:', event.reason);
    return false;
  }, true);

  // Prevent any navigation that might cause refresh
  const originalPushState = window.history.pushState;
  window.history.pushState = function(...args) {
    try {
      return originalPushState.apply(window.history, args);
    } catch (e) {
      console.error('Navigation error:', e);
      return false;
    }
  };
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
