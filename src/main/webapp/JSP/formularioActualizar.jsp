<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page pageEncoding="UTF-8" contentType="text/html" />

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar</title>
        <link rel="stylesheet" type="text/css" href="${estilo}" />
    </head>
    <body>

        <div id="principal">
            <h2>Actualizaci&oacute;n de datos</h2>
            <form method="post" action="conclusion?op=update">
                <table>
                    <tr>
                        <td>Id</td>
                        <td><input type="text" name="id" value="${presidente.id}" readonly="readonly" /></td>
                    <tr>
                        <td>Nombre del presidente</td>
                        <td><input type="text" name="nombrePresidente" value="${presidente.nombrePresidente}" /></td>
                    </tr>
                    <thead><th>Pais</th></thead>
                    <tr>
                        <td>Nombre del pais</td>
                        <td><input type="text" name="nombrePais" value="${presidente.pais.nombrePais}"/></td>
                    </tr>
                    <input type="hidden" name="idPais" value="${presidente.pais.idPais}" />
                    <tr>
                        <td colspan="2"><input type="submit" name="enviar" value="Enviar" class="boton" /></td>
                    </tr>
                </table>
            </form>
        </div>


    </body>
</html>