/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kien.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kien.dtos.CartDTO;
import kien.dtos.ProductDTO;

/**
 *
 * @author HP
 */
public class AddtoCartController extends HttpServlet {
private final String ERROR = "error.jsp";
private static final String SUCCESS = "shopping.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try{
            HttpSession session = request.getSession();
            String productString= request.getParameter("ProductDTO");
            String tmp[]= productString.split("-");
            ProductDTO tea = new ProductDTO(tmp[0], tmp[1], 1, Double.parseDouble(tmp[2]));     
            CartDTO cart = new CartDTO();
            cart = (CartDTO) session.getAttribute("Cart");
            if(cart==null){
                cart = new CartDTO();
            }
            for(String prod : cart.getCart().keySet()){
                ProductDTO curProd = cart.getCart().get(prod);
                if(tea.getName().equals(curProd.getName())){
                    tea.setQuantity(tea.getQuantity() + 1);
                    cart.getCart().remove(prod);
                }
            }
            cart.add(tea);
            session.setAttribute("CART", cart);
            url = SUCCESS;
            request.setAttribute("MESSAGE", "You selected: " + tmp[1]+ " succesfully");
        }catch(Exception e){
            
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
