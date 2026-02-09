/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Movimentacao;
import util.ConexaoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis_
 */
public class MovimentacaoDAO {
    public void inserirEntrada(Movimentacao m) {

            String sql = """
                INSERT INTO movimentacao
                (valor, descricao, data, tipo, id_usuario, id_categoria)
                VALUES (?, ?, ?, 1, ?, ?)
            """;

            try (Connection conn = ConexaoDB.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setDouble(1, m.getValor());
                ps.setString(2, m.getDescricao());
                ps.setDate(3, java.sql.Date.valueOf(m.getData()));
                ps.setInt(4, m.getIdUsuario());
                ps.setInt(5, m.getIdCategoria());

                ps.executeUpdate();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    
        public void inserirSaida(Movimentacao m) {

            String sql = """
                INSERT INTO movimentacao
                (valor, descricao, data, tipo, id_usuario, id_categoria)
                VALUES (?, ?, ?, 0, ?, ?)
            """;

            try (Connection conn = ConexaoDB.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setDouble(1, m.getValor());
                ps.setString(2, m.getDescricao());
                ps.setDate(3, java.sql.Date.valueOf(m.getData()));
                ps.setInt(4, m.getIdUsuario());
                ps.setInt(5, m.getIdCategoria());

                ps.executeUpdate();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    
    public List<Movimentacao> listarPorTipo(int tipoCodigo) {
        String sql = "SELECT m.*, c.nome AS nome_categoria " +
                     "FROM movimentacao m " +
                     "INNER JOIN categoria c ON m.id_categoria = c.id_categoria " +
                     "WHERE m.tipo = ?"; // O banco vai comparar com 0 ou 1

        List<Movimentacao> lista = new ArrayList<>();
        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, tipoCodigo); // Enviamos o número (0 ou 1)
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Movimentacao m = new Movimentacao();
                m.setData(rs.getDate("data").toLocalDate());
                m.setDescricao(rs.getString("descricao"));
                m.setValor(rs.getDouble("valor"));
                m.setNomeCategoria(rs.getString("nome_categoria"));
                lista.add(m);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return lista;
    }
}
