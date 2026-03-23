/** Base URL for UserManagementNodeAPI-BasicAuth (default port 8084) */
const API_BASE_URL = process.env.REACT_APP_API_BASE_URL || 'http://localhost:8084';
export const getApiBaseUrl = () => API_BASE_URL.replace(/\/$/, '');
