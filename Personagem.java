package Jogo;

import java.util.Random;

public abstract class Personagem {

	protected static final Random RANDOM = new Random();

	protected String nome;
	protected int vida;
	protected int ataque;
	protected int defesa;
	protected int destreza;
	protected int velocidade;

	public Personagem(String nome, int vida, int ataque, int defesa, int destreza, int velocidade) {
		this.nome = nome;
		this.vida = vida;
		this.ataque = ataque;
		this.defesa = defesa;
		this.destreza = destreza;
		this.velocidade = velocidade;
	}
	public abstract void sofrerDano(int dano);

	public boolean estaVivo() {
		return this.vida > 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
}
