'use strict';

const swaggerUi = require('swagger-ui-express');
const swaggereJsdoc = require('swagger-jsdoc');

const options = {
    swaggerDefinition: {
        info: {
            title: 'AllWrite User-server API',
            version: '1.0.0',
            description: 'Test API with express',
        },
        host: 'localhost:3000',
        basePath: '/'
    },
    apis: ['../api/*.js', '../../swagger/*']
};

const specs = swaggereJsdoc(options);

module.exports = {
    swaggerUi,
    specs
};