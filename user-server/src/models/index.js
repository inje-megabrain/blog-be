'use strict';

const { Sequelize } = require('sequelize');

const dbConfig = require('@/config/mysql')[process.env.NODE_ENV];

const sequalize = new Sequelize(
    dbConfig.database,
    dbConfig.username,
    dbConfig.password,
    {
        host: dbConfig.host,
        dialect: dbConfig.dialect
    }
);

const db = {};
db.sequelizeClass = Sequelize;
db.sequelize = sequalize;

/*
  schema를 추가하려면 models/ 아래에 추가 후 (예: member.js)
  아래와 같이 require로 가져와 함수를 호출
*/
db.member = require('./member.js')(sequalize, Sequelize);

module.exports = db;