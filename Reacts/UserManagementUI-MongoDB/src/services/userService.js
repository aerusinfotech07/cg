import { apiClient } from '../utils/apiConfig';

const getApiPath = (endpoint = '') => `/api/users${endpoint}`;

const userService = {
  getAllUsers: async () => { const r = await apiClient.get(getApiPath()); return r.data; },
  getUserById: async (id) => { const r = await apiClient.get(getApiPath(`/${id}`)); return r.data; },
  getUserByUsername: async (username) => { const r = await apiClient.get(getApiPath(`/username/${username}`)); return r.data; },
  getUserByEmail: async (email) => { const r = await apiClient.get(getApiPath(`/email/${email}`)); return r.data; },
  createUser: async (userData) => { const r = await apiClient.post(getApiPath(), userData); return r.data; },
  updateUser: async (id, userData) => { const r = await apiClient.put(getApiPath(`/${id}`), userData); return r.data; },
  deleteUser: async (id) => { const r = await apiClient.delete(getApiPath(`/${id}`)); return r.data; }
};

export default userService;
