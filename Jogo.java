package Jogo;

import Jogo.Herois.*;
import Jogo.Monstros.*;
import Jogo.enums.TipoDificuldade;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogo {
    private List<Heroi> herois = new ArrayList<>();
    private List<Monstro> monstros = new ArrayList<>();
    private Log log = new Log();
    private TipoDificuldade dificuldade;

    public Jogo(TipoDificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }

    public void iniciarJogo() throws Exception {
        log.addLog("Jogo iniciado com dificuldade: " + dificuldade);

        gerarHeroiAleatorio();
        gerarMonstroAleatorio();
        executarTurnos();
    }

    private Monstro gerarMonstroAleatorio() throws Exception {
        Random random = new Random();
        int escolha = random.nextInt(5);
        return switch (escolha) {
            case 0 -> new AbominacaoDaCarne();
            case 1 -> new CavaleiroDoVazio();
            case 2 -> new ColossoDePedraViva();
            case 3 -> new EspectroDaAgonia();
            case 4 -> new HidraDeSangue();
            default -> throw new Exception();
        };
    }

    private Heroi gerarHeroiAleatorio() throws Exception {
        Random random = new Random();
        int escolha = random.nextInt(4);
        return switch (escolha) {
            case 0 -> new Arqueiro();
            case 1 -> new Guerreiro();
            case 2 -> new Ladino();
            case 3 -> new Mago();
            default -> throw new Exception();
        };
    }

    private void executarTurnos() {
        Random random = new Random();
        while (!herois.isEmpty() && !monstros.isEmpty()) {
            Heroi heroi = herois.get(random.nextInt(herois.size()));
            Monstro monstro = monstros.get(random.nextInt(monstros.size()));

            monstro.sofrerDano(heroi.getAtaque());
            log.addLog(heroi.getNome() + " atacou " + monstro.getNome() + " causando " + heroi.getAtaque() + " de dano.");

            if (!monstro.estaVivo()) {
                log.addLog(monstro.getNome() + " foi derrotado!");
                monstros.remove(monstro);
            }

            if (!monstros.isEmpty()) {
                heroi.sofrerDano(monstro.getAtaque());
                log.addLog(monstro.getNome() + " atacou " + heroi.getNome() + " causando " + monstro.getAtaque() + " de dano.");

                if (!heroi.estaVivo()) {
                    log.addLog(heroi.getNome() + " foi derrotado!");
                    herois.remove(heroi);
                }
            }
        }
        encerrarJogo();
    }
}
