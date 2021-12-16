package ua.tns.employeeproductivity.entity;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private String company;
    private Department department;
    private EmployeeRole employeeRole;
    private int preferences;
    private boolean workFromHome;


}
