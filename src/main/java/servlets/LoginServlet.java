package servlets;

import entities.User;
import model.dao.UserDAO;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        List<User> users = userDAO.getAllByUsernameAndPassword(username, password);
        if (users.isEmpty()) {
            String error= "Złe dane logowania.";
            req.setAttribute("error",error);
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        } else {
            user.setUsername(username);
            user.setPassword(password);

            req.getSession().invalidate();
            req.getSession(true);

            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/user/skills");

        }

    }

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO((SessionFactory) getServletContext().getAttribute("session_factory"));
    }
}
