package Jogo.Monstros;

import Jogo.Herois.Heroi;

public class DomingoANoite extends Monstro{
    public DomingoANoite() {
        super("Domingo à noite", 300, 40, 20, 10, 5);
    }

    @Override
    protected void realizarAcao(Heroi heroi) {
        //TODO - realizar algum dos ataques de forma randomica
    }

    @Override
    public void sofrerDano() {

    }

    private void ansiedadeDaSegunda(Heroi alvo) {
        int danoExtra = 20;
        System.out.println(getNome() + " causou um ataque de ansiedade em " + alvo.getNome() + ", reduzindo sua defesa e causando " + danoExtra + " de dano extra!");
        alvo.sofrerDano(danoExtra);
    }

    private void procrastinacaoForcada(Heroi alvo) {
        System.out.println(getNome() + " fez " + alvo.getNome() + " perder um turno devido à procrastinação!");
    }

    private void pensamentosIntrusivos(Heroi alvo) {
        System.out.println(getNome() + " encheu a mente de " + alvo.getNome() + " com pensamentos intrusivos, reduzindo sua precisão no próximo ataque!");
    }
}
