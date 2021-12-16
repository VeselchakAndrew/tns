package ua.tns.employeeproductivity.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeRole {
    private long id;
    private String roleName;

    public EmployeeRole(long id) {
        this.id = id;
    }
}
