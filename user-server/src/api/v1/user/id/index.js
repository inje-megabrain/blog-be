'use strict';

const { Router } = require('express');

const UserService = require('@/services/UserService');
const validators = require('@/middleware/validators');

const router = Router();

// ID 찾기
router.get('/', ...validators.findId, async (req, res) => {
  let email = req.body.email;
  let user = req.body.user;
  let result = await UserService.findId(email, user);
	return res.send(result);
});

module.exports = router;