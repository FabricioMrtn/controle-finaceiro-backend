package br.com.fabricioMrtn.challenge.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.JdbcPreparedStatement;

import br.com.fabricioMrtn.challenge.factory.Conexao;
import br.com.fabricioMrtn.challenge.model.Despesa;

public class DespesasDAO {

	public void save(Despesa despesas) {
		String sql = "INSERT INTO despesas(DESCRICAO, VALOR, DATA_SAIDA) VALUES ( ?, ?, ?)";

		Connection conn = null;
		JdbcPreparedStatement jps = null;

		try {
			// Criar uma conexao
			conn = Conexao.createConnectionToMySQL();
			jps = (JdbcPreparedStatement) conn.prepareStatement(sql);
			jps.setString(1, despesas.getDESCRICAO());
			jps.setDouble(2, despesas.getVALOR());
			jps.setString(3, despesas.getDATA_SAIDA());
			// SE O DATA_ENTRADA FOSSE DATE E NÃO STRING, EU TERIA QUE USAR O METODO ABAIXO
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

	public void delete(Despesa despesa) {
		String sql = "DELETE FROM despesas WHERE id=?";

		Connection conn = null;
		JdbcPreparedStatement jps = null;

		try {
			// Criar uma conexao
			conn = Conexao.createConnectionToMySQL();
			jps = (JdbcPreparedStatement) conn.prepareStatement(sql);
			jps.setInt(1, despesa.getID());
			// SE O DATA_SAIDA FOSSE DATE E NÃO STRING, EU TERIA QUE USAR O METODO ABAIXO
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

	public void update(Despesa despesa) {
		String sql = "UPDATE despesas SET DESCRICAO = ?, VALOR = ?, DATA_SAIDA = ? WHERE id=?";

		Connection conn = null;
		JdbcPreparedStatement jps = null;

		try {
			// Criar uma conexao
			conn = Conexao.createConnectionToMySQL();
			jps = (JdbcPreparedStatement) conn.prepareStatement(sql);
			jps.setString(1, despesa.getDESCRICAO());
			jps.setDouble(2, despesa.getVALOR());
			jps.setString(3, despesa.getDATA_SAIDA());
			jps.setInt(4, despesa.getID());
			// SE O DATA_SAIDA FOSSE DATE E NÃO STRING, EU TERIA QUE USAR O METODO ABAIXO
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

	public List<Despesa> getDespesa() {
		String sql = "SELECT * FROM despesas";

		List<Despesa> despesas = new ArrayList<>();

		Connection conn = null;
		JdbcPreparedStatement jps = null;
		// CLASSE QUE VAI RECUPERAR OS DADOS DO BANCO
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			jps = (JdbcPreparedStatement) conn.prepareStatement(sql);
			rset = jps.executeQuery();

			while (rset.next()) {
				Despesa despesa = new Despesa();

				despesa.setID(rset.getInt("id"));
				despesa.setDESCRICAO(rset.getString("descricao"));
				despesa.setVALOR(rset.getDouble("valor"));
				despesa.setDATA_SAIDA(rset.getString("data_saida"));

				despesas.add(despesa);
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
		return despesas;
	}
}
