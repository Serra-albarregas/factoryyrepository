package com.serra.data.API;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.serra.model.DTO.PokemonDTO;
import com.serra.model.POJO.Pokemon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PokemonAPIDAOImpl implements IPokemonAPIDAO {

    private final String BASE_URL = "https://pokeapi.co/api/v2/";
    private final Gson gson = new Gson();

    public Pokemon getPokemon(String nameOrId) {
        try {
            URL url = new URI(BASE_URL + "pokemon/" + nameOrId).toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            PokemonResponse response = gson.fromJson(reader, PokemonResponse.class);
            reader.close();

            Pokemon p = new Pokemon();
            p.setId(response.id);
            p.setName(response.name);
            p.setHeight(response.height);
            p.setWeight(response.weight);
            p.setImageUrl(response.sprites.frontDefault);

            List<String> types = new ArrayList<>();
            for (TypeSlot slot : response.types) {
                types.add(slot.type.name);
            }

            p.setTypes(types);
            p.setLastUpdate(LocalDateTime.now());

            return p;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<PokemonDTO> getFirst150() {
        List<PokemonDTO> list = new ArrayList<>();

        try {
            URL url = new URI(BASE_URL + "pokemon?limit=150").toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            PokemonListResponse response = gson.fromJson(reader, PokemonListResponse.class);
            reader.close();

            for (PokemonListItemResponse item : response.results) {
                PokemonDTO pokemon = new PokemonDTO();
                pokemon.setName(item.name);
                pokemon.setUrl(item.url);
                list.add(pokemon);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ===== DTOs internos para mapear JSON como records =====

    private record PokemonResponse(
            int id,
            String name,
            int height,
            int weight,
            Sprites sprites,
            List<TypeSlot> types
    ) {}

    private record Sprites(
            @SerializedName("front_default")        // Para arreglar la coincidencia de nombres
            String frontDefault
    ) {}

    private record TypeSlot(Type type) {}

    private record Type(String name) {}

    private record PokemonListResponse(List<PokemonListItemResponse> results){}

    private record PokemonListItemResponse(
        String name,
        String url
    ) {}
}