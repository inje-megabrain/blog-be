'use strict';

const { Router } = require('express');

const UserService = require('@/services/UserService');

const router = Router();

router.get('/', async (req, res) => {
  let id = req.body.id;
  let pw = req.body.password;
  let result = await UserService.login(id, password);
	return res.send("<h1>Welcome to Api!</h1>");
});

module.exports = router;