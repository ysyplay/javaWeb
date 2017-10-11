package ysyplay;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ysyplay on 2017/9/5.
 */
@Controller
@RequestMapping(value = "/hello")
public class HellowController {
    @RequestMapping(value = "/spring")
    public  void  spring(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("Spring你好");
    }
}
