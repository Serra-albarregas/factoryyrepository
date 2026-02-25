<%@ page contentType="text/html; charset=UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="es">
<head>
    <title>ERROR 400 — Bad Request</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${ctx}/css/estilos.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

    <div class="pokedex-header">
        <h1>POKÉDEX</h1>
        <p class="subtitle">ERROR REPORT</p>
    </div>

    <div class="pokedex-body" style="max-width: 640px;">

        <!-- Layout: imagen izquierda, texto derecha -->
        <div class="error-page-layout">

            <!-- Hueco para tu imagen -->
            <div class="error-image-slot">
                <%-- Sustituye esta ruta por tu imagen --%>
                <img src="${ctx}/error/error404.gif" alt="Error 400" />
            </div>

            <!-- Bloque de información del error -->
            <div class="error-info">
                <div class="error-code">404</div>
                <div class="error-title">NOT FOUND</div>
                <p class="error-desc">
                    La página solicitada no ha sido encontrada.
                    Comprueba los datos enviados e inténtalo de nuevo.
                </p>
            </div>

        </div>

        <!-- Footer con botón de vuelta -->
        <div class="pokedex-footer">
            <a href="${ctx}/" class="btn-pokedex-close" style="text-decoration:none;">
                ← VOLVER AL INICIO
            </a>
            <div class="leds">
                <div class="led led-red"></div>
                <div class="led led-yellow"></div>
                <div class="led led-green"></div>
            </div>
        </div>

    </div>

</body>
</html>
