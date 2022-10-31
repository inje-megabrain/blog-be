'use strict';

const { Router } = require('express');

const router = Router();

const UserService = require('@/controllers/UserService');

// API 진입점
router.get('/', (req, res) => {
	return res.send("<h1>Welcome to Api!</h1>");
});

router.get('/test', (req, res) => {
  return res.send(UserService.viewAll());
});

module.exports = router;