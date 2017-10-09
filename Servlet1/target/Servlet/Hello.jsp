<%--
  Created by IntelliJ IDEA.
  User: ysyplay
  Date: 2017/8/2
  Time: 下午10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%--这是注释--%>
  <%!String name;%>
   request URL is <%=request.getRequestURI()%>
</br>
    <%name = "abc";
    out.println("name is "+name);%>
</body>
</html>
