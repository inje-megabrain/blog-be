'use strict';

const express = require('express');
const cors = require('cors');
const session = require("express-session");

const routers = require('@/api/v1/index');
const passport = require('@/middleware/passport');

const app = express();

app.use(cors());

app.use(express.json());
app.use(express.urlencoded({ extended: false }));

app.use(session({
  secret: process.env.SESSION_SECRET,
  resave: true,
  saveUninitialized:true
}));

app.use(passport.initialize());
app.use(passport.session());

app.use((req, res, next)=>{
  console.log(`${req.method} - ${req.url}`);
  next();
})

app.use(routers);

module.exports = app;