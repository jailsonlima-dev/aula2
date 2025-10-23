package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.conexao;

public class produtoDAO {

	// LISTAR

	public List<produtoModel> listarProdutos(String desc) {
		Connection conn = null;
		PreparedStatement query = null;
		ResultSet resultado = null;

		List<produtoModel> produtos = new ArrayList<produtoModel>();
		try {
			conn = conexao.getConnection();
			if (conn == null)
				return produtos;
			String sql = "select *from produtos";

			if (desc != null && !desc.isEmpty()) {
				sql = "select *from produtos where nome like ?";
				query = conn.prepareStatement(sql);
				query.setString(1, "%" + desc + "%");
			} else {
				query = conn.prepareStatement(sql);
			}

			resultado = query.executeQuery();

			while (resultado.next()) {
				produtoModel p = new produtoModel(
						resultado.getInt("id_produto"),
						resultado.getString("nome"),
						resultado.getString("descricao"), 
						resultado.getString("codbarras"),
						resultado.getDouble("preco"), 
						resultado.getInt("estoque"),
						resultado.getDate("data_cadastro"), 
						resultado.getDate("data_alteracao"));

				p.setIdProduto(resultado.getInt("id_produto"));
				p.setNome(resultado.getString("nome"));
				p.setDescricao(resultado.getString("descricao"));
				p.setCodBarra(resultado.getString("codbarras"));
				p.setPreco(resultado.getDouble("preco"));
				p.setEstoque(resultado.getInt("estoque"));
				p.setDataCadastro(resultado.getDate("data_cadastro"));
				p.setDataAlteracao(resultado.getDate("data_alteracao"));
				produtos.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtos;
	}

	// INSERT
	public boolean inserirProduto(produtoModel p) {
		Connection conn = null;
		PreparedStatement query = null;
		try {
			conn = conexao.getConnection();
			String sql = "INSERT INTO produtos (nome, descricao, codbarras, preco, estoque, data_cadastro, data_alteracao) "
					+ "VALUES (?, ?, ?, ?, ?, NOW(), NOW())";

			query = conn.prepareStatement(sql);
			query.setString(1, p.getNome());
			query.setString(2, p.getDescricao());
			query.setString(3, p.getCodBarra());
			query.setDouble(4, p.getPreco());
			query.setInt(5, p.getEstoque());

			int inserir = query.executeUpdate();

			return inserir > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// UPDATE

	public boolean atualizarProduto(produtoModel p) {
		Connection conn = null;
		PreparedStatement query = null;
		try {
			conn = conexao.getConnection();
			String sql = "UPDATE produtos SET nome = ?, descricao = ?, CodBarra = ?, preco = ?, estoque = ?, "
					+ "data_alteracao = NOW() WHERE id_produto = ?";

			query = conn.prepareStatement(sql);
			query.setString(1, p.getNome());
			query.setString(2, p.getDescricao());
			query.setString(3, p.getCodBarra());
			query.setDouble(4, p.getPreco());
			query.setInt(5, p.getEstoque());
			query.setInt(6, p.getIdProduto());

			int update = query.executeUpdate();

			return update > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// DELETE
	public boolean excluirProduto(int id_produto) {
		Connection conn = null;
		PreparedStatement query = null;
		try {
			conn = conexao.getConnection();
			String sql = "DELETE FROM produtos WHERE id_produto = ?";
			query = conn.prepareStatement(sql);
			query.setInt(1, id_produto);

			int delete = query.executeUpdate();

			return delete > 1;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
