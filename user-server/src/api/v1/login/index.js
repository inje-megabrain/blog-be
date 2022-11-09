'use strict';

const { Router } = require('express');
const passport = require('passport');

const router = Router();

router.post('/', async (req, res, next) => {
  passport.authenticate('local', (error, user) => {
    if (error || !user) {
      return res.status(400);
    }

    req.login(user, (error) => {
      if (error) {
        console.error(error);
        return next(error);
      }
    })

    return res.redirect('/');
  })(req, res, next);
});

module.exports = router;