package Jogo.Monstros;

import Jogo.Herois.Heroi;

public class LeaoReceitaFederal extends Monstro {

    protected boolean isencaoAtiva = false;
    protected boolean blindagemAtiva = false;

    public LeaoReceitaFederal() {
        super("Leão da Receita Federal", 200, 40, 20, 50, 20);
    }

    @Override
    protected void realizarAcao(Heroi heroi) {
        //TODO - realizar algum dos ataques de forma randomica
    }

    @Override
    public void sofrerDano(){
        //TODO - Esse metodo só é chamada por outra classe, não por essa aqui
        if (isencaoAtiva) {
            System.out.println(nome + " evitou completamente o dano com Isenção Temporária!");
            isencaoAtiva = false;
            return;
        } else if (blindagemAtiva) {
            ataque /= 2;
            System.out.println(nome + " reduziu o dano pela metade com Blindagem Burocrática!");
            blindagemAtiva = false;
        }
        //TODO - se nenhum dos atributos forem true, tenta executar a acao,
        this.vida -= ataque;
    }

    private void cobrarImposto(Heroi alvo) {
        alvo.sofrerDano(ataque);
        System.out.println(getNome() + " fiscalizou " + alvo.getNome() + " e aplicou uma taxa, causando " + ataque + " de dano adicional!");
    }

    private void auditoriaSevera(Heroi alvo, int danoExtra) {
        System.out.println(getNome() + " conduziu uma auditoria em " + alvo.getNome() + " e detectou irregularidades, causando " + ataque+danoExtra + " de dano crítico!");
    }

    private void confiscarBens(Heroi alvo, int reducaoAtaque) {
        System.out.println(getNome() + " confiscou os bens de " + alvo.getNome() + ", reduzindo seu ataque em " + reducaoAtaque + "!");
        alvo.setAtaque(Math.max(0, alvo.getAtaque() - reducaoAtaque));
    }

    private void isencaoTemporaria() {
        isencaoAtiva = true;
        System.out.println(getNome() + " concedeu uma isenção temporária, reduzindo o dano recebido no próximo turno!");
    }

    private void blindagemBurocratica() {
        blindagemAtiva = true;
        System.out.println(getNome() + " ativou a blindagem burocrática, reduzindo o dano recebido pela metade neste turno!");
    }

}
