const fastify = require('fastify');
const app = fastify();

app.post('/user', async (req, reply) => {
  return {
    error: true,
    username: req.body.username,
    reply: 'In fastify server',
  };
});

app.listen(3000).then(() => {
  console.log('Server running at http://localhost:3000/');
});