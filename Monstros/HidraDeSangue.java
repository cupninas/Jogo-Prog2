package Jogo.Monstros;

import Jogo.Herois.Heroi;
import Jogo.enums.TipoDificuldade;
import Jogo.enums.TipoMonstro;

import java.util.Random;

public class HidraDeSangue extends Monstro{
    private int vidaMaxima = 250;

    public HidraDeSangue(int vida, int ataque, int defesa, int destreza, int velocidade, TipoDificuldade dificuldade) {
        super("Hidra de Sangue",
                vida*dificuldade.getDificuldade(),
                ataque*dificuldade.getDificuldade(),
                defesa*dificuldade.getDificuldade(),
                destreza*dificuldade.getDificuldade(),
                velocidade*dificuldade.getDificuldade(),
                TipoMonstro.HIDRA_DE_SANGUE);
        this.vidaMaxima = vida;
    }

    public HidraDeSangue(TipoDificuldade dificuldade) {
        super("Hidra de Sangue",
                250*dificuldade.getDificuldade(),
                25*dificuldade.getDificuldade(),
                15*dificuldade.getDificuldade(),
                10*dificuldade.getDificuldade(),
                7*dificuldade.getDificuldade(),
                TipoMonstro.HIDRA_DE_SANGUE);
        this.vidaMaxima = 250;
    }

    //--------------------- Atributos escudos --------------------

    private boolean cabecasCortadasCrescendo;

    //--------------------- Factories --------------------

    @Override
    public void realizarAcao(Heroi heroi) throws Exception {
        //TODO - realizar algum dos ataques de forma randomica - ivan
        Random random = new Random();
        int escolha = random.nextInt(5);
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
        //TODO - Esse metodo só é chamado por outra classe, não por essa aqui
        //aqui nao tem esses atributos escudos, nao precisa fazer a verificacao
        //TODO - se nenhum dos atributos forem true, tenta executar a acao,
        this.vida -= dano;
    }

    @Override
    public void comecarNovoTurno() {
        concluirRegeneracaoDeCabecas();
    }

    //--------------------- Ações de ataque --------------------

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

    private void ataqueNormal(Heroi heroi) {
        System.out.println(this.getNome() + " lança uma investida feroz!");
        heroi.sofrerDano(this.getAtaque());
    }

    //--------------------- Ações de defesa --------------------

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

    public void ativarRegeneracaoDeCabecas() {
        if (!cabecasCortadasCrescendo) {
            cabecasCortadasCrescendo = true;
            System.out.println(this.getNome() + " começa a regenerar suas cabeças cortadas... Em breve ela estará ainda mais poderosa!");
        } else {
            System.out.println(this.getNome() + " já está regenerando suas cabeças!");
        }
    }

    //--------------------- Desativações de escudo --------------------

    public void concluirRegeneracaoDeCabecas() {
        if (cabecasCortadasCrescendo) {
            cabecasCortadasCrescendo = false;
            this.ataque += 5; // Com mais cabeças, o ataque aumenta
            System.out.println(this.getNome() + " regenerou suas cabeças cortadas! Agora ficou ainda mais feroz!");
        } else {
            System.out.println(this.getNome() + " não tem cabeças cortadas para regenerar.");
        }
    }

}
