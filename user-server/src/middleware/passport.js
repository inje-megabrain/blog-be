'use strict';

const passport = require("passport");
const { Strategy } = require("passport-local");

const UserService = require('@/services/UserService');

passport.use('local-login', new Strategy(
  {
    usernameField: 'id',
    passwordField: 'password',
    passReqToCallback: true
  },
  async (req, id, password, done) => {
    try {
        let user = UserService.findBy

        if (!user)
          return done(null, false);
    }
    catch (error) {
      console.log(error);
    }
  }
));

module.exports = passport;