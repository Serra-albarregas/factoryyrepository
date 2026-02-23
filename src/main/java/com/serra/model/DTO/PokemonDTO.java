package com.serra.model.DTO;

public class PokemonDTO {

    private String name;
    private String url;

    public PokemonDTO() {
    }

    public PokemonDTO(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId(){
        String[] parts = url.split("/");
        return Integer.parseInt(parts[parts.length - 1]);
    }
}