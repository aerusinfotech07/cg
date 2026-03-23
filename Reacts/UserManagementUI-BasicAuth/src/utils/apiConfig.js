import axios from 'axios';
import { getApiBaseUrl } from '../config/authConfig';
import { getAuth } from './authStore';

export const apiClient = axios.create({
  timeout: 10000,
  headers: { 'Content-Type': 'application/json' }
});

apiClient.interceptors.request.use(
  (config) => {
    config.baseURL = getApiBaseUrl();
    config.validateStatus = (status) => status < 500;
    const { username, password } = getAuth();
    if (username && password) {
      config.headers.Authorization = `Basic ${btoa(`${username}:${password}`)}`;
    }
    return config;
  },
  (error) => Promise.reject(error)
);

apiClient.interceptors.response.use(
  (r) => r,
  (error) => {
    if (error.response?.status === 401 && typeof window !== 'undefined') {
      window.dispatchEvent(new CustomEvent('auth:logout'));
    }
    console.error('API Error:', error.response?.status, error.response?.data);
    return Promise.reject(error);
  }
);
