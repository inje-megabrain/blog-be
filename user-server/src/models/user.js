'use strict';

class User {
  /**
   * '사용자'를 정의하는 클래스입니다.
   * @param {{
   * id: string,
   * email: string,
   * name: string,
   * password: string
   * }} obj 사용자 정보가 포함된 객체
   */
  constructor(obj) {
    this.id = obj.id;
    this.email = obj.email;
    this.name = obj.name,
    this.password = obj.password;
  }
}

class UserDTO {
  /**
   * User의 DTO입니다.
   * @param {User} user DTO를 만들 User 객체
   */
  constructor(user) {
    this.id = id;
    this.email = email;
    this.password = password;
  }
}

const defineSequalize = (sequalize, sequalizeClass) => {
    const member = sequalize.define("member", {
        id: {
            field: "id",
            type: sequalizeClass.STRING(255),
            primaryKey: true,
            unique: true,
            allowNull: false
        },
        email: {
            field: "email",
            type: sequalizeClass.STRING(255),
            allowNull: true
        },
        name: {
            field: "name",
            type: sequalizeClass.STRING(255),
            allowNull: true
        },
        password: {
            field: "password",
            type: sequalizeClass.STRING(255),
            allowNull: false
        },
    }, {
        // 자동으로 createdAt, editedAt 필드를 생성하지 않음
        timestamps: false,
        // 자동으로 필드명 끝에 's'를 붙이지 않음
        freezeTableName: true
    });
	return member;
}

module.exports = { User, UserDTO, defineSequalize }