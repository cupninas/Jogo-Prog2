package Jogo.Monstros;

import Jogo.Herois.Heroi;
import Jogo.enums.TipoMonstro;

import java.util.Random;

public class EspectroDaAgonia extends Monstro {
    private boolean intangivelAtivo = false;

    public EspectroDaAgonia(String nome, int vida, int ataque, int defesa, int destreza, int velocidade) {
        super(nome, vida, ataque, defesa, destreza, velocidade, TipoMonstro.ESPECTRO_DA_AGONIA);
    }

    public EspectroDaAgonia() {
        super("Arqueiro", 150, 20, 10, 10, 5, TipoMonstro.ESPECTRO_DA_AGONIA);
    }

    @Override
    protected void realizarAcao(Heroi heroi) throws Exception {
        //TODO - realizar algum dos ataques de forma randomica - ivan
        Random random = new Random();
        int escolha = random.nextInt(4);
        switch (escolha) {
            case 0 -> gritoAssombrado(heroi);
            case 1 -> drenarVida(heroi);
            case 2 -> ataqueNormal(heroi);
            case 3 -> ativarIntangibilidade();
            default -> throw new Exception();
        };
    }

    @Override
    public void sofrerDano(int dano) {
        //TODO - verifica se os alguns dos atributos de "escudo" estao true, senao, tenta realizar o dano. - ivan
        //TODO - Esse metodo só é chamado por outra classe, não por essa aqui - ivan
        if (intangivelAtivo) {
            System.out.println(nome + " se tornou etéreo e evitou completamente o ataque!");
            intangivelAtivo = false;
            return;
        }
        //TODO - se nenhum dos atributos forem true, tenta executar a acao, - ivan
        this.vida -= dano;

        //sempre que comecar um turno novo, realizar os metodos de desativacao de escudo, como -> desativarIntangibilidade
    }

    @Override
    public void comecarNovoTurno() {
        desativarIntangibilidade();
    }

    /**
     *🕷️ O que a habilidade faz?
     * ✔ Paralisa o herói por 1 turno → O herói não pode agir no próximo turno.
     * ✔ Reduz a defesa do herói em 30% temporariamente → Deixa-o mais vulnerável a ataques.
     */
    private void gritoAssombrado(Heroi heroi) {
        System.out.println(this.getNome() + " solta um GRITO ASSOMBRADO!");

        // Aplica paralisia no herói por 1 turno
        heroi.setParalisado(true);
        System.out.println(heroi.getNome() + " está paralisado pelo medo!");

        // Reduz temporariamente a defesa do herói
        int reducaoDefesa = (int) (heroi.getDefesa() * 0.3); // Reduz 30% da defesa
        heroi.setDefesa(heroi.getDefesa() - reducaoDefesa);
        System.out.println(heroi.getNome() + " teve sua defesa reduzida em " + reducaoDefesa + " pontos!");

        // TODO: Criar um sistema para restaurar a defesa após um turno - ivan
    }

    /**
     *🔥 O que a habilidade faz?
     * ✔ Rouba HP do herói e adiciona ao próprio HP
     * ✔ Causa dano equivalente a um ataque normal
     * ✔ Recupera parte do dano causado
     */
    private void drenarVida(Heroi heroi) {
        System.out.println(this.getNome() + " usa DRENAR VIDA!");

        // Calcula dano baseado no ataque do espectro
        int dano = this.getAtaque();
        heroi.sofrerDano(dano);
        System.out.println(heroi.getNome() + " perdeu " + dano + " de HP!");

        // Recupera 50% do dano causado
        int cura = dano / 2;
        this.setVida(this.getVida() + cura);
        System.out.println(this.getNome() + " absorveu " + cura + " de HP!");
    }

    /**
    *🕷️ O que a habilidade faz?
    *✔ O espectro se torna intangível por 1 turno, evitando qualquer ataque físico.
    *✔ Habilidade tem chance de ativação ao sofrer dano (exemplo: 30%).
    *✔ O efeito dura apenas 1 turno e precisa ser reativado em outro momento.
    */
    private void ataqueNormal(Heroi heroi) {
        System.out.println(this.getNome() + " ataca normalmente!");
        heroi.sofrerDano(this.getAtaque());
    }

    private void ativarIntangibilidade() {
        System.out.println(this.getNome() + " se torna INTANGÍVEL! Ataques físicos não terão efeito no próximo turno.");
        this.intangivelAtivo = true;
    }

    public void desativarIntangibilidade() {
        if (intangivelAtivo) {
            System.out.println(this.getNome() + " retorna ao plano físico.");
            this.intangivelAtivo = false;
        }
    }
}
