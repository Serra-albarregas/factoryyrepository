package com.serra.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.serra.data.PokemonRepositoryImpl;
import com.serra.data.interfaces.IPokemonRepository;
import com.serra.model.POJO.Pokemon;

@WebServlet(urlPatterns = { "/detalle" })
public class DetalleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IPokemonRepository repository = new PokemonRepositoryImpl();

        String idStr = req.getParameter("id");

        Pokemon pokemon = null;
        String error = null;

        if (idStr == null || idStr.trim().isEmpty()) {
            error = "Debes indicar un ID.";
        } else {
            int id = 0;
            try {
                id = Integer.parseInt(idStr.trim());
                if (id < 1 || id > 150) {
                    error = "El ID debe estar entre 1 y 150.";
                } else {
                    pokemon = repository.getPokemon(id);
                    if (pokemon == null) {
                        error = "No existe un Pokémon con ese ID.";
                    }
                }
            } catch (NumberFormatException e) {
                error = "El ID debe ser un número válido.";
            }
        }

        req.setAttribute("pokemon", pokemon);
        req.setAttribute("error", error);

        req.getRequestDispatcher("detalle.jsp").forward(req, resp);
    }
}