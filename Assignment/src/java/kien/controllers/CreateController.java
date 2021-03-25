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
import kien.daos.UserDAO;
import kien.dtos.UserDTO;
import kien.dtos.ErrorUserDTO;

/**
 *
 * @author HP
 */
public class CreateController extends HttpServlet {

    private static final String SUCCESS = "login.html";
    private static final String ERROR = "createUser.jsp";

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

        try {
            String userID = request.getParameter("txtUserID");
            String fullName = request.getParameter("txtFullName");
            String password = request.getParameter("txtPassword");
            String rePassword = request.getParameter("txtRePassword");
            String roleID = request.getParameter("txtRoleID");
            boolean check = true;
            ErrorUserDTO userError = new ErrorUserDTO("", "", "", "", "");
            if (userID.length() < 3) {
                userError.setUserID("UserID must be >3");
                check = false;
            }
            if (fullName.length() > 51 || fullName.length() < 3) {
                userError.setFullName("Full Name must be[4-50]");
                check = false;               
            }

            if (password.length() < 1) {
                userError.setPassword("Password can't be empty!");
                check = false;
                
            if(!password.equals(rePassword)){
                userError.setRePassword("Hai password ko giong nhau!");
                check = false;
            }    
                UserDAO dao = new UserDAO();
                if(dao.checkExistID(userID)){
                    check = false;
                    userError.setUserID("UserId bi trung roi kia!");
                }
                if(check){
                    UserDTO user = new UserDTO(userID, fullName, password, roleID);
                    dao.insert(user);
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("ERROR_USER", userError);
            }
        } catch (Exception e) {

        } finally {
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>
}

    
