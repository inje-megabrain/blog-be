'use strict';

const { Router } = require('express');
const passport = require('passport');
const jwt = require('jsonwebtoken');

const validators = require('@/middleware/validators');

const router = Router();


/**
 * @swagger
 *  /login:
 *    post:
 *      tags:
 *      - authorization
 *      description: API 서버에 로그인하여 JWT 토큰을 발급받습니다.
 *      produces:
 *      - application/json
 *      parameters:
 *      - in: body
 *        name: body
 *        required: true
 *        schema:
 *          properties:
 *            id:
 *              type: string
 *              example: testtest
 *            pw:
 *              type: string
 *              example: test123!
 *      responses:
 *       200:
 *        description: 로그인 성공
 *       400:
 *        description: 로그인 실패
 */
router.post('/', ...validators.login, async (req, res) => {
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

    return res.status(200).cookie('jwt-token', token, {maxAge: 10*60*1000});
  })(req, res);
});

module.exports = router;