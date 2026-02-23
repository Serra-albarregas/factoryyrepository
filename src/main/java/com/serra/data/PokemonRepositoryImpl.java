package com.serra.data;

import com.serra.model.POJO.Pokemon;

import java.util.List;

import com.serra.data.API.IPokemonAPIDAO;
import com.serra.data.DB.IPokemonBDDAO;
import com.serra.data.interfaces.IPokemonRepository;
import com.serra.model.DTO.PokemonDTO;

public class PokemonRepositoryImpl implements IPokemonRepository {
    private IPokemonAPIDAO pokemonApiDAO;
    private IPokemonBDDAO pokemonBDDAO;

    public PokemonRepositoryImpl(){
        this.pokemonApiDAO = PokemonDAOFactory.getApiDAO();
        this.pokemonBDDAO = PokemonDAOFactory.getBDDAO();
    }

    @Override
    public List<PokemonDTO> getAll() {
        return pokemonApiDAO.getFirst150();
    }

    @Override
    public Pokemon getPokemon(int id) {
        Pokemon pokemon = pokemonBDDAO.findById(id);
        if (pokemon == null || pokemon.isExpired(24)) {
            pokemon = pokemonApiDAO.getPokemon(String.valueOf(id));
            if (pokemon!=null) {
                pokemonBDDAO.save(pokemon);
            }
        }

        return pokemon;
    }
}