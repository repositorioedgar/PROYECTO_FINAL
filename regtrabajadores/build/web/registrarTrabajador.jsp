<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registrar Trabajador</h1>
        
        <form action="workerRegister.do" method="post">
            <input type="text" name="txtRut" placeholder="Rut" required="required"/><br/>
            <input type="text" name="txtNombre" placeholder="Nombre" required="required"/><br/>
            <input type="text" name="txtApeP" placeholder="Apellido Paterno" required="required"/><br/>
            <input type="text" name="txtApeM" placeholder="Apellido Materno" required="required"/><br/>
            Bs<input type="number" name="txtSueldoBase" placeholder="Sueldo Base" required="required"/><br/>
            <input type="submit" value="Registrar"/>
        </form>
        
        <a href="menu.view">Volver</a>
    </body>
</html>
