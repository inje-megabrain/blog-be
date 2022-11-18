'use strict';

const { Router } = require('express');

const UserService = require('@/services/UserService');
const validators = require('@/middleware/validators');

const router = Router();

/**
 * @swagger
 *  /user/pwd:
 *    post:
 *      tags:
 *      - authorization
 *      description: 유저 비밀번호를 변경합니다. (WIP)
 *      produces:
 *      - application/json
 *      parameters:
 *      - in: body
 *        name: body
 *        description: pw는 변경할 Password입니다.
 *        required: true
 *        schema:
 *          properties:
 *            id:
 *              type: email
 *              example: testtest
 *            pw:
 *              type: string
 *              example: qwer123!
 *      responses:
 *       200:
 *        description: PW 변경 성공
 *       400:
 *        description: PW 변경 실패
 */
router.post('/', ...validators.changePassword, async (req, res) => {
  let id = req.body.id;
  let pw = req.body.password;
  let result = await UserService.changePassword(id, pw);
	return res.send(result);
});

module.exports = router;