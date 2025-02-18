package Jogo;

public abstract class Classe {
	protected String nome;
	protected String arma;
	protected String tipoDano;
	protected String habilidade;
	
	public Classe(String nome, String arma, String tipoDano, String habilidade) {
		this.nome = nome;
		this.arma = arma;
		this.tipoDano = tipoDano;
		this.habilidade = habilidade;
	}
}
