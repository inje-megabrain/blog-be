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

db.member = require('./member.js')(sequalize, Sequelize);

module.exports = db;