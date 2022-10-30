const dbConfig = require('../config/mysql.js')[process.env.NODE_ENV];
const { Sequelize } = require('sequelize');

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

db.members = require('./member.js')(sequalize, Sequelize);

module.exports = db;