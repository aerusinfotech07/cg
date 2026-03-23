let auth = { username: null, password: null };

export const getAuth = () => ({ ...auth });
export const setAuth = (username, password) => {
  auth = { username, password };
};
export const clearAuth = () => {
  auth = { username: null, password: null };
};
