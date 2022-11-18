'use strict';

const swaggerUi = require('swagger-ui-express');
const swaggerJsdoc = require('swagger-jsdoc');

const options = {
    swaggerDefinition: {
        info: {
            title: 'AllWrite User-server API',
            version: '1.0.0',
            description: 'Test API with express',
        },
        host: 'localhost:3000',
        basePath: '/api/v1'
    },
    apis: ['./src/api/v1/**/*.js']
};

const specs = swaggerJsdoc(options);

module.exports = {
    swaggerUi,
    specs
};