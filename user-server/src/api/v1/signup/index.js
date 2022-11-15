'use strict';

const { Router } = require('express');

const UserService = require('@/services/UserService');

const router = Router();

/**
 * @swagger
 *  /signup:
 *    post:
 *      tags:
 *      - authorization
 *      description: 회원가입합니다.
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
 *            email:
 *              type: email
 *              example: test@test.com
 *            username:
 *              type: string
 *              example: Test
 *            pw:
 *              type: string
 *              example: test123!
 *      responses:
 *       200:
 *        description: 회원가입 성공
 *       400:
 *        description: 회원가입 실패
 */
router.post('/', async (req, res) => {
  let result = UserService.signup({
    id: req.body.id,
    email: req.body.email,
    name: req.body.name,
    password: req.body.password
  });
	return res.send(result);
});

module.exports = router;