'use strict';

const { Router } = require('express');
const passport = require('passport');
const jwt = require('jsonwebtoken');

const router = Router();

router.post('/', async (req, res) => {
  passport.authenticate('local', (error, user, info) => {
    if (error || !user) {
      return res.status(400).json({reason: info.message});
    }

    req.login(user, (error) => {
      if (error) {
        console.error(error);
        return res.status(400).json({reason: info.message});
      }
    })

    const token = jwt.sign(
      {id: user.id},
      process.env.JWT_SECRET_KEY,
      {expiresIn: '10m'});

    return res.status(200).json({token});
  })(req, res);
});

module.exports = router;