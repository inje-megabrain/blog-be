'use strict';

const { Router } = require('express');

const router = Router();

const UserService = require('@/services/UserService');

// API 진입점
router.get('/', (req, res) => {
	return res.send("<h1>Welcome to Api!</h1>");
});

module.exports = router;