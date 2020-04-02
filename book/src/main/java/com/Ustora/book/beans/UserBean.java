package com.Ustora.book.beans;


public class UserBean {

    private Long id;

    private String userName;

    private String email;

    private String password;

    public UserBean() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserBean [id=" + id + ", userName=" + userName + ", email=" + email
                + ", password=" + password + "]";
    }
}
