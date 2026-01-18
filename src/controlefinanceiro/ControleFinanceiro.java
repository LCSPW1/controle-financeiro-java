/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlefinanceiro;

import model.*;
import java.time.LocalDate;

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
        Usuario usuario = new Usuario("Luis", "luis@email.com", "123456");
        Categoria categoria = new Categoria("Alimentação");

        Movimentacao mov = new Movimentacao(
                LocalDate.now(),
                50.00,
                0,
                "Almoço"
        );

        mov.setUsuario(usuario);
        mov.setCategoria(categoria);

        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Categoria: " + categoria.getNome());
        System.out.println("Valor: R$ " + mov.getValor());
        System.out.println("Tipo: " + (mov.getTipo() == 1 ? "Entrada" : "Saída"));
    }    
}
