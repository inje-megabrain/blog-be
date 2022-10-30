const development = {
  username: process.env.DB_USER,
  password: process.env.DB_PW,
  database: process.env.DB_NAME,
  host:     process.env.DB_HOST,
  port:     process.env.DB_PORT,
  dialect: "mysql",
};

const production = {
  username: process.env.DB_USER,
  password: process.env.DB_PW,
  database: process.env.DB_NAME,
  host:     process.env.DB_HOST,
  port:     process.env.DB_PORT,
  dialect: "mysql",
};

const test = {
  username: process.env.DB_USER,
  password: process.env.DB_PW,
  database: process.env.DB_NAME,
  host:     process.env.DB_HOST,
  port:     process.env.DB_PORT,
  dialect: "mysql",
};

module.exports = { development, production, test };