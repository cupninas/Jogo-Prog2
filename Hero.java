package Jogo;
import java.util.Random;

public class Hero extends Character {
	Random r = new Random();
	private String classe;
	
	public Hero(String nome, int vida, int ataque, int defesa, int destreza, int velocidade, String classe) {
		super(nome, vida, ataque, defesa, destreza, velocidade);
		this.classe = classe;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	public void realizarAtaque() {
		 
	 }
}
