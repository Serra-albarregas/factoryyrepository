package com.serra.API;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import org.json.*;

public class PokemonApiDAO {

    private final String BASE_URL = "https://pokeapi.co/api/v2/";

    public Pokemon getPokemon(String nameOrId) {
        try {
            URL url = new URL(BASE_URL + "pokemon/" + nameOrId);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
            );
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null) sb.append(line);
            reader.close();

            JSONObject json = new JSONObject(sb.toString());

            Pokemon p = new Pokemon();
            p.setId(json.getInt("id"));
            p.setName(json.getString("name"));
            p.setHeight(json.getInt("height"));
            p.setWeight(json.getInt("weight"));
            p.setImageUrl(json.getJSONObject("sprites").getString("front_default"));

            // Tipos
            List<String> types = new ArrayList<>();
            JSONArray typesArr = json.getJSONArray("types");
            for(int i=0; i<typesArr.length(); i++) {
                types.add(typesArr.getJSONObject(i)
                            .getJSONObject("type")
                            .getString("name"));
            }
            p.setTypes(types);
            p.setLastUpdate(LocalDateTime.now());
            return p;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<PokemonListItem> getFirst150() {
        List<PokemonListItem> list = new ArrayList<>();
        try {
            URL url = new URL(BASE_URL + "pokemon?limit=150");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
            );
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null) sb.append(line);
            reader.close();

            JSONObject json = new JSONObject(sb.toString());
            JSONArray results = json.getJSONArray("results");
            for(int i=0; i<results.length(); i++) {
                JSONObject obj = results.getJSONObject(i);
                PokemonListItem item = new PokemonListItem();
                item.setName(obj.getString("name"));
                item.setUrl(obj.getString("url"));
                list.add(item);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}