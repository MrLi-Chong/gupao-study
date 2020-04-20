package com.gupao.chain.general;

/**
 * @Author Administrator
 * @Date 2020/4/19 21:25
 */
public class Member {
    private String userName;
    private String password;
    private String roleName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Member(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
