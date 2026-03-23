let token = null;
export const getToken = () => token;
export const setToken = (t) => { token = t; };
export const clearAuth = () => { token = null; };
