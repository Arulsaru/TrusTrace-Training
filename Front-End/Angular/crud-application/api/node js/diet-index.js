// index.js
const server = require('diet');

// Create a diet server
let app = server();

// Start the server on port 3000
app.listen('http://localhost:3000');

// Serve the home route
app.get('/', ($) => {
    // Respond with a greeting and end the request
    $.end('This is diet index server');
});