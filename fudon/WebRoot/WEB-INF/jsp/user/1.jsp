<!-- jsp的本质是java的servlet类，jsp的代码最终都要变成java代码去编译 -->
<!-- 编译器指令 import会在java代码中插入了java.awt.*包-->

<b>fudon</b>

<!-- page指令 -->
<%@ page contentType="text/html;charset=utf-8" import="java.awt.*,java.util.*" %>
<%@ page session="true" %>//如果为false,下面就不能用内置对象session

<!-- ERROR指令:当执行下面的java代码时报错，就跳到这个页面 -->>
<%@ page errorPage="error.jsp" %>
<%
	//int a = 1/0;
%>

<!-- 分文件源码静态导入:inVar是included.jsp的变量 -->
<%--  <%@ include file="included.jsp" %> --%>
<% 
/* 	System.out.println(inVar);	
 */
 %>
 
 <!-- 动态导入 -->
<jsp:include page="included.jsp"></jsp:include>


<!-- 表达式语句 1.不能和java代码写在一起，即只是jsp的句子，在java中是 out.pringln(value+ 5) -->
<%
	int value = 5;
	testMethod();
%>
<%=value+3 %>

<!-- 声明，为类增加实例变量和方法，在上面有调用	【用的少】  -->
<%!
	int instance= 6;
	void testMethod(){
		System.out.println("HERE");
	}
%>

<!-- 内置对象response,同类功能的内置对象out,一般建议用out来输出 -->
<!-- 内置对象session -->
<!-- 内置对象application -->
<!-- 内置对象pageContext -->
<%
	response.getWriter().println("\n\nChina");
	out.println("I LOVE CHINA\n");
	session.setAttribute("a","ccc");
	application.setAttribute("b", "ddd");
	//pageContext.forward("fuhope.html");
%>



