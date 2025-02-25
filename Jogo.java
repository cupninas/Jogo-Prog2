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
    public static Log log = new Log();
    private TipoDificuldade dificuldade;
    private static Random random = new Random();

    public Jogo(TipoDificuldade dificuldade, int quantidadeHerois, int quantidadeMonstros) throws Exception {
        this.dificuldade = dificuldade;
        this.herois = new ArrayList<>();
        this.monstros = new ArrayList<>();
        // Gerar múltiplos heróis usando o método gerarHeroiAleatorio()
        for (int i = 0; i < quantidadeHerois; i++) this.herois.add(gerarHeroiAleatorio());
        // Gerar múltiplos monstros usando o método gerarMonstroAleatorio()
        for (int i = 0; i < quantidadeMonstros; i++) this.monstros.add(gerarMonstroAleatorio(dificuldade));
    }

    public void iniciarJogo(int quantidadeHerois, int quantidadeMonstros) throws Exception {
        log.addLog("Jogo iniciado com dificuldade: " + dificuldade);
        executarTurnos();
    }

    private Monstro gerarMonstroAleatorio(TipoDificuldade dificuldade) throws Exception {
        int escolha = random.nextInt(5);
        int vida = random.nextInt(500)+100;
        int ataque = random.nextInt(50)+5;
        int defesa = random.nextInt(50)+5;
        int destreza = random.nextInt(50)+5;
        int velocidade = random.nextInt(50)+5;
        return switch (escolha) {
            case 0 -> new AbominacaoDaCarne(vida, ataque, defesa, destreza, velocidade, dificuldade);
            case 1 -> new CavaleiroDoVazio(vida, ataque, defesa, destreza, velocidade, dificuldade);
            case 2 -> new ColossoDePedraViva(vida, ataque, defesa, destreza, velocidade, dificuldade);
            case 3 -> new EspectroDaAgonia(vida, ataque, defesa, destreza, velocidade, dificuldade);
            case 4 -> new HidraDeSangue(vida, ataque, defesa, destreza, velocidade, dificuldade);
            default -> throw new Exception();
        };
    }

    private static Heroi gerarHeroiAleatorio() throws Exception {
        int escolha = random.nextInt(4);
        int vida = random.nextInt(500)+100;
        int defesa = random.nextInt(50)+5;
        int destreza = random.nextInt(50)+5;
        int velocidade = random.nextInt(50)+5;
        return switch (escolha) {
            case 0 -> new Arqueiro(vida, defesa, destreza, velocidade);
            case 1 -> new Guerreiro(vida, defesa, destreza, velocidade);
            case 2 -> new Ladino(vida, defesa, destreza, velocidade);
            case 3 -> new Mago(vida, defesa, destreza, velocidade);
            default -> throw new Exception();
        };
    }

    private Monstro escolherMonstroMenorVida(List<Monstro> monstros) throws Exception {
        if (monstros.isEmpty()) throw new Exception();

        Monstro alvo = monstros.get(0);
        for (Monstro monstro : monstros) if (monstro.getVida() < alvo.getVida()) alvo = monstro;
        return alvo;
    }

    private Heroi escolherHeroiMenorVida(List<Heroi> herois) throws Exception {
        if (herois.isEmpty()) throw new Exception();

        Heroi alvo = herois.get(0);
        for (Heroi heroi : herois) if (heroi.getVida() < alvo.getVida()) alvo = heroi;
        return alvo;
    }

    private void executarTurnos() throws Exception {
        while (!herois.isEmpty() && !monstros.isEmpty()) {
            Heroi heroi = escolherHeroiMenorVida(herois);
            Monstro monstro = escolherMonstroMenorVida(monstros);

            monstro.sofrerDano(heroi.getAtaque());
            //log.addLog(heroi.getNome() + " atacou " + monstro.getNome() + " causando " + heroi.getAtaque() + " de dano.");

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
