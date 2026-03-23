import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';

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
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
