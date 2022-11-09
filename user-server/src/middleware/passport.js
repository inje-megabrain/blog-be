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
        let user = UserService.login(id, password);
        if (!user)
          return done(null, false, {
            message: "Invalid ID or Password!"
          });
        return done(null, {id, password});
    }
    catch (error) {
      console.log(error);
    }
  }
));

passport.serializeUser((id, done) => {
  return done(null, id);
})

passport.deserializeUser((id, done) => {
  let user = UserService.getInfo(id);

  if (user)
    done(null, user);
  else
    done(null, false);
})

module.exports = passport;