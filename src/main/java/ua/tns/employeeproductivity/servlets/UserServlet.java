package ua.tns.employeeproductivity.servlets;

import ua.tns.employeeproductivity.dao.employee.EmployeeDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee")
public class UserServlet extends HttpServlet {
    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("employees", employeeDAO.getAllEmployees());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/Employee.jsp");
        dispatcher.forward(req, resp);
    }
}
