import { apiClient } from '../utils/apiConfig';

// Get API endpoint path
const getApiPath = (endpoint = '') => {
  return `/api/users${endpoint}`;
};

const userService = {
  // Get all users
  getAllUsers: async () => {
    try {
      const response = await apiClient.get(getApiPath());
      return response.data;
    } catch (error) {
      console.error('Error fetching users:', error);
      const errorMessage = error.response?.data?.message || error.message || 'Failed to load users';
      throw new Error(errorMessage);
    }
  },

  // Get user by ID
  getUserById: async (id) => {
    try {
      const response = await apiClient.get(getApiPath(`/${id}`));
      return response.data;
    } catch (error) {
      console.error('Error fetching user:', error);
      const errorMessage = error.response?.data?.message || error.message || 'Failed to load user';
      throw new Error(errorMessage);
    }
  },

  // Get user by username
  getUserByUsername: async (username) => {
    try {
      const response = await apiClient.get(getApiPath(`/username/${username}`));
      return response.data;
    } catch (error) {
      console.error('Error fetching user by username:', error);
      const errorMessage = error.response?.data?.message || error.message || 'Failed to load user';
      throw new Error(errorMessage);
    }
  },

  // Get user by email
  getUserByEmail: async (email) => {
    try {
      const response = await apiClient.get(getApiPath(`/email/${email}`));
      return response.data;
    } catch (error) {
      console.error('Error fetching user by email:', error);
      const errorMessage = error.response?.data?.message || error.message || 'Failed to load user';
      throw new Error(errorMessage);
    }
  },

  // Create user
  createUser: async (userData) => {
    try {
      const response = await apiClient.post(getApiPath(), userData);
      return response.data;
    } catch (error) {
      console.error('Error creating user:', error);
      const errorMessage = error.response?.data?.message || error.message || 'Failed to create user';
      throw new Error(errorMessage);
    }
  },

  // Update user
  updateUser: async (id, userData) => {
    try {
      const response = await apiClient.put(getApiPath(`/${id}`), userData);
      return response.data;
    } catch (error) {
      console.error('Error updating user:', error);
      const errorMessage = error.response?.data?.message || error.message || 'Failed to update user';
      throw new Error(errorMessage);
    }
  },

  // Delete user
  deleteUser: async (id) => {
    try {
      const response = await apiClient.delete(getApiPath(`/${id}`));
      return response.data;
    } catch (error) {
      console.error('Error deleting user:', error);
      const errorMessage = error.response?.data?.message || error.message || 'Failed to delete user';
      throw new Error(errorMessage);
    }
  }
};

export default userService;
