'use strict';

// '@'로 경로명을 'src'에서 시작할 수 있도록...
require('module-alias/register')

require('@/config/env');
const sequelize = require('@/middleware/sequelize');
const app = require('@/app')

sequelize.authenticate()
.then(() => {
  console.log("DB 연결 성공");
})
.catch((err) => {
  console.log("DB 연결 실패...");
  console.log(err);
})

app.listen(process.env.SERVER_PORT, '0.0.0.0', ()=>{
  console.log("서버 시작");
});
