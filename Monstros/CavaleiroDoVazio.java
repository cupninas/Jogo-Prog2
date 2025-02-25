package Jogo.Monstros;

import Jogo.Herois.Heroi;
import Jogo.enums.TipoDificuldade;
import Jogo.enums.TipoMonstro;

import java.util.Random;

public class CavaleiroDoVazio extends Monstro{

    public CavaleiroDoVazio(String nome, int vida, int ataque, int defesa, int destreza, int velocidade, TipoDificuldade dificuldade) {
        super(nome,
                vida*dificuldade.getDificuldade(),
                ataque*dificuldade.getDificuldade(),
                defesa*dificuldade.getDificuldade(),
                destreza*dificuldade.getDificuldade(),
                velocidade, TipoMonstro.CAVALEIRO_DO_VAZIO);
    }

    public CavaleiroDoVazio(TipoDificuldade dificuldade) {
        super("Cavaleiro do Vazio",
                280*dificuldade.getDificuldade(),
                30*dificuldade.getDificuldade(),
                25*dificuldade.getDificuldade(),
                12*dificuldade.getDificuldade(),
                6*dificuldade.getDificuldade(),
                TipoMonstro.CAVALEIRO_DO_VAZIO);
    }

    //--------------------- Atributos escudos --------------------

    private boolean vazioEternoAtivo = false; // Ativado quando a vida está baixa

    //--------------------- Factories --------------------

    @Override
    public void realizarAcao(Heroi heroi) throws Exception {
        //TODO - realizar algum dos ataques de forma randomica
        Random random = new Random();
        int escolha = random.nextInt(4);
        switch (escolha) {
            case 0 -> laminaDoAbismo(heroi);
            case 1 -> ataqueSombrio(heroi);
            case 2 -> defesaSombria();
            case 3 -> vazioEterno();
            default -> throw new Exception();
        };
    }

    @Override
    public void sofrerDano(int dano) {
        //TODO - Esse metodo só é chamado por outra classe, não por essa aqui - ivan
        //aqui nao tem esses atributos escudos, nao precisa fazer a verificacao - ivan
        //TODO - se nenhum dos atributos forem true, tenta executar a acao - ivan
        this.vida -= dano;
    }

    @Override
    public void comecarNovoTurno() {
        desativarVazioEterno();
    }

    //--------------------- Ações de ataque --------------------

    private void laminaDoAbismo(Heroi heroi) {
        System.out.println(this.getNome() + " invoca a LÂMINA DO ABISMO!");

        // Causa 50% mais dano e ignora 20% da defesa do herói
        int danoBase = this.getAtaque();
        int defesaIgnorada = (int) (heroi.getDefesa() * 0.2);
        int danoFinal = (danoBase + (danoBase / 2)) - defesaIgnorada;

        if (danoFinal < 0) danoFinal = 0;
        heroi.sofrerDano(danoFinal);

        System.out.println(heroi.getNome() + " recebeu " + danoFinal + " de dano do abismo!");
    }

    private void ataqueSombrio(Heroi heroi) {
        System.out.println(this.getNome() + " lança um ATAQUE SOMBRIO!");

        int dano = this.getAtaque();
        heroi.sofrerDano(dano);

        // Cura 10% do dano causado
        int cura = (int) (dano * 0.1);
        this.setVida(this.getVida() + cura);

        System.out.println(this.getNome() + " absorveu " + cura + " de vida com o ataque!");
    }

    //--------------------- Ações de defesa --------------------

    private void defesaSombria() {
        System.out.println(this.getNome() + " envolve-se em uma aura negra, aumentando sua defesa temporariamente!");

        // Aumenta a defesa em 20% por um turno
        int aumentoDefesa = (int) (this.getDefesa() * 0.2);
        this.setDefesa(this.getDefesa() + aumentoDefesa);
    }

    private void vazioEterno() {
        System.out.println(this.getNome() + " ativa a aura do VAZIO ETERNO! Ele reduz todo dano recebido por 1 turno!");

        vazioEternoAtivo = true;

        // Reduz o dano recebido pela metade no próximo turno
        // (Isso pode ser implementado em um método de receber dano)
    }

    //--------------------- Desativações de escudo --------------------

    private void desativarVazioEterno() {
        if (vazioEternoAtivo) {
            vazioEternoAtivo = false;
            System.out.println(this.getNome() + " sente sua conexão com o vazio enfraquecer... Vazio Eterno foi desativado!");
        } else {
            System.out.println(this.getNome() + " já não está mais imerso no Vazio Eterno.");
        }
    }

}
