package com.vishwas.springsecurityjdbcauthenticator.model;

import javax.persistence.*;

@Entity
@Table(name = "MY_AUTHORITIES")
public class MyAuthority {
    @Id
    @Column(name="ID")
    Integer id;

    @Column(name = "AUTHORITY")
    String authority;

    @OneToOne(mappedBy = "myAuthority")
    MyUsers myUsers;


    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
