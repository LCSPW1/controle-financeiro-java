/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlefinanceiro;

import view.*;
import util.TesteConexao;

/**
 *
 * @author luis_
 */
public class ControleFinanceiro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if (TesteConexao.testar()) {
            telaLogin login = new telaLogin();
            login.setVisible(true);
        } else {
            System.exit(0);
        }
    }    
}
