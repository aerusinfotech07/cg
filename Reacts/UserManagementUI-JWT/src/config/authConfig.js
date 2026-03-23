const API_BASE_URL = process.env.REACT_APP_API_BASE_URL || 'http://localhost:8084';
export const getApiBaseUrl = () => API_BASE_URL.replace(/\/$/, '');
export const getLoginUrl = () => `${getApiBaseUrl()}/auth/login`;
