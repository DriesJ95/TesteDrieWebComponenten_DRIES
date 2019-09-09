package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/testdrie")
public class TestDrieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().isNew()){
            req.getSession().setAttribute("login","Guest");
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,resp);
        } else if (req.getSession().getAttribute("login").equals("Guest, gelieve een geldige naam in te voeren !")) {
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/pages/welcome.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String action = req.getParameter("log");
        switch (action){
            case "log out":
                session.invalidate();
                resp.sendRedirect("");
                break;
            case "log in":
                if (!username.equals("")){
                    session.setAttribute("login", username);
                    resp.sendRedirect("");
                }else{
                    session.setAttribute("login", "Guest, gelieve een geldige naam in te voeren !");
                    resp.sendRedirect("");
                }
                break;
        }

    }
}
