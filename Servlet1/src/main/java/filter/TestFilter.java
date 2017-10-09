package filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ysyplay on 2017/8/1.
 */
public class TestFilter implements Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        String password = req.getParameter("pw1");
        if (session.getAttribute("password")==null&&password==null)
        {
            System.out.println("过滤了");
            HttpServletResponse res = (HttpServletResponse) servletResponse;
            res.sendRedirect("../getPostTest.html");
        }
        else
        {
            System.out.println("下一步");
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
