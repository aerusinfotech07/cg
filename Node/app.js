const http = require('http');

const PORT = 8080;

const server = http.createServer((req, res) => {
  res.writeHead(200, { 'Content-Type': 'text/plain' });
  console.log('Environment:', process.env.NODE_ENV || 'development');
console.log('Custom variable:', process.env.JAVA_HOME);
console.log('Database URL:', process.env.DATABASE_URL || 'Not set');

  res.end('Hello World Sameer!');
});

server.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
  console.log('Press Ctrl+C to stop.');
});
