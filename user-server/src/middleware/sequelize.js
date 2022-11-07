'use strict';

const { Sequelize } = require('sequelize');

const dbConfig = require('@/config/mysql')[process.env.NODE_ENV];

const sequelize = new Sequelize(
    dbConfig.database,
    dbConfig.username,
    dbConfig.password,
    {
        host: dbConfig.host,
        dialect: dbConfig.dialect
    }
);

module.exports = sequelize;