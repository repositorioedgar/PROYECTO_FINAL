/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.Worker;

/**
 *
 * @author pperezp
 */
@WebServlet(name = "WorkerListServlet", urlPatterns = {"/listarTrabajador.view"})
public class WorkerListServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            DAO dao = new DAO();
            List<Worker> workers = dao.getAll();
            
            String rutBuscar = request.getParameter("txtBuscar");
            
            
            
            PrintWriter out = response.getWriter();
            try {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Listado de trabajadores</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Listado de trabajadores</h1>");
                
                out.println("<form action='listarTrabajador.view' method='post'>");
                    out.println("<input type='text' name='txtBuscar' placeholder='Run'/>");
                    out.println("<input type='submit' value='Buscar aguinaldo'/>");
                    
                    if(rutBuscar != null){
                        int aguinaldo = dao.getAguinaldo(rutBuscar);
                        out.println("Aguinaldo: Bs "+aguinaldo);
                    }
                    
                out.println("</form>");
                
                
                out.println("<table border='1'>");
                    out.println("<tr>");
                        out.println("<td>Run</td>");
                        out.println("<td>Nombre completo</td>");
                        out.println("<td>Sueldo base</td>");
                        out.println("<td>Dcto AFP (13%)</td>");
                        out.println("<td>Dcto Salud (7%)</td>");
                        out.println("<td>Bono Producción</td>");
                        out.println("<td>Aguinaldo</td>");
                        out.println("<td>Sueldo Líquido</td>");
                    out.println("</tr>");
                    
                    for(Worker w : workers){
                        out.println("<tr>");
                            out.println("<td>"+w.getRun()+"</td>");
                            out.println("<td>"+w.getNombre()+" "+
                                    w.getApellidoPaterno()+" "+
                                    w.getApellidoMaterno()+"</td>");
                            out.println("<td>Bs "+w.getSueldoBase()+"</td>");
                            out.println("<td>Bs "+w.getAfp()+"</td>");
                            out.println("<td>Bs "+w.getSalud()+"</td>");
                            out.println("<td>Bs "+w.BONO_PRODUCCION+"</td>");
                            out.println("<td>Bs "+w.getAguinaldo()+"</td>");
                            out.println("<td>Bs "+w.getSueldoLiquido()+"</td>");
                        out.println("</tr>");
                    }
                out.println("</table>");
                
                out.println("<a href='menu.view'>Volver</a>");
                
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
            }
        }   catch (FileNotFoundException ex) {
            Logger.getLogger(WorkerListServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WorkerListServlet.class.getName()).log(Level.SEVERE, null, ex);
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
