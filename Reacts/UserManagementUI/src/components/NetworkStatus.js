import React, { useState, useEffect } from 'react';
import { Alert } from 'react-bootstrap';

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
      <Alert variant="warning" dismissible onClose={() => setShowAlert(false)}>
        <Alert.Heading>Network Offline</Alert.Heading>
        <p>You are currently offline. Please check your internet connection.</p>
      </Alert>
    );
  }

  return null;
};

export default NetworkStatus;
