<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page pageEncoding="UTF-8" contentType="text/html" />

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta</title>
        <link rel="stylesheet" type="text/css" href="${estilo}" />
    </head>
    <body>

        <div id="principal">
            <h2>Actualizaci&oacute;n de datos</h2>
            <form method="post" action="control?op=add">
                <table>
                    <thead><th>Presidente</th></thead>

                    <tr>
                        <td>Nombre del presidente</td>
                        <td><input type="text" name="nombrePresidente" /></td>
                    </tr>
                    <thead><th>Pais</th></thead>
                    <tr>
                        <td>Nombre del pais</td>
                        <td><input type="text" name="nombrePais" /></td>
                    </tr>

                    <tr>

                        <td colspan="2"><input type="submit" name="enviar" value="Enviar" class="boton" /></td>
                    </tr>
                </table>
            </form>
        </div>


    </body>
</html>