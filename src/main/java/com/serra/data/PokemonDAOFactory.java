package com.serra.data;

import com.serra.data.API.IPokemonAPIDAO;
import com.serra.data.API.PokemonAPIDAOImpl;
import com.serra.data.DB.IPokemonBDDAO;
import com.serra.data.DB.PokemonDBDAOImpl;

public abstract class PokemonDAOFactory {
    public static IPokemonBDDAO getBDDAO(){
        return new PokemonDBDAOImpl();
    }

    public static IPokemonAPIDAO getApiDAO(){
        return new PokemonAPIDAOImpl();
    }
}
