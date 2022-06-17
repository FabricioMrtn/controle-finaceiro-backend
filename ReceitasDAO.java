package br.com.fabricioMrtn.challenge.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.JdbcPreparedStatement;

import br.com.fabricioMrtn.challenge.factory.Conexao;
import br.com.fabricioMrtn.challenge.model.Receita;

public class ReceitasDAO {

	public void save(Receita receita) {
		String sql = "INSERT INTO receitas(DESCRICAO, VALOR, DATA_ENTRADA) VALUES ( ?, ?, ?)";

		Connection conn = null;
		JdbcPreparedStatement jps = null;

		try {
			// Criar uma conexao
			conn = Conexao.createConnectionToMySQL();
			jps = (JdbcPreparedStatement) conn.prepareStatement(sql);
			jps.setString(1, receita.getDESCRICAO());
			jps.setDouble(2, receita.getVALOR());
			jps.setString(3, receita.getDATA_ENTRADA());
			// SE O DATA_ENTRADA FOSSE DATE E N�O STRING, EU TERIA QUE USAR O METODO ABAIXO
			// jps.setDate(3, new Date(receita.getDATA_ENTRADA().getTime()));

			// para executar a query
			jps.execute();

		} catch (Exception e) {
			e.printStackTrace();
			// caso tenha excecoes, ele vai printar
		} finally {

			// fechando as conexoes
			try {
				if (jps != null) {
					jps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void delete(Receita receita) {
		String sql = "DELETE FROM receitas WHERE id=?";

		Connection conn = null;
		JdbcPreparedStatement jps = null;

		try {
			// Criar uma conexao
			conn = Conexao.createConnectionToMySQL();
			jps = (JdbcPreparedStatement) conn.prepareStatement(sql);
			jps.setInt(1, receita.getID());
			// SE O DATA_SAIDA FOSSE DATE E N�O STRING, EU TERIA QUE USAR O METODO ABAIXO
			// jps.setDate(3, new Date(despesa.getDATA_SAIDA().getTime()));

			// para ecxecutar a query
			jps.execute();

		} catch (Exception e) {
			e.printStackTrace();
			// caso tenha excecoes, ele vai printar
		} finally {

			try {
				if (jps != null) {
					jps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void update(Receita receita) {
		String sql = "UPDATE receitas SET DESCRICAO = ?, VALOR = ?, DATA_ENTRADA = ? WHERE id=?";

		Connection conn = null;
		JdbcPreparedStatement jps = null;

		try {
			// Criar uma conexao
			conn = Conexao.createConnectionToMySQL();
			jps = (JdbcPreparedStatement) conn.prepareStatement(sql);
			jps.setString(1, receita.getDESCRICAO());
			jps.setDouble(2, receita.getVALOR());
			jps.setString(3, receita.getDATA_ENTRADA());
			jps.setInt(4, receita.getID());
			// SE O DATA_SAIDA FOSSE DATE E N�O STRING, EU TERIA QUE USAR O METODO ABAIXO
			// jps.setDate(3, new Date(despesa.getDATA_SAIDA().getTime()));

			// para ecxecutar a query
			jps.execute();

		} catch (Exception e) {
			e.printStackTrace();
			// caso tenha excecoes, ele vai printar
		} finally {

			// fechando as conexoes
			try {
				if (jps != null) {
					jps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public List<Receita> getReceita() {
		String sql = "SELECT * FROM receitas";

		List<Receita> receitas = new ArrayList<Receita>();

		Connection conn = null;
		JdbcPreparedStatement jps = null;
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			jps = (JdbcPreparedStatement) conn.prepareStatement(sql);
			rset = jps.executeQuery();

			while (rset.next()) {
				Receita receita = new Receita();

				receita.setID(rset.getInt("id"));
				receita.setDESCRICAO(rset.getString("descricao"));
				receita.setVALOR(rset.getDouble("valor"));
				receita.setDATA_ENTRADA(rset.getString("data_entrada"));

				receitas.add(receita);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (jps != null) {
					jps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return receitas;
	}
}
