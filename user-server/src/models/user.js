'use strict';

const sequelize = require('@/middleware/sequelize');

const { DataTypes, Model } = require('sequelize')

class UserModel extends Model {}

UserModel.init({
  id: {
      field: "id",
      type: DataTypes.STRING(255),
      primaryKey: true,
      unique: true,
      allowNull: false
  },
  email: {
      field: "email",
      type: DataTypes.STRING(255),
      allowNull: true
  },
  name: {
      field: "name",
      type: DataTypes.STRING(255),
      allowNull: true
  },
  password: {
      field: "password",
      type: DataTypes.STRING(255),
      allowNull: false
  },
}, {
  sequelize,
  modelName: "member",
  // 자동으로 createdAt, editedAt 필드를 생성하지 않음
  timestamps: false,
  // 자동으로 필드명 끝에 's'를 붙이지 않음
  freezeTableName: true
});

class UserDTO {
  /**
   * User의 DTO입니다.
   * @param {UserModel} user DTO를 만들 User 객체
   */
  constructor(user) {
    this.id = user.id;
    this.email = user.email;
    this.name = user.name;
    this.password = user.password;
  }
}

module.exports = { UserModel, UserDTO }