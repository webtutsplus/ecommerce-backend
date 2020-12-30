package com.webtutsplus.ecommerce.dto.userDTOs;

import com.webtutsplus.ecommerce.enums.Role;

public class UserUpdateDto {
    // Skipping updating password as of now.
    private Integer id;
    private String firstName;
    private String lastName;
    private Role role;

    /**
     * Used to get the ID of the UserUpdateDto object.
     * @return ID of type Integer.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Used to set the ID of the UserUpdateDto object.
     * @param id new ID.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Used to get the first name of the UserUpdateDto object.
     * @return first name of type String.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Used to set the first name of the UserUpdateDto object.
     * @param firstName new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Used to get the last name of the UserUpdateDto object.
     * @return last name of type String.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Used to set the last name of the UserUpdateDto object.
     * @param lastName new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Used to get the role of the UserUpdateDto object.
     * @return role of type Role.
     */
    public Role getRole() {
        return role;
    }

    /**
     * Used to set the role of the UserUpdateDto object.
     * @param role new role.
     */
    public void setRole(Role role) {
        this.role = role;
    }
}
