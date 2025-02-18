package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ArithmaticServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String content="""
				
				<!DOCTYPE html>
		<html>
		<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		</head>
		<body>
		<form action="arithmatic" method="post" >
		A=<input type="text" name="a"> <br/>
		B=<input type="text" name="b">

		<input type="submit" name="operation" value="add"/>
		<input type="submit" name="operation" value="sub"/>
		<input type="submit" name="operation" value="mul"/>
		<input type="submit" name="operation" value="div"/></form>
		</body>
		</html>
				
				""";
		resp.getWriter().print(content);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int a=Integer.parseInt(req.getParameter("a"));
		int b=Integer.parseInt(req.getParameter("b"));
		String operation=req.getParameter("operation");
		int result=0;
		//call business logic 
		if("add".equals(operation)) {
			result=a+b;
		} else if("sub".equals(operation)) {
			result=a-b;
		} else if("mul".equals(operation)) {
			
			
			result=a*b;
		}else  {
			result=a/b;
			
		}
		
		System.out.println(MessageFormat.format("A {0} {1} B = {2}= {3}",a,operation,b,result));
		
		System.out.println("A = "+a+" "+operation+"B= "+b+" "+result);
		
		req.setAttribute("result", result);
		req.getRequestDispatcher("arithmatic.jsp").forward(req, resp);
//		String content="""
//				
//				<!DOCTYPE html>
//		<html>
//		<head>
//		<meta charset="UTF-8">
//		<title>Insert title here</title>
//		</head>
//		<body>
//		A={0} B={1} c={2} result={3}
//		<form action="arithmatic" method="post" >
//		A=<input type="text" name="a"> <br/>
//		B=<input type="text" name="b">
//
//		<input type="submit" name="operation" value="add"/>
//		<input type="submit" name="operation" value="sub"/>
//		<input type="submit" name="operation" value="mul"/>
//		<input type="submit" name="operation" value="div"/></form>
//		</body>
//		</html>""";
//		PrintWriter out=resp.getWriter();
//		out.print(MessageFormat.format(content,a,operation,b,result));
		
	}
	
}
