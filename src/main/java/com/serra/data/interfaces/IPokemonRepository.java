package com.serra.data.interfaces;

import java.util.List;

import com.serra.model.DTO.PokemonDTO;
import com.serra.model.POJO.Pokemon;

public interface IPokemonRepository {
    public List<PokemonDTO> getAll();

    public Pokemon getPokemon(int id);
}
