'use strict';

require('module-alias/register')

require('@/config/env');
const db = require('@/models/index');
const app = require('@/app')

db.sequelize.authenticate()
.then(() => {
  console.log("DB 연결 성공");
})
.catch((err) => {
  console.log("DB 연결 실패...");
  console.log(err);
})

app.listen(process.env.SERVER_PORT, ()=>{
  console.log("서버 시작");
});
