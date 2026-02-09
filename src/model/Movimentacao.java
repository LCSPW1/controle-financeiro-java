/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author luis_
 */
public class Movimentacao {
    private int id;
    private LocalDate data;
    private double valor;
    private int tipo; // 0 saída | 1 entrada
    private String descricao;
    private int idUsuario;
    private int idCategoria;
    private String categoriaNome;
    
    public Movimentacao() {
    }
    
    public Movimentacao(LocalDate data, double valor, int tipo, String descricao) {
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public String getNomeCategoria() { return categoriaNome; }
    public void setNomeCategoria(String categoriaNome) { this.categoriaNome = categoriaNome; }
}
