package ua.tns.employeeproductivity.models;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String company;
    private Long department;
    private Long employeeRole;
    private int preferences;
    private Boolean workFromHome;


}
