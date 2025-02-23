package Jogo.Monstros;

import Jogo.Herois.Heroi;
import Jogo.enums.TipoMonstro;

import java.util.Random;

public class HidraDeSangue extends Monstro{
    private int vidaMaxima = 250;

    public HidraDeSangue(String nome, int vida, int ataque, int defesa, int destreza, int velocidade) {
        super(nome, vida, ataque, defesa, destreza, velocidade, TipoMonstro.HIDRA_DE_SANGUE);
        this.vidaMaxima = vida;
    }

    public HidraDeSangue() {
        super("Hidra de Sangue", 250, 25, 15, 10, 7, TipoMonstro.HIDRA_DE_SANGUE);
        this.vidaMaxima = 250;
    }

    @Override
    protected void realizarAcao(Heroi heroi) {
        //TODO - realizar algum dos ataques de forma randomica
    }

    @Override
    public void sofrerDano(int dano) {
        //TODO - Esse metodo só é chamado por outra classe, não por essa aqui
        //aqui nao tem esses atributos escudos, nao precisa fazer a verificacao
        //TODO - se nenhum dos atributos forem true, tenta executar a acao,
        this.vida -= dano;
    }

    private void morderMultiplo(Heroi heroi) {
        System.out.println(this.getNome() + " ataca com suas múltiplas cabeças!");

        Random random = new Random();
        int numeroMordidas = random.nextInt(3) + 2; // Entre 2 e 4 mordidas

        for (int i = 0; i < numeroMordidas; i++) {
            int dano = this.getAtaque() / 2; // Cada mordida causa metade do ataque normal
            heroi.sofrerDano(dano);
            System.out.println("Mordida #" + (i + 1) + ": " + heroi.getNome() + " recebeu " + dano + " de dano!");
        }
    }

    private void regeneracaoSanguinea() {
        int cura = (int) (this.vidaMaxima * 0.08); // Cura 8% da vida máxima
        this.setVida(this.getVida() + cura);

        System.out.println(this.getNome() + " ativa REGENERAÇÃO SANGUÍNEA e recupera " + cura + " de HP!");
    }

    private void cabecasRenascidas() {
        System.out.println(this.getNome() + " ruge enquanto novas cabeças surgem, restaurando parte de seu poder!");

        int cura = (int) (this.vidaMaxima * 0.4); // Recupera 40% da vida máxima
        this.setVida(this.getVida() + cura);
        System.out.println(this.getNome() + " regenerou " + cura + " de HP!");

        // Poderia ganhar um buff temporário, como aumento de ataque ou defesa
    }

    private void ataqueNormal(Heroi heroi) {
        System.out.println(this.getNome() + " lança uma investida feroz!");
        heroi.sofrerDano(this.getAtaque());
    }
}
