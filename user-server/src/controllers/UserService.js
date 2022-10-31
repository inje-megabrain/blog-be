'use strict';

const db = require('@/models/index');

class UserService {
  static async viewAll() {
    return db.members.findAll();
  }
}

module.exports = UserService;