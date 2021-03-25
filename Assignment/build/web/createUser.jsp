<%-- 
    Document   : createUser
    Created on : Mar 17, 2021, 1:01:02 PM
    Author     : HP
--%>

<%@page import="kien.dtos.ErrorUserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
     </head>
    <body>
        <%
            ErrorUserDTO userError = (ErrorUserDTO)request.getAttribute("ERROR_USER");
            if(userError == null){
                userError = new ErrorUserDTO("", "", "", "", "");
            }
        %>
        <form action="MainController" method = "POST">
            User ID<input type="text" name="txtUserID"/></br>
            ${requestScope.ERROR_USER.userID}
            Full Name<input type="text" name="txtFullName"/></br>
            <%= userError.getFullName()%></br>
            Password<input type="password" name="txtPassword" required="true"/></br>
            <%= userError.getPassword()%></br>
            RePassword<input type="password" name="txtRePassword" required="true"/></br>
            <%= userError.getRePassword()%></br>
            RoleID<input type="text" name="txtFullName" value="US" readonly="true"/></br>
            <input type="submit" name="btnAction" value="Create"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
