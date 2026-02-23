<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="pokemon-detail">

    <c:choose>
        <c:when test="${not empty error}">
            <div class="error">${error}</div>
        </c:when>
        <c:otherwise>
        <!-- Name & ID header -->
        <div class="pokemon-detail-header">
            <div>
                <h2>${pokemon.name}</h2>
                <span class="detail-id">#${pokemon.id}</span>
            </div>
        </div>

        <!-- Sprite in a "screen" frame -->
        <div class="detail-screen">
            <img src="${pokemon.imageUrl}" alt="${pokemon.name}" />
        </div>

        <!-- Types -->
        <div class="detail-types">
            <span class="types-label">TYPE</span>
            <c:forEach var="type" items="${pokemon.types}">
                <span class="type-badge type-${fn:toLowerCase(type)}">${type}</span>
            </c:forEach>
        </div>

        <!-- Stats -->
        <div class="detail-stats" style="margin-top:1rem;">
            <div class="stat-row">
                <span class="stat-label">HEIGHT</span>
                <span class="stat-value">${pokemon.height} m</span>
            </div>
            <div class="stat-row">
                <span class="stat-label">WEIGHT</span>
                <span class="stat-value">${pokemon.weight} kg</span>
            </div>
        </div>
        </c:otherwise>
    </c:choose>

    <!-- Close button -->
    <button class="btn-pokedex-close" data-bs-dismiss="modal">✕ CLOSE</button>

</div>
