'use strict';

const { Router } = require('express');
const loginRouter = require('./login');
const signupRouter = require('./signup');
const userRouter = require('./user');

const router = Router();

// API 진입점
router.get('/', (req, res) => {
	return res.send("<h1>Welcome to Api!</h1>");
});

router.use('/login', loginRouter);
router.use('/signup', signupRouter);
router.use('/user', userRouter);

module.exports = router;