package Jogo.Herois;

import Jogo.Monstros.Monstro;
import Jogo.enums.TipoArma;
import Jogo.enums.TipoHeroi;

import java.util.List;

import static Jogo.Jogo.log;

public class Guerreiro extends Heroi {

    // Construtor principal com todos os atributos
    public Guerreiro(int vida, int defesa, int destreza, int velocidade) {
        super("Guerreiro", vida, defesa, destreza, velocidade, TipoHeroi.GUERREIRO);

        List<TipoArma> armasGuerreiro = TipoArma.obterArmasParaGuerreiro();
        this.armaPrincipal = armasGuerreiro.get(RANDOM.nextInt(armasGuerreiro.size()));
        this.ataque = TipoHeroi.GUERREIRO.getAtaque()+this.armaPrincipal.getAtaque();
    }

    // Construtor com valores padrão de um Guerreiro típico
    public Guerreiro() {
        super("Guerreiro", 300, 20, 8, 4, TipoHeroi.GUERREIRO);

        List<TipoArma> armasGuerreiro = TipoArma.obterArmasParaGuerreiro();
        this.armaPrincipal = armasGuerreiro.get(RANDOM.nextInt(armasGuerreiro.size()));
        this.ataque = TipoHeroi.GUERREIRO.getAtaque()+this.armaPrincipal.getAtaque();
    }

    //--------------------- Atributos escudos --------------------

    private boolean furiaAtiva = false; // Ativado após sofrer dano crítico

    //--------------------- Factories --------------------

    @Override
    public void realizarAcao(Monstro monstro) throws Exception {
        double chanceDeAcerto = Math.min(0.5 + (this.getDestreza() * 0.05), 1.0); // Base 50% + 5% por ponto de destreza, máx 100%

        if (Math.random() > chanceDeAcerto) {
            log.addLog(this.getNome() + " errou sua ação!");
            return;
        }
        int escolha = RANDOM.nextInt(6);
        switch (escolha) {
            case 0 -> ativarFuria();
            case 1 -> golpeDemolidor(monstro);
            case 2 -> ataquePesado(monstro);
            case 3 -> ataqueComAlcance(monstro);
            case 4 -> ataqueComAtordoamento(monstro);
            case 5 -> ataqueRapido(monstro);
            default -> throw new Exception();
        };

    }

    @Override
    public void sofrerDano(int dano) {
        if (furiaAtiva) {
            log.addLog(this.getNome() + " está em fúria e desvia de todos os golpes.");
            desativarFuria();
        } else {
            this.vida -= dano;
            log.addLog(this.getNome() + " sofreu " + dano + " de dano!");
        }
    }

    //--------------------- Ações de ataque --------------------

    private void golpeDemolidor(Monstro monstro) {
        log.addLog(this.getNome() + " desfere um GOLPE DEMOLIDOR com sua " + armaPrincipal.getNome() + "!");

        int danoBase = this.getAtaque();
        int defesaIgnorada = (int) (monstro.getDefesa() * 0.2);
        int danoFinal = (danoBase + (danoBase / 2)) - defesaIgnorada;

        if (danoFinal < 0) danoFinal = 0;
        monstro.sofrerDano(danoFinal);

        log.addLog(monstro.getNome() + " recebeu " + danoFinal + " de dano!");
    }

    private void ataquePesado(Monstro monstro) {
        log.addLog(this.getNome() + " balança seu " + armaPrincipal.getNome() + " com força total!");
        int danoFinal = this.getAtaque() * 2 - monstro.getDefesa();

        if (danoFinal < 0) danoFinal = 0;
        monstro.sofrerDano(danoFinal);

        log.addLog(monstro.getNome() + " sofreu um golpe brutal de " + danoFinal + " de dano!");
    }

    private void ataqueComAlcance(Monstro monstro) {
        log.addLog(this.getNome() + " ataca de longe com sua " + armaPrincipal.getNome() + ", mantendo distância!");
        int danoFinal = this.getAtaque() - (monstro.getDefesa() / 2);

        if (danoFinal < 0) danoFinal = 0;
        monstro.sofrerDano(danoFinal);

        log.addLog(monstro.getNome() + " recebeu " + danoFinal + " de dano!");
    }

    private void ataqueComAtordoamento(Monstro monstro) {
        log.addLog(this.getNome() + " golpeia com sua " + armaPrincipal.getNome() + " e tenta atordoar o inimigo!");
        int danoFinal = this.getAtaque() - monstro.getDefesa();
        if (Math.random() < 0.3) { // 30% de chance de atordoamento
            log.addLog(monstro.getNome() + " foi ATORDOADO!");
        }

        if (danoFinal < 0) danoFinal = 0;
        monstro.sofrerDano(danoFinal);
    }

    private void ataqueRapido(Monstro monstro) {
        log.addLog(this.getNome() + " corta rapidamente com sua " + armaPrincipal.getNome() + "!");
        int danoFinal = (int) (this.getAtaque() * 1.2) - monstro.getDefesa();
        if (Math.random() < 0.4) { // 40% de chance de crítico
            danoFinal *= 2;
            log.addLog("GOLPE CRÍTICO!");
        }

        if (danoFinal < 0) danoFinal = 0;
        monstro.sofrerDano(danoFinal);
    }

    //--------------------- Ações de defesa --------------------

    private void ativarFuria() {
        if (!furiaAtiva) {
            furiaAtiva = true;
            this.ataque += 10; // Aumenta o ataque enquanto a fúria está ativa
            this.defesa -= 5; // Reduz um pouco a defesa em troca do poder bruto
            log.addLog(this.getNome() + " entra em um estado de FÚRIA! Seu ataque aumenta, mas sua defesa é reduzida.");
        } else {
            log.addLog(this.getNome() + " já está em fúria!");
        }
    }

    //--------------------- Desativações de escudo --------------------

    private void desativarFuria() {
        furiaAtiva = false;
        this.ataque -= 10; // Retorna o ataque ao normal
        this.defesa += 5; // Recupera a defesa perdida
        log.addLog(this.getNome() + " se acalma e sai do estado de FÚRIA.");
    }

}