import React, { createContext, useContext, useState, useEffect } from 'react';
import { setToken, clearAuth } from '../utils/authStore';

const AuthContext = createContext(null);

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);
  const key = 'usermanagement_jwt';

  useEffect(() => {
    try {
      const raw = localStorage.getItem(key);
      if (raw) {
        const data = JSON.parse(raw);
        if (data.token) {
          setToken(data.token);
          setUser(data.user || { username: 'User' });
        }
      }
    } catch (e) {
      localStorage.removeItem(key);
    }
    setLoading(false);
  }, []);

  useEffect(() => {
    const h = () => {
      clearAuth();
      setUser(null);
      localStorage.removeItem(key);
    };
    window.addEventListener('auth:logout', h);
    return () => window.removeEventListener('auth:logout', h);
  }, []);

  const login = (token, userData) => {
    setToken(token);
    setUser(userData || { username: 'User' });
    localStorage.setItem(key, JSON.stringify({ token, user: userData }));
  };

  const logout = () => {
    clearAuth();
    setUser(null);
    localStorage.removeItem(key);
    window.dispatchEvent(new CustomEvent('auth:logout'));
  };

  return (
    <AuthContext.Provider value={{ isAuthenticated: !!user, user, login, logout, loading }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => {
  const c = useContext(AuthContext);
  if (!c) throw new Error('useAuth must be used within AuthProvider');
  return c;
};
