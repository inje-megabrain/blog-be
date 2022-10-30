'use strict';

const express   = require('express');
const cors      = require('cors');

require('./src/config/env');
require('./src/models/index.js');

const app = express();
app.use(cors())
app.use(express.json())

app.listen(process.env.SERVER_PORT, ()=>{
    console.log("서버 시작");
});