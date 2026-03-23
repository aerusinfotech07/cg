import React, { useState, useEffect } from 'react';

const NetworkStatus = () => {
  const [isOnline, setIsOnline] = useState(navigator.onLine);
  const [showAlert, setShowAlert] = useState(false);

  useEffect(() => {
    const handleOnline = () => {
      setIsOnline(true);
      setShowAlert(false);
    };

    const handleOffline = () => {
      setIsOnline(false);
      setShowAlert(true);
    };

    window.addEventListener('online', handleOnline);
    window.addEventListener('offline', handleOffline);

    return () => {
      window.removeEventListener('online', handleOnline);
      window.removeEventListener('offline', handleOffline);
    };
  }, []);

  if (!isOnline && showAlert) {
    return (
      <div className="error-message">
        <strong>Network Offline</strong>
        <p>You are currently offline. Please check your internet connection.</p>
        <button className="close-btn" onClick={() => setShowAlert(false)}>Ã—</button>
      </div>
    );
  }

  return null;
};

export default NetworkStatus;
