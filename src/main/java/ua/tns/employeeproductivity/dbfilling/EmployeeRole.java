package ua.tns.employeeproductivity.dbfilling;

public enum EmployeeRole {
    SENIOR_SPEC(2),
    MIDDLE_SPEC(3),
    JUNIOR_SPEC(4);

    private final int role;

    EmployeeRole(int role) {
        this.role = role;
    }

    public int getRole() {
        return role;
    }
}
