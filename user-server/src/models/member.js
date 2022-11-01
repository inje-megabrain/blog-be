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
        timestamps: false,
        freezeTableName: true
    });
	return members;
}