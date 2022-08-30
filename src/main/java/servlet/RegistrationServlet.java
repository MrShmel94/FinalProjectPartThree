package servlet;

import dto.CreateUserDto;
import exception.ValidationException;
import service.UserService;
import util.JspHelper;
import util.UrlPath;
import validator.ValidationResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(UrlPath.REGISTRATION)
public class RegistrationServlet extends HttpServlet {

    private static final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("registration")).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var userDto = CreateUserDto.builder().
                name(req.getParameter("userName").trim()).
                email(req.getParameter("userEmail").trim()).
                password(req.getParameter("userPassword").trim()).
                build();

        try{
            userService.create(userDto);
            resp.sendRedirect(UrlPath.LOGIN);
        }catch (ValidationException exception){
            req.setAttribute("errors", exception.getErrors());
            doGet(req, resp);
        }
    }
}
