package Jogo;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
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
	public void sofrerDano(int dano) {
		this.vida -= dano;
	}
	public boolean estaVivo() {
		return this.vida > 0;
	}
	public abstract void comecarNovoTurno();
}
