 <%@ page import="java.util.*" %>
 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
		    <link href="css/bootstrap.min.css" rel="stylesheet">
    		<link href="css/style.css" rel="stylesheet">
	</head>
	
    <body>
    
            <%
                int count = 0;
                String color = "#000";
                String val;
                ArrayList pList;
                System.out.println(request.getAttribute("piList"));
                
                
                    ArrayList al = (ArrayList) request.getAttribute("piList");
                    System.out.println(al);
                    if (al.isEmpty()) {
                        //System.out.println("ok");
                        response.sendRedirect("error.html");
                    }
                    Iterator itr = al.iterator();
                    
                        count++;
                        pList = (ArrayList) itr.next();
                       

                val = pList.get(0).toString();
                System.out.println(val);

            %>
        </table>
        </div>
        </div>
        </div>

                  <script src="js/jquery-3.2.1.min.js"></script>
                       <script src="js/bootstrap.min.js"></script>
                       <script src="js/axios.min.js"></script>
                       <script type="text/javascript" src="js/main.js"></script>
                       <script type="text/javascript">
                       var count = '<%= val %>';
    					getMovies1(count);
    					getMovie();
					</script>
                       
                      
    </body>
</html>