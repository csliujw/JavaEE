package lg.controller;


import lg.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet("/index.do")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("requestVar", "request data");
        request.getSession().setAttribute("sessionVar", "session data");
        request.getServletContext().setAttribute("contextVAr", "context data");
        request.setAttribute("data", fakeData());
        request.getRequestDispatcher("/demo.jsp").forward(request, response);

    }

    public ArrayList<User> fakeData() {
        ArrayList<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("111", "111"),
                new User("222", "222"),
                new User("333", "333")));
        users.forEach(System.out::println);
        return users;
    }
}
