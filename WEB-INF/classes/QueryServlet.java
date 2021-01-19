package net.control;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name="query", urlPatterns={"/query"})  // Configure the request URL for this servlet (Tomcat 7/Servlet 3.0 upwards)

public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "userdb";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "kostas";
        String password = "kostaswwwhw2";
        Statement st=null;
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("connected!.....");
            String mood = request.getParameter("mood");
			String genre = request.getParameter("genre");
			Double score = Double.parseDouble(request.getParameter("score"));
			int year = Integer.parseInt(request.getParameter("year"));
			
			System.out.println("connected!.....");
            ArrayList al = null;
            ArrayList pid_list = new ArrayList();
            String query = "select * from emp";
            if(mood!=null && !mood.equals("")){
                query = "select title from movies where genre= CASE WHEN '" + genre + "' = 'all' THEN genre ELSE '" + genre +"' END AND mood= CASE WHEN '" + mood + "' = 'all' THEN mood ELSE '" + mood +"' END AND score>="+score+" AND year>="+year+" ORDER by RAND()"
                		+ "LIMIT 1";
                
                
            }
            System.out.println("query " + query);
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            
            while (rs.next()) {
                al = new ArrayList();

                al.add(rs.getString(1));
               // al.add(rs.getString(2));
               //al.add(rs.getString(3));
                //al.add(rs.getString(4));
                System.out.println("al :: " + al);
                pid_list.add(al);
            }

            request.setAttribute("piList", pid_list);
            RequestDispatcher view = request.getRequestDispatcher("view.jsp");
            view.forward(request, response);
            conn.close();
            System.out.println("Disconnected!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "getting records from database through servlet controller";
    }// </editor-fold>
}