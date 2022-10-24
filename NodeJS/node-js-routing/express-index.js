const express = require('express');
const body = require('body-parser');
const _ = require('lodash');
const fs = require('fs');
var cors = require('cors');

const app = express();
app.use(body.json());
app.use(cors());

const port = 8000;

app.use(function (req, res, next) {
  res.header('Access-Control-Allow-Origin', '*');
  res.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept');
  next();
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})

app.get('/page1', (req, res) => {
  res.send('Page One')
})

app.get('/page2', (req, res) => {
  res.send('Page Two')
})

app.get('/page3', (req, res) => {
  res.send('Page Three')
})

app.get('/json', (req, res) => {
  res.json({ namee: 'Arulmozhi Karunagaran', number: 6374553281, roll_no: '191EC112' })
})

app.get('/html', function (req, res) {
  // res.sendFile(path.join(__dirname, '/index.html'));
  res.sendFile('/index.html', { root: __dirname });
});

app.get('/xml', function (req, res) {
  res.sendFile('/index.xml', { root: __dirname });
});

app.get('/image', function (req, res) {
  res.sendFile('/my-pic.jpg', { root: __dirname });
});

app.get('/pdf', function (req, res) {
  res.sendFile('/port-tutorial.pdf', { root: __dirname });
});

app.get('/gif', function (req, res) {
  res.sendFile('/gif-image.gif', { root: __dirname });
});

app.get('/video', function (req, res) {
  res.sendFile('/Network Ports Explained.mp4', { root: __dirname });
});

app.get('/', (req, res) => {
  res.redirect('/page1');
})

app.use((req, res) => {
  res.status(404);
  res.send('Page Not Found')
})
