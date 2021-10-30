package spittr.domain;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Manager {

    private Long id;

    @NotNull
    @Size(min = 5, max = 16)
    private String userName;

    @NotNull
    @Size(min = 5, max = 25)
    private String password;

    @NotNull
    @Size(min = 2, max = 30)
    private String fullname;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 5, max = 20)
    private String phoneNo;

    @NotNull
    private int delete;

    public Manager() {
    }

    public Manager(Long id, String userName, String password, String fullname, String email, String phoneNo, int delete) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.phoneNo = phoneNo;
        this.delete = delete;
    }

    public Manager(String userName, String password, String fullname, String email, String phoneNo, int delete) {
        this(null, userName, password, fullname, email, phoneNo, delete);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }
}
