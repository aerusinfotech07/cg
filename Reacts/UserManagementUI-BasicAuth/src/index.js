import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';

if (typeof window !== 'undefined') {
  window.addEventListener('error', (e) => { e.preventDefault(); e.stopPropagation(); return false; }, true);
  window.addEventListener('unhandledrejection', (e) => { e.preventDefault(); e.stopPropagation(); return false; }, true);
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<React.StrictMode><App /></React.StrictMode>);
