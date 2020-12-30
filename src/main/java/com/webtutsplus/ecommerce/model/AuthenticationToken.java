package com.webtutsplus.ecommerce.model;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tokens")
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String confirmationToken;
    private Date createdDate;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    /**
     * Constructor for the AuthenticationToken object.
     * @param user The use which we are authenticating.
     */
    public AuthenticationToken(User user) {
        this.user = user;
        this.createdDate = new Date();
        this.confirmationToken = UUID.randomUUID().toString();
    }

    /**
     * Constructor for the AuthenticationToken object.
     * @param id The ID of the authentication token.
     * @param confirmationToken The confirmationToken for this token.
     * @param createdDate The date at which this token was created.
     * @param user The user for which this token was created.
     */
    public AuthenticationToken(Integer id, String confirmationToken, Date createdDate, User user) {
        this.id = id;
        this.confirmationToken = confirmationToken;
        this.createdDate = createdDate;
        this.user = user;
    }

    public AuthenticationToken() {
    }

    /**
     * Used to get the ID of the authentication token.
     * @return ID of type Integer.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Used to set the ID of the authentication token.
     * @param id the new ID of the token.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Used to get the confirmation token of the authentication token.
     * @return confirmation token of type String.
     */
    public String getConfirmationToken() {
        return confirmationToken;
    }

    /**
     * Used to set the confirmation token of the authentication token.
     * @param confirmationToken the new confirmation token of the authentication token.
     */
    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    /**
     * Used to get the time at which the authentication token was created.
     * @return date of type Date.
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * Used to set the date at which the authentication token was created.
     * @param createdDate the new creation date of the token.
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Used to get the user for which we are authenticating.
     * @return user of type User.
     */
    public User getUser() {
        return user;
    }

    /**
     * Used to set the user to which the authentication token belongs.
     * @param user the new user to which the token belongs.
     */
    public void setUser(User user) {
        this.user = user;
    }
}
