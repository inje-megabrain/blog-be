'use strict';

const { Router } = require('express');
const passport = require('passport');

const router = Router();

router.post('/', async (req, res, next) => {
  passport.authenticate('local', (error, user, info) => {
    if (error) {
      console.error(error);
      return next(error);
    }
    if (!user) {
      return res.redirect(`/?loginError=${info.message}`);
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