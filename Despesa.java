package br.com.fabricioMrtn.challenge.model;

public class Despesa {
	private int ID;
	private String DESCRICAO;
	private double VALOR;
	private String DATA_SAIDA;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDESCRICAO() {
		return DESCRICAO;
	}
	public void setDESCRICAO(String dESCRICAO) {
		DESCRICAO = dESCRICAO;
	}
	public double getVALOR() {
		return VALOR;
	}
	public void setVALOR(double vALOR) {
		VALOR = vALOR;
	}
	public String getDATA_SAIDA() {
		return DATA_SAIDA;
	}
	public void setDATA_SAIDA(String dATA_SAIDA) {
		DATA_SAIDA = dATA_SAIDA;
	}
	
	
}
