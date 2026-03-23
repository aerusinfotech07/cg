/**
 * Auth and API base URL configuration.
 * Set via environment variables (see .env.example).
 *
 * Backends:
 * - Basic Auth: UserManagementNodeAPI-BasicAuth (MySQL) – REACT_APP_AUTH_MODE=basic
 * - JWT: UserManagementNodeAPI-JWT (MySQL) – REACT_APP_AUTH_MODE=jwt
 * - MongoDB: UserManagementNodeAPI-MongoDB (no auth by default) – REACT_APP_AUTH_MODE=none, REACT_APP_API_BASE_URL to MongoDB API
 *   If you add JWT to MongoDB API, use REACT_APP_AUTH_MODE=jwt and point URL to that API.
 */
const API_BASE_URL = process.env.REACT_APP_API_BASE_URL || 'http://localhost:8084';
const AUTH_MODE = (process.env.REACT_APP_AUTH_MODE || 'none').toLowerCase(); // 'none' | 'basic' | 'jwt'

export const getApiBaseUrl = () => API_BASE_URL.replace(/\/$/, '');
export const getAuthMode = () => AUTH_MODE;
export const isAuthRequired = () => AUTH_MODE === 'basic' || AUTH_MODE === 'jwt';

/** Login endpoint for JWT (relative to base URL) */
export const getLoginUrl = () => `${getApiBaseUrl()}/auth/login`;
