'use strict';

const { Router } = require('express');

const UserService = require('@/services/UserService');
const validators = require('@/middleware/validators');

const router = Router();

/**
 * @swagger
 *  /user/id:
 *    post:
 *      tags:
 *      - authorization
 *      description: Email과 Username으로 ID를 찾습니다.
 *      produces:
 *      - application/json
 *      parameters:
 *      - in: body
 *        name: body
 *        required: true
 *        schema:
 *          properties:
 *            email:
 *              type: email
 *              example: test@test.com
 *            username:
 *              type: string
 *              example: Test
 *      responses:
 *       200:
 *        description: ID 찾기 성공
 *       400:
 *        description: ID 찾기 실패
 */
router.get('/', ...validators.findId, async (req, res) => {
  let email = req.body.email;
  let user = req.body.user;
  let result = await UserService.findId(email, user);
	return res.send(result);
});

module.exports = router;