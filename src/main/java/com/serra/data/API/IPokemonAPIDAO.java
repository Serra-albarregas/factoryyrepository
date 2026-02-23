package com.serra.data.API;

import java.util.List;

import com.serra.model.DTO.PokemonDTO;
import com.serra.model.POJO.Pokemon;

public interface IPokemonAPIDAO {
    public Pokemon getPokemon(String nameOrId);

    public List<PokemonDTO> getFirst150();
}
