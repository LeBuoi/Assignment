<%-- 
    Document   : search
    Created on : Mar 17, 2021, 12:36:19 PM
    Author     : HP
--%>

<%@page import="java.util.List"%>
<%@page import="kien.dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <%
            String searchValue = request.getParameter("txtSearch");
            if (searchValue == null) {
                searchValue = "";
            }
        %>
        <h1>Hello : <%= session.getAttribute("LOGIN_USER")%></h1>
        </br>
        <a href="MainController?btnAction=Logout">Logout</a>
        <form action="MainController">
            Search <input type="text" name="txtSearch" value="<%= searchValue%>" />
            <input type="submit" name="btnAction" value="Search"/>
        </form>
        <%
            List<UserDTO> list = (List<UserDTO>) request.getAttribute("LIST_USER");
            if (list != null && !list.isEmpty()) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>User Full</th>
                    <th>Full Name</th>
                    <th>Password</th>
                    <th>Role ID</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (UserDTO dto : list) {
                %>
            <form action="MainController">
                <tr>
                    <td><%= ++count%></td>
                    <td>
                        <%= dto.getUserID()%>
                        <input type="hidden" name="txtUserID" value="<%= dto.getUserID()%>"/>
                    </td>
                    <td><input type="text" name="txtFullName" value="<%= dto.getFullName()%>"/></td>
                    <td><%= dto.getPassword()%></td>
                    <td><input type="text" name="txtRoleID" value="<%= dto.getRoleID()%>"/></td>
                    <td>
                        <a href="MainController?search=<%=request.getParameter("search")%>&action=Delete&userID=<%=dto.getUserID()%>"> Delete</a>
                    </td>
                    <td>
                        <input type="submit" name="btnAction" value="Update"/>
                        <input type="hidden" name="txtSearch" value="<%= searchValue%>"/>
                    </td>
                </tr>
            </form>
                <%
                    }
                %>
                </tbody>
        </table>
        <%
            }
        %>
    </body>
</html>
