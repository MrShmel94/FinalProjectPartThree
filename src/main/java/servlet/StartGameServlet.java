package servlet;

import dto.ReadUserDto;
import service.UserService;
import util.JspHelper;
import util.UrlPath;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(UrlPath.START)
public class StartGameServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("start")).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var reject = req.getParameter("reject");
        var confirm = req.getParameter("confirm");
        if (reject != null){
            ReadUserDto user = (ReadUserDto) req.getSession().getAttribute("user");
            user = userService.updateCountLoseGame(user.getId());
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher(JspHelper.getPath("loseGame")).forward(req,resp);
        } else {
            switch (confirm) {
                case "firstConfirm" -> req.getRequestDispatcher(JspHelper.getPath("firstConfirm")).forward(req,resp);
                case "secondConfirm" -> req.getRequestDispatcher(JspHelper.getPath("secondConfirm")).forward(req,resp);
                case "thirdConfirm" -> {
                    ReadUserDto user = (ReadUserDto) req.getSession().getAttribute("user");
                    user = userService.updateCountWinGame(user.getId());
                    req.getSession().setAttribute("user", user);
                    req.getRequestDispatcher(JspHelper.getPath("winGame")).forward(req,resp);
                }
            }
        }
    }
}
