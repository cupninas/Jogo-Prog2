package Jogo;

public class Classe {
	private String nome;
	private String arma;
	private String tipoDano;
	private String habilidade;
	
	public Classe(String nome, String arma, String tipoDano, String habilidade) {
		this.nome = nome;
		this.arma = arma;
		this.tipoDano = tipoDano;
		this.habilidade = habilidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}

	public String getTipoDano() {
		return tipoDano;
	}

	public void setTipoDano(String tipoDano) {
		this.tipoDano = tipoDano;
	}

	public String getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}
	
}
