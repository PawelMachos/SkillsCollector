package servlets;

import entities.User;
import model.dao.UserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    private UserDAO userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        User user = new User();
        req.setAttribute("newUser", user);

        req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setUsername(username);

        if (userDao.isUsernameAvailable(username)){
            userDao.save(user);
        }else {
            req.setAttribute("user", user);
            req.setAttribute("error","Zajęty username.");
            res.sendRedirect("/register.jsp");
        }



        res.sendRedirect("/login");
    }

    @Override
    public void init() throws ServletException {
        userDao = new UserDAO((SessionFactory) getServletContext().getAttribute("session_factory"));
    }
}
