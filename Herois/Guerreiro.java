package Jogo.Herois;

import Jogo.Monstros.Monstro;
import Jogo.enums.TipoArma;
import Jogo.enums.TipoHeroi;

import java.util.List;

public class Guerreiro extends Heroi {

    // Construtor principal com todos os atributos
    public Guerreiro(String nome, int vida, int defesa, int destreza, int velocidade) {
        super(nome, vida, defesa, destreza, velocidade, TipoHeroi.GUERREIRO);

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
    protected void realizarAcao(Monstro monstro) throws Exception {
        // TODO - colocar uma tentativa de realizar acao.
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
        //TODO - Esse metodo só é chamado por outra classe, não por essa aqui.
        // Aqui nao tem esses atributos escudos, nao precisa fazer a verificacao.
        // se nenhum dos atributos forem true, tenta executar a acao,
        this.vida -= dano;
    }

    @Override
    public void comecarNovoTurno() { desativarFuria(); }

    //--------------------- Ações de ataque --------------------

    private void golpeDemolidor(Monstro monstro) {
        System.out.println(this.getNome() + " desfere um GOLPE DEMOLIDOR com sua " + armaPrincipal.getNome() + "!");

        int danoBase = this.getAtaque();
        int defesaIgnorada = (int) (monstro.getDefesa() * 0.2);
        int danoFinal = (danoBase + (danoBase / 2)) - defesaIgnorada;

        if (danoFinal < 0) danoFinal = 0;
        monstro.sofrerDano(danoFinal);

        System.out.println(monstro.getNome() + " recebeu " + danoFinal + " de dano!");
    }

    private void ataquePesado(Monstro monstro) {
        System.out.println(this.getNome() + " balança seu " + armaPrincipal.getNome() + " com força total!");
        int danoFinal = this.getAtaque() * 2 - monstro.getDefesa();

        if (danoFinal < 0) danoFinal = 0;
        monstro.sofrerDano(danoFinal);

        System.out.println(monstro.getNome() + " sofreu um golpe brutal de " + danoFinal + " de dano!");
    }

    private void ataqueComAlcance(Monstro monstro) {
        System.out.println(this.getNome() + " ataca de longe com sua " + armaPrincipal.getNome() + ", mantendo distância!");
        int danoFinal = this.getAtaque() - (monstro.getDefesa() / 2);

        if (danoFinal < 0) danoFinal = 0;
        monstro.sofrerDano(danoFinal);

        System.out.println(monstro.getNome() + " recebeu " + danoFinal + " de dano!");
    }

    private void ataqueComAtordoamento(Monstro monstro) {
        System.out.println(this.getNome() + " golpeia com sua " + armaPrincipal.getNome() + " e tenta atordoar o inimigo!");
        int danoFinal = this.getAtaque() - monstro.getDefesa();
        if (Math.random() < 0.3) { // 30% de chance de atordoamento
            System.out.println(monstro.getNome() + " foi ATORDOADO!");
        }

        if (danoFinal < 0) danoFinal = 0;
        monstro.sofrerDano(danoFinal);
    }

    private void ataqueRapido(Monstro monstro) {
        System.out.println(this.getNome() + " corta rapidamente com sua " + armaPrincipal.getNome() + "!");
        int danoFinal = (int) (this.getAtaque() * 1.2) - monstro.getDefesa();
        if (Math.random() < 0.4) { // 40% de chance de crítico
            danoFinal *= 2;
            System.out.println("GOLPE CRÍTICO!");
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
            System.out.println(this.getNome() + " entra em um estado de FÚRIA! Seu ataque aumenta, mas sua defesa é reduzida.");
        } else {
            System.out.println(this.getNome() + " já está em fúria!");
        }
    }

    //--------------------- Desativações de escudo --------------------

    private void desativarFuria() {
        if (furiaAtiva) {
            furiaAtiva = false;
            this.ataque -= 10; // Retorna o ataque ao normal
            this.defesa += 5; // Recupera a defesa perdida
            System.out.println(this.getNome() + " se acalma e sai do estado de FÚRIA.");
        } else {
            System.out.println(this.getNome() + " não está em fúria no momento.");
        }
    }

}