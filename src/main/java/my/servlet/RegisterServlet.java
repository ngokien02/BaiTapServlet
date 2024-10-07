/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package my.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class RegisterServlet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");

        String hoTen = request.getParameter("hoTen");
        String gioiTinh = request.getParameter("gioiTinh");
        String[] soThich = request.getParameterValues("soThich");
        Part part = request.getPart("hinh");

        String realPath = request.getServletContext().getRealPath("uploads");
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        part.write(realPath + "/" + filename);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>"
                    + "<link rel=\"stylesheet\" href=\"RegisterCss.css\"/>");
            out.println("</head>"
                    + "<style>\n"
                    + "        html{\n"
                    + "            font-size: 20px;\n"
                    + "        }\n"
                    + "        div{\n"
                    + "            border-style: solid;\n"
                    + "            border-width: thin;\n"
                    + "            border-color: orange;\n"
                    + "            width: 30%;\n"
                    + "        }\n"
                    + "    </style>");
            out.println("<body>");
            out.println("<div>\n"
                    + "            <h1>Thông tin đã đăng ký</h1>\n"
                    + "            <hr>\n"
                    + "            <ul>\n"
                    + "                <li>Họ tên: <b>" + hoTen + "</b>\n"
                    + "                <li>Giới tính: <b>" + gioiTinh + "</b> \n"
                    + "                <li>Sở thích: <b>" + Arrays.toString(soThich) + "</b>\n"
                    + "                <li>Ảnh đại diện\n <br> <img src=uploads/" + filename + " width=\"200px\"/>"
                    + "            </ul>\n"
                    + "        </div>"
                            + "<a href=\"register.html\"/>\n" +
"        <input type=\"submit\" value=\"Tiếp tục đăng ký\">  \n" +
"        </a>");
            out.println("</body>");
            out.println("</html>");
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
