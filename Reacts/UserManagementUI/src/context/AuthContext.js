import React, { createContext, useContext, useState, useEffect } from 'react';
import { isAuthRequired } from '../config/authConfig';
import { setAuth, clearAuth } from '../utils/authStore';

const AuthContext = createContext(null);

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);

  const persistKey = 'usermanagement_ui_auth';

  useEffect(() => {
    if (!isAuthRequired()) {
      setLoading(false);
      return;
    }
    try {
      const raw = localStorage.getItem(persistKey);
      if (raw) {
        const data = JSON.parse(raw);
        if (data.mode === 'basic' && data.username) {
          setAuth('basic', { username: data.username, password: data.password });
          setUser({ username: data.username });
        } else if (data.mode === 'jwt' && data.token) {
          setAuth('jwt', { token: data.token });
          setUser(data.user || { username: 'User' });
        }
      }
    } catch (e) {
      localStorage.removeItem(persistKey);
    }
    setLoading(false);
  }, []);

  useEffect(() => {
    const handleLogout = () => {
      clearAuth();
      setUser(null);
      localStorage.removeItem(persistKey);
    };
    window.addEventListener('auth:logout', handleLogout);
    return () => window.removeEventListener('auth:logout', handleLogout);
  }, []);

  const login = async (username, password) => {
    const { login: authLogin } = await import('../services/authService');
    const result = await authLogin(username, password);
    if (result.mode === 'basic') {
      setAuth('basic', { username: result.username, password: result.password });
      setUser({ username: result.username });
      localStorage.setItem(persistKey, JSON.stringify({
        mode: 'basic',
        username: result.username,
        password: result.password
      }));
    } else if (result.mode === 'jwt' && result.token) {
      setAuth('jwt', { token: result.token });
      setUser(result.user || { username: 'User' });
      localStorage.setItem(persistKey, JSON.stringify({
        mode: 'jwt',
        token: result.token,
        user: result.user
      }));
    }
  };

  const logout = () => {
    clearAuth();
    setUser(null);
    localStorage.removeItem(persistKey);
    window.dispatchEvent(new CustomEvent('auth:logout'));
  };

  const value = {
    isAuthenticated: !!user,
    user,
    login,
    logout,
    loading,
    authRequired: isAuthRequired()
  };

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};

export const useAuth = () => {
  const ctx = useContext(AuthContext);
  if (!ctx) throw new Error('useAuth must be used within AuthProvider');
  return ctx;
};
