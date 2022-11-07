'use strict';

const passport = require("passport");
const { Strategy } = require("passport-local");

const db = require("@/config/sequalize");
const { UserModel } = require("@/models/user");

passport.use('local-login', new Strategy(
  {
    usernameField: 'id',
    passwordField: 'password',
    passReqToCallback: true
  },
  async (req, id, password, done) => {
    try {
        let user = db.Member.findByPk<UserModel>()
    }
    catch (error) {
      console.log(error);
    }
  }
));

module.exports = passport;