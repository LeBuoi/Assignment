<%@page import="java.util.List"%>
<%@page import="kien.dtos.UserDTO"%>
<%@page import="kien.dtos.ProductDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Milk Tea Luxury</title>
    </head>
    <body>
        <%
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user == null) {
                //user = new UserDTO ("","","","");
                /*response.sendRedirect("login.html");
            return;*/
                response.sendRedirect("login.html");
                return;
            }
        %>
        <h1>Welcome: <%= ((UserDTO) session.getAttribute("LOGIN_USER")).getFullName()%></h1>
        <form action="MainController"> 
            <input type="submit" name="action" value="Logout">
        </form>       
        <%
            List<ProductDTO> list = (List<ProductDTO>) request.getAttribute("LIST_PRODUCT");
            if (list != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Tea ID</th>
                    <th>Tea Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (ProductDTO dto : list) {
                %>
            <form action="MainController">

                <tr>
                    <td><%= count++%></td>
                    <td>
                        <%= dto.getProductID()%>
                    </td>
                    <td><%= dto.getName()%></td>
                    <td><%= dto.getQuantity()%></td>
                    <td><%= dto.getPrice()%></td>
                <input type="submit" name="action" value="Add"/>
                <input type="submit" name="action" value="View Cart"/>

                </tr>
                <%
                    }
                %>
                </tbody>
                <%
                    }
                %>
                </body>
                </html>
