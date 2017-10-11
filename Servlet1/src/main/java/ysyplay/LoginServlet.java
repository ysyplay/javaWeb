package ysyplay;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ysyplay on 2017/7/31.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        login(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("登陆界面");
        login(request, response);
    }
    public void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = null;
        String username = request.getParameter("name1");
        String password = request.getParameter("pw1");


        HttpSession session = request.getSession();
        if (session.getAttribute("password")!=null)
        {
            password = (String)session.getAttribute("password");
        }


        Cookie[] cookies = request.getCookies();
        if (cookies !=null)
        {
            for (Cookie cookie:cookies)
            {
                if (cookie.getName().equals("user"))
                {
                    username = cookie.getValue();
                }
            }
        }
        try {

            if (username.equals("123") && password.equals("123"))
            {
                session.setAttribute("password",password);
//                session.invalidate();
                Cookie userNameCoolie = new Cookie("user",username);
                userNameCoolie.setMaxAge(30*60);
                response.addCookie(userNameCoolie);

                PrintWriter writer = response.getWriter();
                writer.println("<html>");
                writer.println("<head><title>用户中心</title></head>");
                writer.println("<body>");
                writer.println("<p>用户名：" + username + "</p>");
                writer.println("<p>用户密码：" + password + "</p>");
                writer.println("</body>");
                writer.println("</html>");
                writer.close();
            } else {
                dispatcher = request.getRequestDispatcher("/error.html");
                dispatcher.forward(request, response);
                System.out.println("错误用户名"+username);
                System.out.println("错误密码"+password);
            }
        } catch (Exception e) {
            e.printStackTrace();
            dispatcher = request.getRequestDispatcher("/error.html");
            dispatcher.forward(request,response);
        }

    }
}
