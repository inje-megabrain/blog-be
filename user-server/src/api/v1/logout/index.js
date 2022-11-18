'use strict';

const { Router } = require('express');

const router = Router();

/**
 * @swagger
 *  /logout:
 *    post:
 *      tags:
 *      - authorization
 *      description: API 서버에서 로그아웃하여 JWT 토큰을 제거합니다.
 *      produces:
 *      - application/json
 *      responses:
 *       200:
 *        description: 로그아웃 성공
 */
router.get('/', async (req, res) => {
  req.logout();
  req.session.destroy();
  res.clearCookie('jwt-token');
  res.redirect('/');
});

module.exports = router;