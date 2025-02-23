package Jogo.Herois;

import Jogo.Monstros.Monstro;
import Jogo.enums.TipoArma;
import Jogo.enums.TipoHeroi;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Ladino extends Heroi {
	private int taxaEsquiva = 4;

	// Construtor principal com todos os atributos
	public Ladino(String nome, int vida, int defesa, int destreza, int velocidade) {
		super(nome, vida, defesa, destreza, velocidade, TipoHeroi.LADINO);

		List<TipoArma> armasLadino = TipoArma.obterArmasParaLadino();
		this.armaPrincipal = armasLadino.get(RANDOM.nextInt(armasLadino.size()));
		this.ataque = TipoHeroi.LADINO.getAtaque()+this.armaPrincipal.getAtaque();
	}

	// Construtor com valores padrão de um Ladino típico
	public Ladino() {
		super("Guerreiro", 300, 20, 8, 4, TipoHeroi.LADINO);

		List<TipoArma> armasLadino = TipoArma.obterArmasParaLadino();
		this.armaPrincipal = armasLadino.get(RANDOM.nextInt(armasLadino.size()));
		this.ataque = TipoHeroi.LADINO.getAtaque()+this.armaPrincipal.getAtaque();
	}

	//--------------------- Atributos escudos --------------------

	private boolean ocultoNasSombras = false; // Habilidade passiva que aumenta esquiva

	//--------------------- Factories --------------------

	@Override
	protected void realizarAcao(Monstro monstro) throws Exception {
		//a flecha carregada tem influencia aqui, quando esta ativada tem mais chance da acao acontecer
		//TODO - realizar algum dos ataques de forma randomica
		Random random = new Random();
		int escolha = random.nextInt(5);
		switch (escolha) {
			case 0 -> golpePreciso(monstro);
			case 1 -> ataqueRapido(monstro);
			case 2 -> ataqueFurtivo(monstro);
			case 3 -> ataqueBasico(monstro);
			case 4 -> ativarFurtividade();
			default -> throw new Exception();
		};
	}

	@Override
	public void sofrerDano(int dano) {}

	@Override
	public void comecarNovoTurno() { desativarFurtividade(); }

	//--------------------- Ações de ataque --------------------

	private void ataqueRapido(Monstro monstro) {
		System.out.println(getNome() + " realiza um ataque rápido com " + armaPrincipal.getNome() + "!");
		int danoFinal = (int) (this.getAtaque() * 1.2) - monstro.getDefesa();
		if (Math.random() < 0.4) { // 40% de chance de acerto crítico
			danoFinal *= 2;
			System.out.println("GOLPE CRÍTICO!");
		}
		monstro.sofrerDano(Math.max(danoFinal, 0));
	}

	private void golpePreciso(Monstro monstro) {
		System.out.println(getNome() + " desfere um golpe preciso com sua " + armaPrincipal.getNome() + "!");
		int danoFinal = this.getAtaque() - (monstro.getDefesa() / 2);
		monstro.sofrerDano(Math.max(danoFinal, 0));
	}

	private void ataqueFurtivo(Monstro monstro) {
		System.out.println(getNome() + " ataca das sombras com sua " + armaPrincipal.getNome() + "!");
		int danoFinal = this.getAtaque() + 10; // Dano extra quando oculto
		if (ocultoNasSombras) {
			danoFinal += 15;
			System.out.println("Ataque surpresa! Dano extra aplicado.");
		}
		monstro.sofrerDano(Math.max(danoFinal, 0));
		ocultoNasSombras = false; // Revela-se após o ataque
	}

	private void ataqueBasico(Monstro monstro) {
		System.out.println(getNome() + " ataca com sua " + armaPrincipal.getNome() + "!");
		int danoFinal = this.getAtaque() - monstro.getDefesa();
		monstro.sofrerDano(Math.max(danoFinal, 0));
	}

	//--------------------- Ações de defesa --------------------

	public void ativarFurtividade() {
		this.ocultoNasSombras = true;
		System.out.println(getNome() + " se escondeu nas sombras!");
	}

	//--------------------- Desativações de escudo --------------------

	public void desativarFurtividade() {
		this.ocultoNasSombras = false;
		System.out.println(getNome() + " foi revelado e saiu das sombras!");
	}
}