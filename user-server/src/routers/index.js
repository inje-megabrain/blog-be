'use strict';

const { Router } = require('express');

const v1 = require('@api/v1');

const router = Router();

/**
 * 실제 routing 진입점은 api/v1/ 참조
 */
router.use(v1);

module.exports = router;