package Jogo;

import Jogo.Herois.*;
import Jogo.Monstros.*;
import Jogo.enums.TipoDificuldade;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// classe que representa o jogo
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

    private Monstro gerarMonstroAleatorio(TipoDificuldade dificuldade) throws Exception {
        Random random = new Random();
        int escolha = random.nextInt(5);
        return switch (escolha) {
            case 0 -> new AbominacaoDaCarne(dificuldade);
            case 1 -> new CavaleiroDoVazio(dificuldade);
            case 2 -> new ColossoDePedraViva(dificuldade);
            case 3 -> new EspectroDaAgonia(dificuldade);
            case 4 -> new HidraDeSangue(dificuldade);
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

    private Monstro escolherMonstroMenorVida(List<Monstro> monstros) throws Exception {
        if (monstros.isEmpty() ){
            throw new Exception();
        }

        Monstro alvo = monstros.get(0);
        for (Monstro monstro : monstros) {
            if (monstro.getVida() < alvo.getVida()) {
                alvo = monstro;
            }
        }
        return alvo;
    }

    private Heroi escolherHeroiMenorVida(List<Heroi> herois) throws Exception {
        if (herois.isEmpty() ){
            throw new Exception();
        }

        Heroi alvo = herois.get(0);
        for (Heroi heroi : herois) {
            if (heroi.getVida() < alvo.getVida()) {
                alvo = heroi;
            }
        }
        return alvo;
    }

    private void executarTurnos() throws Exception {
        Random random = new Random();
        while (!herois.isEmpty() && !monstros.isEmpty()) {
            Heroi heroi = escolherHeroiMenorVida(herois);
            Monstro monstro = escolherMonstroMenorVida(monstros);

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
    }
}
