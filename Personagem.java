package Jogo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Personagem {
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

	protected abstract void realizarAtaque();
	public void sofrerDano(int dano) {
		this.vida -= dano;
	}
	public boolean estaVivo() {
		return this.vida > 0;
	}
}
