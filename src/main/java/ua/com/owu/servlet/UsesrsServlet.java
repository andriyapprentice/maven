package ua.com.owu.servlet;

import ua.com.owu.connect.dbConnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsesrsServlet")
public class UsesrsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        dbConnect dbconnect=new dbConnect();
        List<String> users=dbconnect.findAll();
        request.setAttribute("userList",users);

        request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request,response);
    }
}
