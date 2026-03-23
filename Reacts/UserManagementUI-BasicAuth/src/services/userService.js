import { apiClient } from '../utils/apiConfig';

const getApiPath = (endpoint = '') => `/api/users${endpoint}`;

const userService = {
  getAllUsers: async () => {
    const response = await apiClient.get(getApiPath());
    return response.data;
  },
  getUserById: async (id) => {
    const response = await apiClient.get(getApiPath(`/${id}`));
    return response.data;
  },
  getUserByUsername: async (username) => {
    const response = await apiClient.get(getApiPath(`/username/${username}`));
    return response.data;
  },
  getUserByEmail: async (email) => {
    const response = await apiClient.get(getApiPath(`/email/${email}`));
    return response.data;
  },
  createUser: async (userData) => {
    const response = await apiClient.post(getApiPath(), userData);
    return response.data;
  },
  updateUser: async (id, userData) => {
    const response = await apiClient.put(getApiPath(`/${id}`), userData);
    return response.data;
  },
  deleteUser: async (id) => {
    const response = await apiClient.delete(getApiPath(`/${id}`));
    return response.data;
  }
};

export default userService;
