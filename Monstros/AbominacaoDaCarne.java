package Jogo.Monstros;

import Jogo.Herois.*;
import Jogo.enums.TipoDificuldade;
import Jogo.enums.TipoMonstro;


import static Jogo.Jogo.log;
import static Jogo.enums.ResultadoAtaque.ACERTOU;
import static Jogo.enums.ResultadoAtaque.ERROU;

public class AbominacaoDaCarne extends Monstro {

    private int vidaMaxima;

    public AbominacaoDaCarne(int vida, int ataque, int defesa, int destreza, int velocidade, TipoDificuldade dificuldade) {
        super("Abominação da Carne",
                vida*dificuldade.getDificuldade(),
                ataque*dificuldade.getDificuldade(),
                defesa*dificuldade.getDificuldade(),
                destreza*dificuldade.getDificuldade(),
                velocidade*dificuldade.getDificuldade(),
                TipoMonstro.ABOMINACAO_DA_CARNE
        );
        this.vidaMaxima = vida;
    }

    public AbominacaoDaCarne(TipoDificuldade dificuldade) {
        super("Abominação da Carne",
                300*dificuldade.getDificuldade(),
                35*dificuldade.getDificuldade(),
                20*dificuldade.getDificuldade(),
                5*dificuldade.getDificuldade(),
                2*dificuldade.getDificuldade(),
                TipoMonstro.ABOMINACAO_DA_CARNE
        );
    }

    //--------------------- Atributos escudos --------------------

    private boolean corpoRemendado; // Se ativado, reduz dano recebido

    //--------------------- Factories --------------------

    @Override
    public void realizarAcao(Heroi heroi) throws Exception {
        double chanceDeAcerto = Math.min(0.5 + (this.getDestreza() * 0.05), 1.0); // Base 50% + 5% por ponto de destreza, máx 100%

        if (Math.random() > chanceDeAcerto) {
            log.addLog(ERROU.toString()+": "+this.getNome() + " errou sua ação!");
            return;
        }

        log.addLog(ACERTOU.toString()+": "+this.getNome() + " atacou " + heroi.getNome() + ".");

        int escolha = RANDOM.nextInt(4);
        switch (escolha) {
            case 0 -> esmagar(heroi);
            case 1 -> regeneracaoProfana();
            case 2 -> ataqueNormal(heroi);
            case 3 -> ativarCorpoRemendado();
            default -> throw new Exception();
        };
    }

    @Override
    public void sofrerDano(int dano) {
        if (corpoRemendado) {
            log.addLog(getNome() + " usa seu CORPO REMENDADO para reduzir o impacto do golpe!");
            dano = (int) (dano * 0.7);
            desativarCorpoRemendado();
        }
        if (dano < 0) dano = 0;
        this.vida -= dano;
        log.addLog(getNome() + " sofreu " + dano + " de dano!");
    }

    //--------------------- Ações de ataque --------------------

    private void esmagar(Heroi heroi) {
        log.addLog(this.getNome() + " usa ESMAGAR!");

        // Causa 50% mais dano e ignora 30% da defesa do herói
        int danoBase = this.getAtaque();
        int defesaIgnorada = (int) (heroi.getDefesa() * 0.3);
        int danoFinal = (danoBase + (danoBase / 2)) - defesaIgnorada;

        if (danoFinal < 0) danoFinal = 0; // Evita dano negativo
        heroi.sofrerDano(danoFinal);

        log.addLog(heroi.getNome() + " recebeu " + danoFinal + " de dano!");
    }

    private void regeneracaoProfana() {
        int cura = (int) (this.vidaMaxima * 0.1); // Recupera 10% da vida máxima
        this.setVida(this.getVida() + cura);

        log.addLog(this.getNome() + " ativa REGENERAÇÃO PROFANA e recupera " + cura + " de HP!");
    }

    private void ataqueNormal(Heroi heroi) {
        log.addLog(this.getNome() + " ataca com um soco brutal!");
        heroi.sofrerDano(this.getAtaque());
    }

    //--------------------- Ações de defesa --------------------

    public void ativarCorpoRemendado() {
        if (!corpoRemendado) {
            corpoRemendado = true;
            this.defesa += 10; // Aumenta a defesa enquanto estiver ativo
            log.addLog(this.getNome() + " costura sua carne retorcida e fortalece sua defesa!");
        } else {
            log.addLog(this.getNome() + " já está com o Corpo Remendado ativo!");
        }
    }

    //--------------------- Desativações de escudo --------------------

    public void desativarCorpoRemendado() {
        corpoRemendado = false;
        this.defesa -= 10; // Retorna a defesa ao normal
        log.addLog(this.getNome() + " começa a se decompor novamente... Corpo Remendado foi desativado!");
    }

}
