package servlet;

import dto.ReadUserDto;
import lombok.SneakyThrows;
import service.UserService;
import util.JspHelper;
import util.UrlPath;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(UrlPath.LOGIN)
public class LoginServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("login")).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.login(req.getParameter("userEmail").trim(), req.getParameter("userPassword").trim()).ifPresentOrElse(
                user -> onLoginSuccess(user, req, resp),
                () -> onLoginFail(req,resp)
        );
    }

    @SneakyThrows
    private void onLoginFail(HttpServletRequest req, HttpServletResponse resp) {
        resp.sendRedirect("/login?error&email=" + req.getParameter("userEmail").trim());
    }

    @SneakyThrows
    private void onLoginSuccess(ReadUserDto user , HttpServletRequest req, HttpServletResponse resp){
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(UrlPath.START);
    }
}
