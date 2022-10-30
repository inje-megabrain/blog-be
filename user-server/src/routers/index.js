'use strict';

const { Router } = require('express');

const router = Router();

// API 진입점
router.get('/', (req, res) => {
	return "<h1>Welcome to Api!</h1>"
});

module.exports = router;