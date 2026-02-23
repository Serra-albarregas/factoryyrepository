package com.serra.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.serra.data.PokemonRepositoryImpl;
import com.serra.data.interfaces.IPokemonRepository;
import com.serra.model.DTO.PokemonDTO;

@WebServlet(urlPatterns = {"/galeria"})
public class GaleriaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IPokemonRepository repository = new PokemonRepositoryImpl();

        List<PokemonDTO> pokemons = repository.getAll();
        req.setAttribute("pokemons", pokemons);
        req.getRequestDispatcher("galeria.jsp").forward(req, resp);
    }
}
