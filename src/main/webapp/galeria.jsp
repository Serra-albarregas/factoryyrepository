<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="es">
<head>
    <title>Pokédex</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${ctx}/css/estilos.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

    <!-- Header -->
    <div class="pokedex-header">
        <h1>POKÉDEX</h1>
        <p class="subtitle">NATIONAL POKÉDEX</p>
    </div>

    <!-- Pokédex shell -->
    <div class="pokedex-body">

        <!-- Grid of cards -->
        <div class="pokemon-grid" id="pokemonGrid">
            <c:forEach var="pokemon" items="${pokemons}">
                <div class="pokemon-card" data-id="${pokemon.id}" data-name="${pokemon.name}">
                    <span class="card-id">#<c:out value="${pokemon.id}" /></span>
                    <span class="card-name">${pokemon.name}</span>
                </div>
            </c:forEach>
        </div>

        <!-- Footer -->
        <div class="pokedex-footer">
            <span class="count-display" id="pokemonCount">
                <c:out value="${fn:length(pokemons)}" /> POKÉMON
            </span>
            <div class="leds">
                <div class="led led-red"></div>
                <div class="led led-yellow"></div>
                <div class="led led-green"></div>
            </div>
        </div>

    </div><!-- /.pokedex-body -->

    <!-- Modal -->
    <div class="modal fade" id="pokemonModal" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-body" id="modalBody">
                    <div class="loading-pixel">LOADING...</div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="${ctx}/js/CargaModal.js"></script>
</body>
</html>
