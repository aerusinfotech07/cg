import React from 'react';

class ErrorBoundary extends React.Component {
  state = { hasError: false, error: null };
  static getDerivedStateFromError(error) { return { hasError: true, error }; }
  componentDidCatch(error, errorInfo) { console.error('Error:', error, errorInfo); }
  handleReset = () => { this.setState({ hasError: false, error: null }); window.location.href = '/'; };
  render() {
    if (this.state.hasError) {
      return (
        <div className="app-container">
          <div className="error-message">
            <h2>Something went wrong</h2>
            <p>{this.state.error?.message}</p>
            <button onClick={this.handleReset} className="btn btn-primary">Reload Page</button>
          </div>
        </div>
      );
    }
    return this.props.children;
  }
}

export default ErrorBoundary;
