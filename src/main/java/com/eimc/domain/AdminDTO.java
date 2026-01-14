package com.eimc.domain;

import java.util.UUID;

public class AdminDTO {

    private final UUID adminId;
    private final String firstName;
    private final String lastName;

    public AdminDTO(UUID adminId, String firstName, String lastName) {
        this.adminId = adminId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getAdminId() {
        return adminId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "AdminDTO { adminId = %s, firstName = '%s', lastName = '%s'}".formatted(adminId, firstName, lastName);
    }

    public static AdminDTO map(Admin admin){

        return new AdminDTO(
                admin.getAdminId(),
                admin.getFirstName(),
                admin.getLastName()
        );

    }
}
