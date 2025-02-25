package Jogo.Monstros;

import Jogo.Herois.Heroi;
import Jogo.Log;
import Jogo.enums.TipoDificuldade;
import Jogo.enums.TipoMonstro;

import java.util.Random;

public class ColossoDePedraViva extends Monstro{

    public ColossoDePedraViva(int vida, int ataque, int defesa, int destreza, int velocidade, TipoDificuldade dificuldade) {
        super("Colosso de Pedra Viva",
                vida*dificuldade.getDificuldade(),
                ataque*dificuldade.getDificuldade(),
                defesa*dificuldade.getDificuldade(),
                destreza*dificuldade.getDificuldade(),
                velocidade*dificuldade.getDificuldade(),
                TipoMonstro.COLOSSO_DE_PEDRA_VIVA);
    }

    public ColossoDePedraViva(TipoDificuldade dificuldade) {
        super("Colosso de Pedra Viva",
                400*dificuldade.getDificuldade(),
                40*dificuldade.getDificuldade(),
                35*dificuldade.getDificuldade(),
                5*dificuldade.getDificuldade(),
                3*dificuldade.getDificuldade(),
                TipoMonstro.COLOSSO_DE_PEDRA_VIVA);
    }

    //--------------------- Atributos escudos --------------------

    private boolean modoDefensivo = false; // Habilidade para aumentar defesa
    private boolean enraizado = false;

    //--------------------- Factories --------------------

    @Override
    public void realizarAcao(Heroi heroi) throws Exception {
        Random random = new Random();
        int escolha = random.nextInt(4);
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

        double reducaoDano = 0.2;
        System.out.println(this.getNome() + " resiste ao impacto devido ao seu CORPO DE PEDRA!");
        // Reduz o dano recebido em 20%
        int danoRecebido = (int) (dano * (1 - reducaoDano));

        this.setVida(this.getVida() - danoRecebido);
        System.out.println(this.getNome() + " sofreu apenas " + danoRecebido + " de dano!");
        // TODO - Implementa uma tentativa de ação de sofrer dano - ivan
    }

    @Override
    public void comecarNovoTurno() {
        desenraizar();
        desativarModoDefensivo();
    }

    //--------------------- Ações de ataque --------------------

    private void esmagamento(Heroi heroi) {
        System.out.println(this.getNome() + " desfere um golpe esmagador contra " + heroi.getNome() + "!");

        int danoBase = this.getAtaque() + 10;
        if (Math.random() < 0.2) {
            danoBase *= 2;
            System.out.println("GOLPE CRÍTICO! O golpe do Colosso causa destruição massiva!");
        }

        int danoFinal = danoBase - heroi.getDefesa();
        if (danoFinal < 0) danoFinal = 0;

        heroi.sofrerDano(danoFinal);
        System.out.println(heroi.getNome() + " recebeu " + danoFinal + " de dano!");
    }

    private void arremessarPedra(Heroi heroi) {
        System.out.println(this.getNome() + " arranca uma grande pedra do solo e a arremessa!");

        int danoBase = this.getAtaque() + 10;
        if (Math.random() < 0.25) {
            System.out.println("A pedra atinge a cabeça de " + heroi.getNome() + ", causando um atordoamento!");
            // Implementação futura para atordoar o herói
        }

        int danoFinal = danoBase - heroi.getDefesa();
        if (danoFinal < 0) danoFinal = 0;

        heroi.sofrerDano(danoFinal);
        System.out.println(heroi.getNome() + " recebeu " + danoFinal + " de dano!");
    }

    //--------------------- Ações de defesa --------------------

    private void ativarModoDefensivo() {
        System.out.println(this.getNome() + " fortalece sua estrutura rochosa, aumentando a defesa temporariamente!");
        modoDefensivo = true;
    }

    public void enraizar() {
        System.out.println(this.getNome() + " finca seus pés no solo, tornando-se imóvel, mas extremamente resistente!");
        enraizado = true;
        this.setDefesa(this.getDefesa() + 20);
    }

    //--------------------- Desativações de escudo --------------------

    private void desenraizar() {
        System.out.println(this.getNome() + " se liberta do solo e volta a se mover.");
        enraizado = false;
        this.setDefesa(this.getDefesa() - 20);
    }

    private void desativarModoDefensivo() {
        System.out.println(this.getNome() + " retorna ao modo normal.");
        modoDefensivo = false;
    }
}
