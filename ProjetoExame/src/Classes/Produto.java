/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Igor Davanço
 */
public class Produto {
    private int id, categoria_id, fornecedor_id;
    private String nome;

    public Produto(int id, int categoria_id, int fornecedor_id, String nome, String descricao) {
        this.id = id;
        this.categoria_id = categoria_id;
        this.fornecedor_id = fornecedor_id;
        this.nome = nome;
    }
    
    public Produto(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public int getFornecedor_id() {
        return fornecedor_id;
    }

    public void setFornecedor_id(int fornecedor_id) {
        this.fornecedor_id = fornecedor_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }  
}
