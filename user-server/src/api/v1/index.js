'use strict';

const { Router } = require('express');
const login = require('./login');
const signup = require('./signup');
const user = require('./user');

const router = Router();

// API 진입점
router.get('/', (req, res) => {
	return res.send("<h1>Welcome to Api!</h1>");
});

router.use('/login', login);
router.use('/signup', signup);
router.use('/user', user);

module.exports = router;