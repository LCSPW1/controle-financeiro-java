/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Usuario;
import util.ConexaoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author luis_
 */
public class UsuarioDAO {
    public boolean login(String email, String senha) {
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
        
        try (Connection conn = ConexaoDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, senha);
            
            ResultSet rs = ps.executeQuery();
            
            return rs.next();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }
    
    public void cadastrar(Usuario u) {
        
        System.out.println("ENTROU NO MÉTODO CADASTRAR"); // APENAS PARA TESTE
        
        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";
        
        try (Connection conn = ConexaoDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getSenha());
            
            ps.executeUpdate();
            
            System.out.println("INSERT EXECUTADO COM SUCESSO"); // APENAS PARA TESTE
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
