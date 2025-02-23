package Jogo.Monstros;

import Jogo.Herois.Heroi;
import Jogo.enums.TipoMonstro;

public class ColossoDePedraViva extends Monstro{
    private final double reducaoDano = 0.2; // Reduz 20% de todo dano recebido (passiva)

    public ColossoDePedraViva(String nome, int vida, int ataque, int defesa, int destreza, int velocidade) {
        super(nome, vida, ataque, defesa, destreza, velocidade, TipoMonstro.COLOSSO_DE_PEDRA_VIVA);
    }

    public ColossoDePedraViva() {
        super("Colosso de Pedra Viva", 400, 40, 35, 5, 3, TipoMonstro.COLOSSO_DE_PEDRA_VIVA);
    }

    @Override
    protected void realizarAcao(Heroi heroi) {

    }

    @Override
    public void sofrerDano(int dano) {
        System.out.println(this.getNome() + " resiste ao impacto devido ao seu CORPO DE PEDRA!");
        // Reduz o dano recebido em 20%
        int danoRecebido = (int) (dano * (1 - reducaoDano));
        this.setVida(this.getVida() - danoRecebido);

        System.out.println(this.getNome() + " sofreu apenas " + danoRecebido + " de dano!");
        // TODO - Implementa uma tentativa de ação de sofrer dano - ivan
    }
}
