package com.webtutsplus.ecommerce.model;


import com.webtutsplus.ecommerce.enums.Role;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "password")
    private String password;

    /**
     * Constructor for the User object.
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param email The user's email address.
     * @param role The user's role.
     * @param password The user's password.
     */
    public User(String firstName, String lastName, String email, Role role, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    /**
     * Default constructor of the User object.
     */
    public User() {}

    /**
     * Used to get the ID of the user.
     * @return The user ID of type Integer.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Used to set the user's ID.
     * @param id The user's new ID.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Used to get the first name of the user.
     * @return The user's first name of type String.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Used to set the user's first name.
     * @param firstName The user's new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Used to get the last name of the user.
     * @return The user's last name of type String.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Used to set the user's last name.
     * @param lastName The user's new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Used to get the email address of the user.
     * @return The user's email address of type String.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Used to set the user's email address.
     * @param email The user's new email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Used to get the role of the user.
     * @return The user's role of type Role.
     */
    public Role getRole() {
        return role;
    }

    /**
     * Used to set the user's role.
     * @param role The user's new role.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Used to get the password of the user.
     * @return The user's password of type String.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Used to set the user's password.
     * @param password The user's new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
