<!DOCTYPE html>
<html>
<head>
<title>Movie Database</title>
</head>
<body>
<h1>Insert Movie Info</h1>
<form action="input">
<table>
<tr><td> <h3> Enter Movie Name     :   </h3> </td> <td><input type="text" name="moviename"></td></tr>
<tr><td> <h3> Enter Movie Language :   </h3> </td><td><input type="text" name="movielanguage"></td></tr>
<tr><td> <h3> Enter Movie Released :   </h3> </td><td><input type="text" name="movieyear"></td></tr>
</table>
<input type="submit">
</form>

  <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
            out.println("<p>" + message + "</p>");
        }
    %>
</body>	
</html>