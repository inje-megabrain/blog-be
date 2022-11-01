'use strict';

const db = require('@/models/index');

class UserService {
  static async viewAll() {
    return await db.member.findAll();
  }
}

module.exports = UserService;