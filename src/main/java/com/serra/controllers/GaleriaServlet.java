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
import com.serra.model.POJO.Pokemon;

@WebServlet(urlPatterns = {"/galeria"})
public class GaleriaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IPokemonRepository repository = new PokemonRepositoryImpl();

        List<PokemonDTO> pokemons = repository.getAll();
        for (PokemonDTO pokemonDTO : pokemons) {
            System.out.println(pokemonDTO.getName());
        }
        Pokemon pokemon = repository.getPokemon(1);
        System.out.println(pokemon.getName());
        pokemon = repository.getPokemon(2);
        System.out.println(pokemon.getName());
        pokemon = repository.getPokemon(3);
        System.out.println(pokemon.getName());
        pokemon = repository.getPokemon(4);
        System.out.println(pokemon.getName());
    }
}
