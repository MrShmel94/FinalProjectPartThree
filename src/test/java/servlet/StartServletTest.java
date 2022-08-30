package servlet;

import lombok.SneakyThrows;
import org.apache.struts.mock.MockHttpServletRequest;
import org.apache.struts.mock.MockHttpServletResponse;
import org.apache.struts.mock.MockHttpSession;
import org.apache.struts.mock.MockServletContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import util.JspHelper;
import util.UrlPath;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StartServletTest {

    public StartGameServlet servlet;
    public HttpServletRequest request;
    public HttpServletResponse response;
    public RequestDispatcher dispatcher;

    @SneakyThrows
    @BeforeAll
    void init(){
        servlet = new StartGameServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
    }

    @SneakyThrows
    @Test
    void qwe(){
        when(request.getParameter("confirm")).thenReturn("firstConfirm");
        when(request.getRequestDispatcher(JspHelper.getPath("firstConfirm"))).thenReturn(dispatcher);

        servlet.doPost(request, response);

        verify(request, times(1)).getRequestDispatcher(JspHelper.getPath("firstConfirm"));
        assertEquals("firstConfirm", request.getParameter("confirm"));
        verify(dispatcher).forward(request, response);

    }

}
