package filter;

import dto.ReadUserDto;
import lombok.SneakyThrows;
import util.UrlPath;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

import static util.UrlPath.*;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    private static final Set<String> PUBLIC_PATH = Set.of(REGISTRATION, LOGIN);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
        if (isPublicPath(requestURI) || isUserLoggedIn(servletRequest)){
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            reject (servletRequest, servletResponse);
        }
    }

    @SneakyThrows
    private void reject(ServletRequest servletRequest, ServletResponse servletResponse) {
        ((HttpServletResponse)servletResponse).sendRedirect(LOGIN);
    }

    private boolean isUserLoggedIn(ServletRequest servletRequest) {
        var user = (ReadUserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        return user != null;
    }

    private boolean isPublicPath(String requestURI) {
        return PUBLIC_PATH.stream().anyMatch(requestURI::startsWith);
    }

}
