package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.Worker;

@WebServlet(name = "WorkerRegisterServlet", urlPatterns = {"/workerRegister.do"})
public class WorkerRegisterServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PrintWriter o = response.getWriter();
            
            
            response.setContentType("text/html;charset=UTF-8");
            
            String rut, nombre, apeP, apeM;
            double sb;
            rut = request.getParameter("txtRut");
            nombre = request.getParameter("txtNombre");
            apeP = request.getParameter("txtApeP");
            apeM = request.getParameter("txtApeM");
            sb = Double.parseDouble(request.getParameter("txtSueldoBase"));
            
            Worker newWorker = new Worker(rut, nombre, apeP, apeM, sb);
            
            DAO dao = new DAO();
            dao.create(newWorker);
            request.getRequestDispatcher("registrarTrabajador.jsp").forward(request, response);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WorkerRegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WorkerRegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
