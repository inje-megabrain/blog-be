'use strict';

const {body, param, query, validationResult} = require("express-validator");

const handleInvalidReq = (req, res, next) => {
  let errors = validationResult(req);
  if(!errors.isEmpty()){
    return res.status(400).json({errors : errors.array()});
  }
  next();
}

module.exports = {
  login: [
    body('id').isString(),
    body('password').isString(),
    handleInvalidReq
  ],

  signup: [
    body('id').isString(),
    body('name').isString(),
    body('email').isEmail(),
    body('password').isLength({min: 8, max: 20}),
    handleInvalidReq
  ],

  findId: [
    query('email').isString(),
    query('username').isString(),
  ],

  changePassword: [
    body('id').isString(),
    body('password').isString(),
    handleInvalidReq
  ]
}
