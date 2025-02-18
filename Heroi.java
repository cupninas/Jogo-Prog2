package Jogo;

public class Heroi extends Personagem {
	private Classe classe;
	
	public Heroi(String nome, int vida, int ataque, int defesa, int destreza, int velocidade, Classe classe) {
		super(nome, vida, ataque, defesa, destreza, velocidade);
		this.classe = classe;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
}
