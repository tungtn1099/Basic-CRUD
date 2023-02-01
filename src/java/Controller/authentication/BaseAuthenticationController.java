package Controller.authentication;

import Model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author tungtn
 */
@WebServlet(name="BaseAuthenticationController", urlPatterns={"/BaseAuthenticationController"})
public abstract class BaseAuthenticationController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private boolean isAuthenticated(HttpServletRequest request){
        Account account = (Account) request.getSession().getAttribute("account");
        return account!= null;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        if(isAuthenticated(request)){
            processGet(request, response);
        }
        else response.getWriter().println("access denied");
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        if(isAuthenticated(request)){
            processPost(request, response);
        }
        else response.getWriter().println("access denied");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    
    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
