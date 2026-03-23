import axios from 'axios';
import { getLoginUrl } from '../config/authConfig';

export const login = async (username, password) => {
  const { data } = await axios.post(getLoginUrl(), { username, password }, {
    timeout: 10000,
    headers: { 'Content-Type': 'application/json' }
  });
  if (!data || !data.token) throw new Error(data?.message || 'Invalid login response');
  return { token: data.token, user: data.user };
};
