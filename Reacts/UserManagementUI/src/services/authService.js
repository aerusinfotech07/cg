import { getAuthMode, getLoginUrl } from '../config/authConfig';
import axios from 'axios';

/**
 * Login for JWT: POST /auth/login, returns { token, user }.
 * For Basic Auth we don't call an endpoint; credentials are sent on each request.
 */
export const login = async (username, password) => {
  const mode = getAuthMode();
  if (mode === 'basic') {
    return { mode: 'basic', username, password };
  }
  if (mode === 'jwt') {
    const url = getLoginUrl();
    const { data } = await axios.post(url, { username, password }, {
      timeout: 10000,
      headers: { 'Content-Type': 'application/json' }
    });
    if (!data || !data.token) {
      throw new Error(data?.message || 'Invalid login response');
    }
    return { mode: 'jwt', token: data.token, user: data.user };
  }
  throw new Error('Auth mode is not configured');
};
