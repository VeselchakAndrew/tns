package ua.tns.employeeproductivity.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Department {
    private long id;
    private String name;
    private boolean synchronize;

    public Department(long id) {
        this.id = id;
    }
}
