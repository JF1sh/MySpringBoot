package cn.lijy.demo.entity;

/**
 * 数据库 SY_USER 对应的字段
 */
public class UserEntity {

    private String userCode; //用户id
    private String userLoginName;//用户登录名
    private String userPassword; //用户密码
    private String userName;//用户名称


    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
