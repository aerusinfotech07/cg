import axios from 'axios';
import { getApiBaseUrl, getAuthMode } from '../config/authConfig';
import { getAuth } from './authStore';

export const getApiBaseUrlForExport = () => getApiBaseUrl();

export const apiClient = axios.create({
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json'
  }
});

apiClient.interceptors.request.use(
  (config) => {
    const baseURL = getApiBaseUrl();
    config.baseURL = baseURL;
    config.validateStatus = (status) => status < 500;

    const authMode = getAuthMode();
    const auth = getAuth();
    if (authMode === 'basic' && auth.basic) {
      const encoded = btoa(`${auth.basic.username}:${auth.basic.password}`);
      config.headers.Authorization = `Basic ${encoded}`;
    } else if (authMode === 'jwt' && auth.jwt) {
      config.headers.Authorization = `Bearer ${auth.jwt}`;
    }

    return config;
  },
  (error) => {
    console.error('Request error:', error);
    return Promise.reject(error);
  }
);

apiClient.interceptors.response.use(
  (response) => response,
  (error) => {
    if (error.response?.status === 401 && typeof window !== 'undefined' && window.dispatchEvent) {
      window.dispatchEvent(new CustomEvent('auth:logout'));
    }
    try {
      if (error.response) {
        console.error('API Error:', error.response.status, error.response.data);
      } else if (error.request) {
        console.error('Network Error:', error.request);
      } else {
        console.error('Error:', error.message);
      }
    } catch (e) {
      console.error('Error in error handler:', e);
    }
    return Promise.reject(error);
  }
);
