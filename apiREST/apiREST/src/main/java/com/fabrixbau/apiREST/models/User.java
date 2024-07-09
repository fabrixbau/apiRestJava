package com.fabrixbau.apiREST.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "user")
@ToString
@EqualsAndHashCode
public class User extends BaseEntity {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="role_id")
    @Getter @Setter
    private Role role;

    @JsonIgnore
    @Column(name = "password")
    @Getter @Setter
    private String password;

    @Column(name = "firstname")
    @Getter @Setter
    private String firstname;

    @Column(name = "lastname")
    @Getter @Setter
    private String lastname;

    @Column(name = "email")
    @Getter @Setter
    private String email;

    @Column(name = "number")
    @Getter @Setter
    private String number;

    @Column(name = "birthday")
    @Getter @Setter
    private Date birthday;

    public User() {
    }

    public User(long id, String firstname, String lastname, String email, String number, Date birthday) {
        setId(id);
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.number = number;
        this.birthday = birthday;
    }
}
