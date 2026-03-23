import axios from 'axios';

/** Base URL for UserManagementNodeAPI-MongoDB (default port 8084). User IDs are strings (MongoDB ObjectId). */
const API_BASE_URL = process.env.REACT_APP_API_BASE_URL || 'http://localhost:8084';

export const getApiBaseUrl = () => API_BASE_URL.replace(/\/$/, '');

export const apiClient = axios.create({
  timeout: 10000,
  headers: { 'Content-Type': 'application/json' }
});

apiClient.interceptors.request.use(
  (config) => {
    config.baseURL = getApiBaseUrl();
    config.validateStatus = (status) => status < 500;
    return config;
  },
  (error) => Promise.reject(error)
);

apiClient.interceptors.response.use(
  (r) => r,
  (error) => {
    console.error('API Error:', error.response?.status, error.response?.data);
    return Promise.reject(error);
  }
);
