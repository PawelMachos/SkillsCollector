package servlets;

import entities.Skill;
import entities.User;
import model.dao.UserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/user/skills")
public class UserSkillsServlet extends HttpServlet {
    UserDAO userDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<Skill> allSkills = userDAO.getAllSkills(user);
        req.setAttribute("skills", allSkills);

        List<Skill> skills= userDAO.getAllSkills(user);
        Map<Skill,Integer> mapOfSkills = new HashMap<>();
        for(Skill s : skills){
            if (!mapOfSkills.containsKey(s)) {
                mapOfSkills.put(s, 1);
            }
            else {
                Integer counter = mapOfSkills.get(s);
                mapOfSkills.put(s, counter + 1);
            }
        }
        req.setAttribute("skills",mapOfSkills);
        req.getRequestDispatcher("/WEB-INF/views/user-skills.jsp").forward(req,resp);

    }

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO((SessionFactory) getServletContext().getAttribute("session_factory"));
    }
}
