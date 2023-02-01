package Controller.student;

import Controller.authentication.BaseAuthenticationController;
import DAL.DepartmentDBContext;
import DAL.StudentDBContext;
import Model.Department;
import Model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author tungtn
 */
public class UpdateController extends BaseAuthenticationController {

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
    
    DepartmentDBContext deptdb = new DepartmentDBContext();
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int stuId = Integer.parseInt(request.getParameter("stuId"));
        StudentDBContext studb = new StudentDBContext();
        Student s = studb.getStudentByID(stuId);
        ArrayList<Department> depts = deptdb.list();
        request.setAttribute("s", s);
        request.setAttribute("depts", depts);
        request.getRequestDispatcher("../view/student/update.jsp").forward(request, response);
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
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Department d = new Department();
        d.setDeptId(Integer.parseInt(request.getParameter("deptId")));
        
        Student s = new Student();
        s.setStuId(Integer.parseInt(request.getParameter("stuId")));
        s.setStuName(request.getParameter("stuName"));
        s.setGender(Boolean.valueOf(request.getParameter("gender")));
        s.setDob(Date.valueOf(request.getParameter("dob")));
        s.setDept(d);
        
        StudentDBContext studb = new StudentDBContext();
        studb.update(s);
        response.sendRedirect("list");
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
