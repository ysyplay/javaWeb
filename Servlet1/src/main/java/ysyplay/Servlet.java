package ysyplay;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ysyplay on 2017/7/27.
 */
@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name2 = request.getParameter("name2");
        String pw2 = request.getParameter("pw2");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    调用doPost 方法 ");
        out.println("<br></br>");
        out.println("用户名:" + name2);
        out.println("<br></br>");
        out.println("密码:" + pw2);
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Get方法");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.println("FirstServlet");
        pw.println("用户名："+request.getParameter("name1"));
        pw.println("密码："+request.getParameter("pw1"));
        pw.close();
    }

    @Override
    public void init() throws ServletException
    {
        super.init();
        System.out.println("init方法");
       ServletConfig config = this.getServletConfig();
       String v1 = config.getInitParameter("namespace1");
       String V2 = config.getInitParameter("namespace2");
       System.out.println("v1:  "+v1);
       System.out.println("v2:  "+V2);

//        ServletContext 可以在多个Servlet类中使用 传递值 修改
        ServletContext ctx = this.getServletContext();
        String global = ctx.getInitParameter("globalparam1");
        System.out.println("globalparam1:  "+global);

        ctx.setAttribute("attri1","11111");
        String attri1 = (String) ctx.getAttribute("attri1");
        System.out.println("attri1修改前:  "+attri1);

        ctx.setAttribute("attri1","222222");
         attri1 = (String) ctx.getAttribute("attri1");
        System.out.println("attri1修改后:  "+attri1);
//      web资源
    }

    @Override
    public void destroy()
    {
        super.destroy();
        System.out.println("destroy方法");
    }
}
