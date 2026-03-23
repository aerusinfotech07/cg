// Utility to prevent page refreshes
export const preventRefresh = () => {
  // Prevent browser refresh on errors
  const preventDefault = (e) => {
    e.preventDefault();
    e.stopPropagation();
    return false;
  };

  // Prevent form submissions from refreshing
  document.addEventListener('submit', (e) => {
    const form = e.target;
    if (form.tagName === 'FORM' && !form.hasAttribute('data-no-prevent')) {
      // Form submission is handled by React, prevent default browser behavior
      // Only prevent if it's not already prevented
      if (!e.defaultPrevented) {
        e.preventDefault();
      }
    }
  }, true);

  // Prevent navigation that might cause refresh
  window.addEventListener('beforeunload', (e) => {
    // Only show warning if there's unsaved data
    // Otherwise, allow normal navigation
  });

  // Prevent error from causing refresh
  window.addEventListener('error', (e) => {
    e.preventDefault();
    console.error('Error caught:', e.error);
    return false;
  }, true);

  // Prevent unhandled promise rejections from causing refresh
  window.addEventListener('unhandledrejection', (e) => {
    e.preventDefault();
    console.error('Unhandled promise rejection:', e.reason);
    return false;
  });
};

// Initialize on import
if (typeof window !== 'undefined') {
  preventRefresh();
}
