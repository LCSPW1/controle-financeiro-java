/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author luis_
 */
public class TesteConexao {
            
    public static boolean testar() {
        try {
            Connection conn = ConexaoDB.getConnection();
            conn.close();
                JOptionPane.showMessageDialog(
                null,
                "Conexão com o banco de dados realizada com sucesso"
            );
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                null,
                "Erro ao conectar com o banco de dados.\nVerifique o MySQL.",
                "Erro de Conexão",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }
}
