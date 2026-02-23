package com.serra.data.DB;

import com.serra.model.POJO.Pokemon;

public interface IPokemonBDDAO {
    public Pokemon findById(int id);

    public void save(Pokemon p);

    public boolean isExpired(int id, int ttlHours);
}
