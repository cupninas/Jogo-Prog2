package Jogo.Monstros;

import Jogo.Herois.Heroi;
import Jogo.Log;
import Jogo.enums.TipoDificuldade;
import Jogo.enums.TipoMonstro;

import java.util.Random;

import static Jogo.Jogo.log;
import static Jogo.enums.ResultadoAtaque.ACERTOU;
import static Jogo.enums.ResultadoAtaque.ERROU;

public class HidraDeSangue extends Monstro{
    private int vidaMaxima;

    public HidraDeSangue(int vida, int ataque, int defesa, int destreza, int velocidade, TipoDificuldade dificuldade) {
        super("Hidra de Sangue",
                vida*dificuldade.getDificuldade(),
                ataque*dificuldade.getDificuldade(),
                defesa*dificuldade.getDificuldade(),
                destreza*dificuldade.getDificuldade(),
                velocidade*dificuldade.getDificuldade(),
                TipoMonstro.HIDRA_DE_SANGUE);
        this.vidaMaxima = vida*dificuldade.getDificuldade();
    }

    public HidraDeSangue(TipoDificuldade dificuldade) {
        super("Hidra de Sangue",
                250*dificuldade.getDificuldade(),
                25*dificuldade.getDificuldade(),
                15*dificuldade.getDificuldade(),
                10*dificuldade.getDificuldade(),
                7*dificuldade.getDificuldade(),
                TipoMonstro.HIDRA_DE_SANGUE);
        this.vidaMaxima = 250*dificuldade.getDificuldade();
    }

    //--------------------- Atributos escudos --------------------

    private boolean cabecasCortadasCrescendo;

    //--------------------- Factories --------------------

    @Override
    public void realizarAcao(Heroi heroi) throws Exception {
        double chanceDeAcerto = Math.min(0.5 + (this.getDestreza() * 0.05), 1.0); // Base 50% + 5% por ponto de destreza, máx 100%

        if (Math.random() > chanceDeAcerto) {
            log.addLog(ERROU.toString()+": "+this.getNome() + " errou sua ação!");
            return;
        }

        log.addLog(ACERTOU.toString()+": "+this.getNome() + " atacou " + heroi.getNome() + ".");

        int escolha = RANDOM.nextInt(5);
        switch (escolha) {
            case 0 -> morderMultiplo(heroi);
            case 1 -> regeneracaoSanguinea();
            case 2 -> cabecasRenascidas();
            case 3 -> ataqueNormal(heroi);
            case 4 -> ativarRegeneracaoDeCabecas();
            default -> throw new Exception();
        };
    }

    @Override
    public void sofrerDano(int dano) {
        // Se a Hidra estiver com cabeças novas crescendo e recuperar a vida, desativa o efeito
        if (cabecasCortadasCrescendo && this.vida > (vidaMaxima * 0.5)) {
            log.addLog(getNome() + " se fortaleceu! As novas cabeças já cresceram completamente. O ataque foi ineficiente!");
            concluirRegeneracaoDeCabecas();
        } else {
            this.vida -= dano;
            log.addLog(getNome() + " sofreu " + dano + " de dano!");
        }
        this.vida -= dano;
    }

    //--------------------- Ações de ataque --------------------

    private void morderMultiplo(Heroi heroi) {
        log.addLog(this.getNome() + " ataca com suas múltiplas cabeças!");

        Random random = new Random();
        int numeroMordidas = random.nextInt(3) + 2; // Entre 2 e 4 mordidas

        for (int i = 0; i < numeroMordidas; i++) {
            int dano = this.getAtaque() / 2; // Cada mordida causa metade do ataque normal
            heroi.sofrerDano(dano);
            log.addLog("Mordida #" + (i + 1) + ": " + heroi.getNome() + " recebeu " + dano + " de dano!");
        }
    }

    private void ataqueNormal(Heroi heroi) {
        log.addLog(this.getNome() + " lança uma investida feroz!");
        heroi.sofrerDano(this.getAtaque());
    }

    //--------------------- Ações de defesa --------------------

    private void regeneracaoSanguinea() {
        int cura = (int) (this.vidaMaxima * 0.08); // Cura 8% da vida máxima
        this.setVida(this.getVida() + cura);

        log.addLog(this.getNome() + " ativa REGENERAÇÃO SANGUÍNEA e recupera " + cura + " de HP!");
    }

    private void cabecasRenascidas() {
        log.addLog(this.getNome() + " ruge enquanto novas cabeças surgem, restaurando parte de seu poder!");

        int cura = (int) (this.vidaMaxima * 0.4); // Recupera 40% da vida máxima
        this.setVida(this.getVida() + cura);
        log.addLog(this.getNome() + " regenerou " + cura + " de HP!");

        // Poderia ganhar um buff temporário, como aumento de ataque ou defesa
    }

    public void ativarRegeneracaoDeCabecas() {
        if (!cabecasCortadasCrescendo) {
            cabecasCortadasCrescendo = true;
            log.addLog(this.getNome() + " começa a regenerar suas cabeças cortadas... Em breve ela estará ainda mais poderosa!");
        } else {
            log.addLog(this.getNome() + " já está regenerando suas cabeças!");
        }
    }

    //--------------------- Desativações de escudo --------------------

    public void concluirRegeneracaoDeCabecas() {
        cabecasCortadasCrescendo = false;
        this.ataque += 5; // Com mais cabeças, o ataque aumenta
        log.addLog(this.getNome() + " regenerou suas cabeças cortadas! Agora ficou ainda mais feroz!");
    }

}
