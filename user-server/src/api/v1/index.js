'use strict';

const { Router } = require('express');
const loginRouter = require('./login/index');
const logoutRouter = require('./logout/index');
const signupRouter = require('./signup/index');
const userRouter = require('./user/index');

const router = Router();

// API 진입점
router.get('/', (req, res) => {
	return res.send("<h1>Welcome to Api!</h1>");
});

router.use('/api/v1/login', loginRouter);
router.use('/api/v1/logout', logoutRouter);
router.use('/api/v1/signup', signupRouter);
router.use('/api/v1/user', userRouter);

module.exports = router;