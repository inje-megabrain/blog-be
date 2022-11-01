'use strict';

module.exports = (sequalize, sequalizeClass) => {
    const members = sequalize.define("member", {
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
        password: {
            field: "password",
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
	return members;
}