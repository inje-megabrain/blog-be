'use strict';

require('module-alias/register')

const express   = require('express');
const cors      = require('cors');

require('@/config/env');
require('@/models/index');

const routers = require('@/routers/index');

const app = express();
app.use(cors())
app.use(express.json())

app.use((req, res, next)=>{
  console.log(`${req.method} - ${req.url}`);
  next();
})

app.use(routers);

app.listen(process.env.SERVER_PORT, ()=>{
    console.log("서버 시작");
});