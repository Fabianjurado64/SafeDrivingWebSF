package com.safedriving.controlador;

import com.safedriving.dao.VehiculoDAO;
import com.safedriving.modelo.Vehiculo;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "VehiculoServlet", urlPatterns = {"/VehiculoServlet"})
public class VehiculoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // 1. Recibir los datos enviados por el formulario HTML (método POST)
        String placa = request.getParameter("placa");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        int idEmpresa = Integer.parseInt(request.getParameter("id_empresa"));

        // 2. Crear el objeto Vehiculo con los datos recibidos
        Vehiculo nuevoVehiculo = new Vehiculo(0, placa, marca, modelo, idEmpresa);

        // 3. Llamar al DAO para insertar el vehículo en la base de datos de XAMPP
        VehiculoDAO dao = new VehiculoDAO();
        dao.insertarVehiculo(nuevoVehiculo);

        // 4. Mostrar un mensaje de respuesta en el navegador web
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado - Safe Driving</title>");            
            out.println("</head>");
            out.println("<body style='font-family: Arial; margin: 40px;'>");
            out.println("<h2 style='color: green;'>¡Vehículo registrado con éxito desde la Web!</h2>");
            out.println("<p><strong>Placa:</strong> " + placa + "</p>");
            out.println("<p><strong>Marca:</strong> " + marca + "</p>");
            out.println("<p><strong>Modelo:</strong> " + modelo + "</p>");
            out.println("<br><a href='index.jsp'>Registrar otro vehículo</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}