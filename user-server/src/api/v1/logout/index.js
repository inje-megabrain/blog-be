'use strict';

const { Router } = require('express');

const router = Router();

router.get('/', async (req, res) => {
  req.logout();
  req.session.destroy();
  res.redirect('/');
});

module.exports = router;