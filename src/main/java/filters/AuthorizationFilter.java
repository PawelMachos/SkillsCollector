package filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter(urlPatterns = "/*")
public class AuthorizationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        Object user = req.getSession().getAttribute("user");
        String servletPath = req.getServletPath();

        List<String> protectedPaths = Arrays.asList("/logout","/profile","/user/sources","/user/skills");
        List<String> unprotectedPaths = Arrays.asList("/login","/register", "/main");

        if (protectedPaths.contains(servletPath)){
            if (user != null){
                chain.doFilter(req,res);
            } else {
                res.sendRedirect("/login");
            }
        } else if(unprotectedPaths.contains(servletPath)){
            chain.doFilter(req,res);
        } else{
            res.sendError(500, "Nie ma takiej strony." );
        }



    }
}
