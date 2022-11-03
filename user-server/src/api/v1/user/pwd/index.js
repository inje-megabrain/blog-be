'use strict';

const { Router } = require('express');

const UserService = require('@/services/UserService');

const router = Router();

// PW 변경
router.post('/', async (req, res) => {
  let id = req.body.id;
  let pw = req.body.password;
  let result = await UserService.changePassword(id, pw);
	return res.send(result);
});

module.exports = router;