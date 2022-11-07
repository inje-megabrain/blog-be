'use strict';

const { Sequelize } = require('sequelize');

const dbConfig = require('@/config/mysql')[process.env.NODE_ENV];

const sequalizeObject = new Sequelize(
    dbConfig.database,
    dbConfig.username,
    dbConfig.password,
    {
        host: dbConfig.host,
        dialect: dbConfig.dialect
    }
);

module.exports = sequalizeObject;