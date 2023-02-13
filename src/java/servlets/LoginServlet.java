/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author khanhhoanguyen
 */
public class LoginServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String logout = request.getParameter("action");
        if(logout != null && logout.equals("logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            
            request.setAttribute("message", 
                    "You have successfully logged out");
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp" )
                .forward(request, response);
            return;
        }
                

        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                response.sendRedirect("/Week5Lab_MyLogin/home");
                return;
            }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp" )
            .forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = null; 
        
        AccountService validate = new AccountService();
        if(username == null || username.equals("") || password == null
           || password.equals("")){
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("message", 
                    "Please enter your username and password");
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp" )
                .forward(request, response);
            return;
        } 
        
        user = validate.login(username, password);
        
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("/Week5Lab_MyLogin/home");
        }
        else {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("message", 
                    "Sorry, invalid username and/or password");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp" )
                .forward(request, response);
        }
        
     
    }

}
