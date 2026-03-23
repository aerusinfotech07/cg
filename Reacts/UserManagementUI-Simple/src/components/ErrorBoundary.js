import React from 'react';

class ErrorBoundary extends React.Component {
  constructor(props) {
    super(props);
    this.state = { hasError: false, error: null };
  }

  static getDerivedStateFromError(error) {
    return { hasError: true, error };
  }

  componentDidCatch(error, errorInfo) {
    console.error('Error caught by boundary:', error, errorInfo);
  }

  handleReset = () => {
    this.setState({ hasError: false, error: null });
    // Use React Router navigation instead of page reload
    if (window.location.pathname !== '/') {
      window.history.pushState({}, '', '/');
      window.location.href = '/';
    } else {
      // Only reload if we're already on home page
      window.location.reload();
    }
  };

  render() {
    if (this.state.hasError) {
      return (
        <div className="app-container">
          <div className="error-message">
            <h2>Something went wrong</h2>
            <p>{this.state.error?.message || 'An unexpected error occurred'}</p>
            <button onClick={this.handleReset} className="btn btn-primary">Reload Page</button>
          </div>
        </div>
      );
    }

    return this.props.children;
  }
}

export default ErrorBoundary;
