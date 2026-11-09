<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Safe Driving - Registro Web</title>
    </head>
    <body style="font-family: Arial; margin: 40px;">
        <h2>Safe Driving - Módulo Web de Vehículos</h2>
        
        <!-- Formulario que envía los datos mediante POST al Servlet -->
        <form action="VehiculoServlet" method="POST">
            <label>Placa:</label><br>
            <input type="text" name="placa" required style="padding: 5px; width: 250px;"><br><br>
            
            <label>Marca:</label><br>
            <input type="text" name="marca" required style="padding: 5px; width: 250px;"><br><br>
            
            <label>Modelo:</label><br>
            <input type="text" name="modelo" required style="padding: 5px; width: 250px;"><br><br>
            
            <label>ID Empresa:</label><br>
            <input type="number" name="id_empresa" value="1" required style="padding: 5px; width: 250px;"><br><br>
            
            <input type="submit" value="Guardar Vehículo" style="padding: 10px 15px; background: #007BFF; color: white; border: none; cursor: pointer;">
        </form>
    </body>
</html>