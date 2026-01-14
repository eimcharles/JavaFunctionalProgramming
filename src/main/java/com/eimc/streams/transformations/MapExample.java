package com.eimc.streams.transformations;

import com.eimc.domain.Admin;
import com.eimc.domain.AdminDTO;
import com.eimc.streams.mockData.MockData;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

public class MapExample {

    public static void main(String[] args) {

        List<Admin> adminList = MockData.getAdmins();

        ///  map () allows to transform one data type into another

        ///  Example 1:
        System.out.println("Example one: displaying all the admins from the adminList");
        adminList.forEach(System.out::println);
        System.out.println();

        ///  Example 2:
        System.out.println("Example two: using map() to convert a admin object into a adminDTO object");

        Function<Admin, AdminDTO> adminAdminDTOFunction = admin ->
                new AdminDTO(admin.getAdminId(), admin.getFirstName(), admin.getLastName());

        List<AdminDTO> adminDTOlist = adminList.stream()
                .map(adminAdminDTOFunction)
                .toList();

        adminDTOlist.forEach(System.out::println);
        System.out.println();

        ///  Example 3:
        System.out.println("Example three: converting a specific admin to an adminDTO based on a passed adminId");

        UUID targetAdminId = UUID.fromString("b47ac10b-58cc-4372-a567-0e02b2c3d472");

        Optional<AdminDTO> optionalAdminDTOByAdminId = adminList.stream()
                .filter(admin -> admin.getAdminId().equals(targetAdminId))
                .map(AdminDTO::map)
                .findFirst();

        optionalAdminDTOByAdminId.ifPresentOrElse(System.out::println,
                () -> System.out.println("Admin not found with ID: " + targetAdminId));
        System.out.println();

    }
}
