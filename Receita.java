package br.com.fabricioMrtn.challenge.model;

public class Receita {
	private int ID;
	private String DESCRICAO;
	private double VALOR;
	private String DATA_ENTRADA;
	
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
	public String getDATA_ENTRADA() {
		return DATA_ENTRADA;
	}
	public void setDATA_ENTRADA(String dATA_ENTRADA) {
		DATA_ENTRADA = dATA_ENTRADA;
	}
	
	
}
