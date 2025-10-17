package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.funcionarioModel;
import util.conexao;

public class funcionarioDAO {

	// LISTAR

	public List<funcionarioModel> listarFuncionarios(String desc) {
		Connection conn = null;
		PreparedStatement query = null;
		ResultSet resultado = null;

		List<funcionarioModel> funcionarios = new ArrayList<funcionarioModel>();
		try {
			conn = conexao.getConnection();
			if (conn == null)
				return funcionarios;
			String sql = "select *from funcionarios";

			if (desc != null && !desc.isEmpty()) {
				sql = "select *from funcionarios where nome like ?";
				query = conn.prepareStatement(sql);
				query.setString(1, "%" + sql + "%");
			} else {
				query = conn.prepareStatement(sql);
			}

			resultado = query.executeQuery();

			while (resultado.next()) {
				funcionarioModel f = new funcionarioModel(resultado.getInt("id_funcionario"),
						resultado.getString("nome"), resultado.getString("cpf"), resultado.getString("rg"),
						resultado.getString("cargo"), resultado.getString("salario"), resultado.getString("usuario"),
						resultado.getString("senha"), resultado.getDate("data_cadastro"),
						resultado.getDate("data_alteracao"));
				f.setID(resultado.getInt("id_funcionario"));
				f.setNome(resultado.getString("nome"));
				f.setCPF(resultado.getString("cpf"));
				f.setRG(resultado.getString("rg"));
				f.setCargo(resultado.getString("cargo"));
				f.setSalario(resultado.getString("salario"));
				f.setUsuario(resultado.getString("usuario"));
				f.setSenha(resultado.getString("senha"));
				f.setDataCadastro(resultado.getDate("data_cadastro"));
				f.setDataAlteracao(resultado.getDate("data_alteracao"));
				funcionarios.add(f);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return funcionarios;
	}

	// INSERT
	public boolean inserirFuncionario(funcionarioModel f) {
		Connection conn = null;
		PreparedStatement query = null;
		try {
			conn = conexao.getConnection();
			String sql="insert funcionarios"+
					"(nome,cpf,rg,cargo,salario,usuario,senha,data_cadastro,data_alteracao)"+
					" values (?,?,?,?,?,?,?,now(),null)";
			
			query=conn.prepareStatement(sql);
			query.setString(1, f.getNome());
			query.setString(2, f.getCPF());
			query.setString(3, f.getRG());
			query.setString(4, f.getCargo());
			query.setString(5, f.getSalario());
			query.setString(6, f.getUsuario());
			query.setString(7, f.getSenha());
			

			int inserir = query.executeUpdate();

			return inserir > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// UPDATE

	public boolean atualizaFuncionario(funcionarioModel f) {
		Connection conn = null;
		PreparedStatement query = null;
		try {
			conn = conexao.getConnection();
			String sql="update funcionarios set nome=?, cpf=?, rg=?, cargo=?,"+
					"salario=?, usuario=?, senha=?, data_alteracao=now() where id_funcionario=?";
			
			query=conn.prepareStatement(sql);
			query.setString(1, f.getNome());
			query.setString(2, f.getCPF());
			query.setString(3, f.getRG());
			query.setString(4, f.getCargo());
			query.setString(5, f.getSalario());
			query.setString(6, f.getUsuario());
			query.setString(7, f.getSenha());
			query.setInt(8, f.getID());

			int update = query.executeUpdate();

			return update > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	// DELETE
	public boolean excluirFuncionario(int id) {
		Connection conn = null;
		PreparedStatement query = null;
		try {
			conn = conexao.getConnection();
			String sql="delete from funcionarios where id_funcionario=?";
			query=conn.prepareStatement(sql);
			query.setInt(1, id);
			
			int delete = query.executeUpdate();
			
			return delete >1;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
