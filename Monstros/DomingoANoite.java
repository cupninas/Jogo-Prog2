package Jogo.Monstros;

import Jogo.Herois.Heroi;

public class DomingoANoite extends Monstro{
    public DomingoANoite() {
        super("Domingo à noite", 300, 40, 20, 10, 5);
    }

    @Override
    public void sofrerDano() {

    }

    public void ansiedadeDaSegunda(Heroi alvo) {
        int danoExtra = 20;
        System.out.println(getNome() + " causou um ataque de ansiedade em " + alvo.getNome() + ", reduzindo sua defesa e causando " + danoExtra + " de dano extra!");
        alvo.sofrerDano(danoExtra);
    }

    public void procrastinacaoForcada(Heroi alvo) {
        System.out.println(getNome() + " fez " + alvo.getNome() + " perder um turno devido à procrastinação!");
    }

    public void pensamentosIntrusivos(Heroi alvo) {
        System.out.println(getNome() + " encheu a mente de " + alvo.getNome() + " com pensamentos intrusivos, reduzindo sua precisão no próximo ataque!");
    }
}
