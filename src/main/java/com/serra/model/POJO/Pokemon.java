package com.serra.model.POJO;

import java.time.LocalDateTime;
import java.util.List;

public class Pokemon {

    private int id;
    private String name;
    private int height;
    private int weight;
    private String imageUrl;
    private List<String> types;
    private LocalDateTime lastUpdate;

    public Pokemon() {
    }

    public Pokemon(int id, String name, int height, int weight, String imageUrl, List<String> types, LocalDateTime lastUpdate) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.imageUrl = imageUrl;
        this.types = types;
        this.lastUpdate = lastUpdate;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getTypes() {
        return this.types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public LocalDateTime getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
}