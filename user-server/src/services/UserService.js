'use strict';

const db = require('@/models/index');

class UserService {
  static async viewAll() {
    return await db.members.findAll();
  }
}

module.exports = UserService;