import React, { createContext, useContext, useState, useEffect } from 'react';
import { setAuth, clearAuth } from '../utils/authStore';

const AuthContext = createContext(null);

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);
  const key = 'usermanagement_basicauth';

  useEffect(() => {
    try {
      const raw = localStorage.getItem(key);
      if (raw) {
        const { username, password } = JSON.parse(raw);
        if (username && password) {
          setAuth(username, password);
          setUser({ username });
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

  const login = (username, password) => {
    setAuth(username, password);
    setUser({ username });
    localStorage.setItem(key, JSON.stringify({ username, password }));
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
