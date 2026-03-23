/**
 * Module-level auth state for axios interceptor (no React context in interceptors).
 * AuthContext calls setAuth when user logs in and clearAuth on logout.
 */
let auth = {
  mode: 'none',
  basic: null,  // { username, password }
  jwt: null     // token string
};

export const getAuth = () => ({ ...auth });

export const setAuth = (mode, data) => {
  if (mode === 'basic' && data) {
    auth = { mode: 'basic', basic: { username: data.username, password: data.password }, jwt: null };
  } else if (mode === 'jwt' && data && data.token) {
    auth = { mode: 'jwt', basic: null, jwt: data.token };
  } else {
    auth = { mode: 'none', basic: null, jwt: null };
  }
};

export const clearAuth = () => {
  auth = { mode: 'none', basic: null, jwt: null };
};
