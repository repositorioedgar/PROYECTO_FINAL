<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio Sesión</title>
    </head>
    <body>
        <h1>Inicio de sesión</h1>
        
        <form action="validate.do" method="post">
            <input type="email" name="txtMail" placeholder="E-Mail" required="required"/><br/>
            <input type="password" name="txtPass" placeholder="Contraseña" required="required"/><br/>
            <input type="submit" value="Iniciar Sesión"/>
        </form>
    </body>
</html>
