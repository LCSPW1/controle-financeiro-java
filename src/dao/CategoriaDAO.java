/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConexaoDB;
import java.sql.ResultSet;

/**
 *
 * @author luis_
 */
public class CategoriaDAO {
    public List<Categoria> listarCategorias() {
    String sql = "SELECT * FROM categoria ORDER BY nome ASC";
    List<Categoria> lista = new ArrayList<>();
    
    try (Connection conn = ConexaoDB.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        
        while (rs.next()) {
            lista.add(new Categoria(
                rs.getInt("id_categoria"),
                rs.getString("nome")
            ));
        }
    } catch (SQLException e) {
        System.out.println("Erro ao listar categorias: " + e.getMessage());
    }
    return lista;
}
}
