'use strict';

const { Router } = require('express');

const idRouter = require('./id/index');
const pwdRouter = require('./pwd/index');

const UserService = require('@/services/UserService');

const router = Router();

// 사용자 전체 찾기
router.get('/', async (req, res) => {
	return await UserService.findAll();
});

// 회원 탈퇴
router.delete('/', async (req, res) => {
  return await UserService.resign(req.body.id);
})

// 사용자 조회
router.get('/:id', async (req, res) => {
  return await UserService.getInfo(req.params.id);
})

// 사용자 정보 변경
router.post('/', async (req, res) => {
  return await UserService.changeInfo(/* ... */);
})

router.use('/id', idRouter);
router.use('/pwd', pwdRouter);

module.exports = router;