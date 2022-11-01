'use strict';

const express   = require('express');
const cors      = require('cors');

const routers = require('@/routers/index');
const app = express();

app.use(cors())
app.use(express.json())

app.use((req, res, next)=>{
  console.log(`${req.method} - ${req.url}`);
  next();
})

app.use(routers);

module.exports = app;