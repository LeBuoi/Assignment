<%-- 
    Document   : viewCart
    Created on : Mar 14, 2021, 11:47:15 PM
    Author     : HP
--%>

<%@page import="kien.dtos.ProductDTO"%>
<%@page import="kien.dtos.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your cart</title>
    </head>

    <h1>Your selected tea!</h1>
    <%
        CartDTO cart = (CartDTO) session.getAttribute("CART");
        if (cart != null) {
    %>
    <table border="1">
        <thead>
            <tr>
                <th>No</th>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
                <th>Delete</th>
                <th>Update</th>
            </tr>
        </thead>
        <tbody>
            <%
                int count = 1;
                double total = 0.0;
                for (ProductDTO tea : cart.getCart().values()) {
                    total += tea.getQuantity() * tea.getPrice();
            %>
        <form action="MainController">
            <tr>
                <td><%=count++%></td>
                <td>
             
                    <input type="text" name="txtID" value="<%=tea.getProductID() %>" readonly="true"/>
                </td>
                <td><%=tea.getName()%></td>
                <td><%=tea.getPrice()%></td>
                <td>
                    
                    <input type="number" name="quantity" value="<%=tea.getQuantity()%>" required="true" />
                </td>
                <td><%=tea.getQuantity() * tea.getPrice()%></td>
                <td>
                   
                    <input type="submit" name="btnAction" value="Delete_CART"/>
                </td>
                <td>
                    <input type="submit" name="btnAction" value="Update_CART"/>
                </td>
            </tr>
        </form>
        <% }
        %>
    </tbody>
    
</table>
        Total: <%= total%>
<%
    }
%>

<a href="MainController?action=add_more">add more</a>
</html>