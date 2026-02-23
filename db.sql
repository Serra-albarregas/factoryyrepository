-- ==========================================
-- Base de datos: pokedex
-- ==========================================

CREATE DATABASE IF NOT EXISTS pokedex;
USE pokedex;

-- ==========================================
-- Tabla principal: pokemon
-- ==========================================
CREATE TABLE IF NOT EXISTS pokemon (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    height INT,
    weight INT,
    image_url VARCHAR(255),
    last_update DATETIME NOT NULL
);

-- ==========================================
-- Tabla de tipos de pokemon
-- ==========================================
CREATE TABLE IF NOT EXISTS pokemon_type (
    pokemon_id INT NOT NULL,
    type VARCHAR(20) NOT NULL,
    PRIMARY KEY(pokemon_id, type),
    FOREIGN KEY (pokemon_id) REFERENCES pokemon(id) ON DELETE CASCADE
);

-- ==========================================
-- Índices útiles
-- ==========================================
CREATE INDEX idx_type ON pokemon_type(type);