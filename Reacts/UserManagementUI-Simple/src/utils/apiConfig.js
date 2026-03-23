// API Configuration utility
import axios from 'axios';

export const getApiBaseUrl = () => {
    
  // Otherwise, use the same hostname but port 8080
  const apiUrl = `http://103.180.237.120:8080/api/users`;
  console.log('API Base URL:', apiUrl); // Debug log
  return apiUrl;
};

// Create axios instance with default config
export const apiClient = axios.create({
  timeout: 10000, // 10 seconds timeout
  headers: {
    'Content-Type': 'application/json'
  }
});

// Add request interceptor to set base URL dynamically
apiClient.interceptors.request.use(
  (config) => {
    // Set the base URL dynamically for each request
    const baseURL = getApiBaseUrl().replace('/api/users', '');
    config.baseURL = baseURL;
    // Prevent page refresh on request errors
    config.validateStatus = function (status) {
      return status < 500; // Don't throw for client errors (4xx)
    };
    return config;
  },
  (error) => {
    console.error('Request error:', error);
    // Prevent page refresh
    return Promise.reject(error);
  }
);

// Add response interceptor for error handling
apiClient.interceptors.response.use(
  (response) => {
    return response;
  },
  (error) => {
    // Prevent page refresh on API errors
    try {
      if (error.response) {
        console.error('API Error:', error.response.status, error.response.data);
        // CORS errors might cause refresh - handle them specially
        if (error.response.status === 0 || !error.response.status) {
          console.error('Possible CORS error - check backend CORS configuration');
        }
      } else if (error.request) {
        console.error('Network Error - No response received:', error.request);
        // Network errors - don't refresh page, just log
      } else {
        console.error('Error:', error.message);
      }
    } catch (e) {
      console.error('Error in error handler:', e);
    }
    
    // Always reject to let components handle errors, but prevent page refresh
    // Wrap in try-catch to prevent any errors from propagating
    try {
      return Promise.reject(error);
    } catch (e) {
      console.error('Error rejecting promise:', e);
      return Promise.resolve({ data: null, error: error.message });
    }
  }
);
