'use strict';

const { Router } = require('express');

const UserService = require('@/services/UserService');
const validators = require('@/middleware/validators');

const router = Router();

router.post('/', ...validators.signup, async (req, res) => {
  let result = UserService.signup({
    id: req.body.id,
    email: req.body.email,
    name: req.body.name,
    password: req.body.password
  });
	return res.send(result);
});

module.exports = router;