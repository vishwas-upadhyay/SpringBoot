package com.vishwas.springsecurityjdbcauthenticator.model;

import javax.persistence.*;

@Entity
@Table(name = "MY_USERS")
public class MyUsers {
    @Id
    @Column(name = "ID")
    Integer id;

    @Column(name = "USERNAME")
    String username;

    @Column(name = "PASSWORD")
    String password;

    @Column(name = "ENABLED")
    String enabled;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")
//    @JoinColumn helps you to map column for join else hibernate will expect it's own column and that
//            would be not work in real time application.
//            https://www.baeldung.com/jpa-one-to-one
            MyAuthority myAuthority;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public MyAuthority getMyAuthority() {
        return myAuthority;
    }

    public void setMyAuthority(MyAuthority myAuthority) {
        this.myAuthority = myAuthority;
    }
}
