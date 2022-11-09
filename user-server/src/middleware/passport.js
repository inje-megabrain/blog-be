'use strict';

const passport = require("passport");
const { Strategy: LocalStrategy } = require("passport-local");
const { Strategy: JWTStrategy, ExtractJwt } = require("passport-jwt");

const UserService = require('@/services/UserService');

passport.use('local', new LocalStrategy(
  {
    usernameField: 'id',
    passwordField: 'password',
    passReqToCallback: true
  },
  async (req, id, password, done) => {
    try {
      let user = await UserService.login(id, password);
      if (!user) {
        return done(null, false, {
          message: "Invalid ID or Password!"
        });
      }
      return done(null, user);
    }
    catch (error) {
      console.error(error);
    }
  }
));

passport.use('jwt', new JWTStrategy(
  {
    jwtFromRequest: ExtractJwt.fromHeader('authorization'),
    secretOrKey: 'jwt-secret-key'
  },
  async (jwtPayload, done) => {
    try {
      let user = await UserService.getInfo(jwtPayload.id);
      if (!user) {
        return done(null, false, {
          message: "Invalid Authorization!"
        });
      }
      return done(null, user);
    }
    catch (error) {
      console.error(error);
    }
  }
));

passport.serializeUser((id, done) => {
  return done(null, id);
})

passport.deserializeUser(async (id, done) => {
  let user = await UserService.getInfo(id);

  if (user)
    done(null, user);
  else
    done(null, false);
})

module.exports = passport;