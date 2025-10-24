package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.clienteModel;
import util.conexao;

public class clienteDAO {

	// LISTAR
	public List<clienteModel> listarClientes(String desc) {
		Connection conn = null;
		PreparedStatement query = null;
		ResultSet resultado = null;

		List<clienteModel> clientes = new ArrayList<clienteModel>();
		try {
			conn = conexao.getConnection();
			if (conn == null)
				return clientes;
			String sql = "select * from clientes";

			if (desc != null && !desc.isEmpty()) {
				sql = "select * from clientes where nome like ?";
				query = conn.prepareStatement(sql);
				query.setString(1, "%" + desc + "%");
			} else {
				query = conn.prepareStatement(sql);
			}

			resultado = query.executeQuery();

			while (resultado.next()) {
				clienteModel c = new clienteModel(resultado.getInt("id_cliente"), 
						resultado.getString("nome"),
						resultado.getString("cpf"), 
						resultado.getString("telefone"), 
						resultado.getString("email"),
						resultado.getDate("data_cadastro"),
						resultado.getDate("data_alteracao"));

				c.setIdCliente(resultado.getInt("id_cliente"));
				c.setNome(resultado.getString("nome"));
				c.setCpf(resultado.getString("cpf"));
				c.setEmail(resultado.getString("email"));
				c.setTelefone(resultado.getString("telefone"));
				c.setDataCadastro(resultado.getDate("data_cadastro"));
				c.setDataAlteracao(resultado.getDate("data_alteracao"));
				clientes.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}

	// INSERT
	public boolean inserirCliente(clienteModel c) {
		Connection conn = null;
		PreparedStatement query = null;
		try {
			conn = conexao.getConnection();
			String sql = "INSERT INTO clientes (nome, cpf, telefone, email, data_cadastro, data_alteracao) "
					+ "VALUES (?, ?, ?, ?,NOW(), NOW())";

			query = conn.prepareStatement(sql);
			query.setString(1, c.getNome());
			query.setString(2, c.getCpf());
			query.setString(3, c.getTelefone());
			query.setString(4, c.getEmail());

			int inserir = query.executeUpdate();

			return inserir > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// UPDATE
	public boolean atualizarCliente(clienteModel c) {
		Connection conn = null;
		PreparedStatement query = null;
		try {
			conn = conexao.getConnection();
			String sql = "UPDATE clientes SET nome=?, cpf=?, telefone=?, email=?, data_alteracao = NOW() WHERE id_cliente=?";

			query = conn.prepareStatement(sql);
			query.setString(1, c.getNome());
			query.setString(2, c.getCpf());
			query.setString(3, c.getTelefone());
			query.setString(4, c.getEmail());
			query.setInt(5, c.getIdCliente());

			int update = query.executeUpdate();

			return update > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// DELETE
		public boolean excluirCliente(int id_cliente) {
			Connection conn = null;
			PreparedStatement query = null;
			try {
				conn = conexao.getConnection();
		        String sql = "DELETE FROM clientes WHERE id_cliente = ?";
				query = conn.prepareStatement(sql);
				query.setInt(1, id_cliente);

				int delete = query.executeUpdate();

				return delete > 1;

			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

}
