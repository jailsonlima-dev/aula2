package model;

import java.util.Date;

public class produtoModel {
	private int id_produto;
    private String nome;
    private String descricao;
    private double preco;
    private int estoque;
    private Date data_cadastro;
    private Date data_alteracao;

  
    public produtoModel(int id_produto, String nome, String descricao, double preco, int estoque, 
                        Date data_cadastro, Date data_alteracao) {
        this.id_produto = id_produto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.data_cadastro = data_cadastro;
        this.data_alteracao = data_alteracao;
    }



        public int getIdProduto() {
        return id_produto;
    }

    public void setIdProduto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Date getDataCadastro() {
        return data_cadastro;
    }

    public void setDataCadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public Date getDataAlteracao() {
        return data_alteracao;
    }

    public void setDataAlteracao(Date data_alteracao) {
        this.data_alteracao = data_alteracao;
    }
}
