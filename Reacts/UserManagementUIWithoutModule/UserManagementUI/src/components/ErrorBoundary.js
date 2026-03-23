import React from 'react';
import { Alert, Button } from 'react-bootstrap';

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
          <Alert variant="danger">
            <Alert.Heading>Something went wrong</Alert.Heading>
            <p>{this.state.error?.message || 'An unexpected error occurred'}</p>
            <hr />
            <div className="d-flex justify-content-end">
              <Button variant="outline-danger" onClick={this.handleReset}>
                Reload Page
              </Button>
            </div>
          </Alert>
        </div>
      );
    }

    return this.props.children;
  }
}

export default ErrorBoundary;
