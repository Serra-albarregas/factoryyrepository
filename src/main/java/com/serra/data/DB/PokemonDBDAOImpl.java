package com.serra.data.DB;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.serra.model.POJO.Pokemon;

public class PokemonDBDAOImpl implements IPokemonBDDAO {

    public Pokemon findById(int id) {
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(
                "SELECT id, name, height, weight, image_url, last_update FROM pokemon WHERE id=?"
            );
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Pokemon p = new Pokemon();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setHeight(rs.getInt("height"));
                p.setWeight(rs.getInt("weight"));
                p.setImageUrl(rs.getString("image_url"));
                p.setLastUpdate(rs.getTimestamp("last_update").toLocalDateTime());

                PreparedStatement ps2 = con.prepareStatement(
                    "SELECT type FROM pokemon_type WHERE pokemon_id=?"
                );
                ps2.setInt(1, id);
                ResultSet rs2 = ps2.executeQuery();
                List<String> types = new ArrayList<>();
                while(rs2.next()) types.add(rs2.getString("type"));
                p.setTypes(types);

                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(Pokemon p) {
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(
                "REPLACE INTO pokemon (id,name,height,weight,image_url,last_update) VALUES (?,?,?,?,?,?)"
            );
            ps.setInt(1, p.getId());
            ps.setString(2, p.getName());
            ps.setInt(3, p.getHeight());
            ps.setInt(4, p.getWeight());
            ps.setString(5, p.getImageUrl());
            ps.setTimestamp(6, Timestamp.valueOf(p.getLastUpdate()));
            ps.executeUpdate();

            // Borrar tipos existentes
            ps = con.prepareStatement("DELETE FROM pokemon_type WHERE pokemon_id=?");
            ps.setInt(1, p.getId());
            ps.executeUpdate();

            // Insertar tipos
            for(String t : p.getTypes()) {
                ps = con.prepareStatement(
                    "INSERT INTO pokemon_type (pokemon_id,type) VALUES (?,?)"
                );
                ps.setInt(1, p.getId());
                ps.setString(2, t);
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isExpired(int id, int ttlHours) {
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(
                "SELECT last_update FROM pokemon WHERE id=?"
            );
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                LocalDateTime last = rs.getTimestamp("last_update").toLocalDateTime();
                return last.plusHours(ttlHours).isBefore(LocalDateTime.now());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}