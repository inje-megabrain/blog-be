'use strict';

const UserService = require('@/services/UserService');
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

router.get('/test', async (req, res) => {
  return res.send(await UserService.login('test', 'test123'));
})

router.use('/login', loginRouter);
router.use('/logout', logoutRouter);
router.use('/signup', signupRouter);
router.use('/user', userRouter);

module.exports = router;