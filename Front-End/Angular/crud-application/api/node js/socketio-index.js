// index.js
// Require and create our server packages
let app = require('express')();
let http = require('http').Server(app);
let io = require('socket.io')(http);

// Send socket initialization scripts to the client
app.get('/', function(req, res){
    res.send(`
<script src="/socket.io/socket.io.js"></script>
<script>
    let socket = io();
    socket.on('text', (txt) => {
        let textp = document.createElement("h1");
        let t = document.createTextNode(txt);
        textp.appendChild(t);                                            
        document.body.appendChild(textp);
    });
</script>`);
});

// Respond to socket connections with a Hello World text
io.on('connection', (socket) => {
    console.log('User connected');
    io.emit('text', 'This is socket io server');
});

// Run our socket-enabled server
http.listen(3000, function() {
    console.log('listening on *:3000');
});