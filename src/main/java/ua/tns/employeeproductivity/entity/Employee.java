package ua.tns.employeeproductivity.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private long id;
    private final String firstName;
    private final String lastName;
    private final String company;
    private final String department;
    private final EmployeeRole employeeRole;


}
