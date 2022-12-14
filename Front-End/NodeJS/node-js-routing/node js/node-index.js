// const http = require('http');

// const requestListener = function (req, res) {
//     res.writeHead(200);
//     res.end('This is node js default server!');
// }

// const server = http.createServer(requestListener);
// server.listen(8080);

var http = require('http');

http.createServer(function (req, res) {

    // res.writeHead(200, {'Content-Type': 'text/html'});
    const url = req.url;

    if (url === '/page1') {
        res.write('Page One');
        res.end();
    }
    else if (url === '/page2') {
        res.write('Page two');
        res.end();
    }
    else if (url === '/page3') {
        res.write('Page three');
        res.end();
    }
    else if(url === '/') {
        res.writeHead(302, { "Location": "http://" + req.headers['host'] + '/page1' });
        res.end();
    }
    // else {
    //     res.write('Page Not Found');
    //     res.end();
    // }
}).listen(8000, function () {
    console.log("server start at port 8000");
});