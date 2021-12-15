package ua.tns.employeeproductivity.servlets;

import ua.tns.employeeproductivity.dao.employee.EmployeeDAO;
import ua.tns.employeeproductivity.models.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet("/")
public class MainServlet extends HttpServlet {

//    private String companyName = "Company";
//    private final EmployeeDAO employeeDAO = new EmployeeDAO();
//    private final Set<String> departments = employeeDAO.getAllEmployees().stream()
//            .map(Employee::getDepartment).collect(Collectors.toSet());
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("companyName", companyName);
//        req.setAttribute("departments", departments);
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/Main.jsp");
//        requestDispatcher.forward(req, resp);
//    }


}
