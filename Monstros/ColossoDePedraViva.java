package Jogo.Monstros;

import Jogo.Herois.Heroi;
import Jogo.Log;
import Jogo.enums.TipoDificuldade;
import Jogo.enums.TipoMonstro;

import java.util.Random;

import static Jogo.Jogo.log;

public class ColossoDePedraViva extends Monstro{
    private int vidaMaxima;

    public ColossoDePedraViva(int vida, int ataque, int defesa, int destreza, int velocidade, TipoDificuldade dificuldade) {
        super("Colosso de Pedra Viva",
                vida*dificuldade.getDificuldade(),
                ataque*dificuldade.getDificuldade(),
                defesa*dificuldade.getDificuldade(),
                destreza*dificuldade.getDificuldade(),
                velocidade*dificuldade.getDificuldade(),
                TipoMonstro.COLOSSO_DE_PEDRA_VIVA);
        vidaMaxima = vida*dificuldade.getDificuldade();
    }

    public ColossoDePedraViva(TipoDificuldade dificuldade) {
        super("Colosso de Pedra Viva",
                400*dificuldade.getDificuldade(),
                40*dificuldade.getDificuldade(),
                35*dificuldade.getDificuldade(),
                5*dificuldade.getDificuldade(),
                3*dificuldade.getDificuldade(),
                TipoMonstro.COLOSSO_DE_PEDRA_VIVA);
        vidaMaxima = 400*dificuldade.getDificuldade();
    }

    //--------------------- Atributos escudos --------------------

    private boolean modoDefensivo = false; // Habilidade para aumentar defesa
    private boolean enraizado = false;

    //--------------------- Factories --------------------

    @Override
    public void realizarAcao(Heroi heroi) throws Exception {
        double chanceDeAcerto = Math.min(0.5 + (this.getDestreza() * 0.05), 1.0); // Base 50% + 5% por ponto de destreza, máx 100%

        if (Math.random() > chanceDeAcerto) {
            log.addLog(this.getNome() + " errou sua ação!");
            return;
        }
        int escolha = RANDOM.nextInt(4);
        switch (escolha) {
            case 0 -> esmagamento(heroi);
            case 1 -> ativarModoDefensivo();
            case 2 -> arremessarPedra(heroi);
            case 3 -> enraizar();
            default -> throw new Exception();
        };
    }

    @Override
    public void sofrerDano(int dano) {
        // Se o Colosso estiver enraizado, ele recebe apenas 50% do dano
        if (enraizado) {
            log.addLog(getNome() + " está ENRAIZADO no solo! O dano é reduzido pela metade.");
            dano /= 2;
            desenraizar();
        }
        // Se o modo defensivo estiver ativado, ele reduz ainda mais o dano recebido
        if (modoDefensivo) {
            log.addLog(getNome() + " está em MODO DEFENSIVO! O impacto do ataque é minimizado.");
            dano -= (int) (dano * 0.4); // Reduz 40% do dano recebido
            desativarModoDefensivo();
        }

        // Aplicar o dano reduzido à vida
        this.vida -= dano;
        log.addLog(getNome() + " sofreu " + dano + " de dano!");

        // Se a vida chegar a um nível crítico, o Colosso se fortalece
        if (this.vida > 0 && this.vida <= (vidaMaxima * 0.25)) {
            log.addLog(getNome() + " está enfraquecido, mas se funde ao solo para resistir ainda mais!");
            enraizado = true; // Ele automaticamente se enraíza quando está em perigo
        }
    }

    //--------------------- Ações de ataque --------------------

    private void esmagamento(Heroi heroi) {
        log.addLog(this.getNome() + " desfere um golpe esmagador contra " + heroi.getNome() + "!");

        int danoBase = this.getAtaque() + 10;
        if (Math.random() < 0.2) {
            danoBase *= 2;
            log.addLog("GOLPE CRÍTICO! O golpe do Colosso causa destruição massiva!");
        }

        int danoFinal = danoBase - heroi.getDefesa();
        if (danoFinal < 0) danoFinal = 0;

        heroi.sofrerDano(danoFinal);
        log.addLog(heroi.getNome() + " recebeu " + danoFinal + " de dano!");
    }

    private void arremessarPedra(Heroi heroi) {
        log.addLog(this.getNome() + " arranca uma grande pedra do solo e a arremessa!");

        int danoBase = this.getAtaque() + 10;
        if (Math.random() < 0.25) {
            log.addLog("A pedra atinge a cabeça de " + heroi.getNome() + ", causando um atordoamento!");
            // Implementação futura para atordoar o herói
        }

        int danoFinal = danoBase - heroi.getDefesa();
        if (danoFinal < 0) danoFinal = 0;

        heroi.sofrerDano(danoFinal);
        log.addLog(heroi.getNome() + " recebeu " + danoFinal + " de dano!");
    }

    //--------------------- Ações de defesa --------------------

    private void ativarModoDefensivo() {
        log.addLog(this.getNome() + " fortalece sua estrutura rochosa, aumentando a defesa temporariamente!");
        modoDefensivo = true;
    }

    public void enraizar() {
        log.addLog(this.getNome() + " finca seus pés no solo, tornando-se imóvel, mas extremamente resistente!");
        enraizado = true;
        this.setDefesa(this.getDefesa() + 20);
    }

    //--------------------- Desativações de escudo --------------------

    private void desenraizar() {
        log.addLog(this.getNome() + " se liberta do solo e volta a se mover.");
        enraizado = false;
        this.setDefesa(this.getDefesa() - 20);
    }

    private void desativarModoDefensivo() {
        log.addLog(this.getNome() + " retorna ao modo normal.");
        modoDefensivo = false;
    }
}
