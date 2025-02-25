package Jogo.enums;
import java.util.List;

public enum TipoArma { 
    ESPADA_LONGA(0, "Espada Longa", "Uma espada versátil usada por cavaleiros medievais. Equilibra alcance e poder de ataque.", 30),
    MACHADO_DE_BATALHA(1, "Machado de Batalha", "Uma arma pesada capaz de partir armaduras. Muito usada por guerreiros nórdicos.", 30),
    LANCA(2, "Lança", "Arma de grande alcance, usada desde a Antiguidade para combates e caçadas.", 21),
    ADAGA(3, "Adaga", "Uma lâmina curta, ideal para ataques rápidos e furtivos. Muitas vezes usada por assassinos.", 24),
    ESPADA_CURTA(4, "Espada Curta", "Menor que a espada longa, usada por legionários romanos para combates próximos.", 33),
    ESPADA_BASTARDA(5, "Espada Bastarda", "Também chamada de espada de mão e meia, permite golpes poderosos e rápidos.", 45),
    CLAVA(6, "Clava", "Arma rudimentar, mas eficaz. Um porrete de madeira ou metal usado para esmagar ossos.", 24),
    TRIDENTE(7, "Tridente", "Usado por gladiadores e pescadores, permite ataques de perfuração a média distância.", 30),
    FOICE(8, "Foice", "Originalmente uma ferramenta agrícola, mas usada como arma em revoltas camponesas.", 24),
    KATANA(9, "Katana", "A espada lendária dos samurais. Conhecida por seu fio afiado e cortes precisos.", 50),
    SABRE(10, "Sabre", "Uma lâmina curva usada por cavaleiros e oficiais militares para cortes ágeis.", 60),
    MACHADINHA(11, "Machadinha", "Uma versão menor do machado de batalha, ideal para combate ágil e arremesso.", 30);


    private final int id;
    private final String nome;
    private final String descricao;
    private final int ataque;

    private TipoArma(int id, String nome, String descricao, int ataque){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ataque = ataque;
    }

    public static List<TipoArma> obterArmasParaGuerreiro() {
        return List.of(
                TipoArma.ESPADA_LONGA,
                TipoArma.MACHADO_DE_BATALHA,
                TipoArma.ESPADA_BASTARDA,
                TipoArma.CLAVA
        );
    }

    public static List<TipoArma> obterArmasParaArqueiro() {
        return List.of(
                TipoArma.TRIDENTE,
                TipoArma.ADAGA,
                TipoArma.SABRE
        );
    }

    public static List<TipoArma> obterArmasParaLadino() {
        return List.of(
                TipoArma.ADAGA,
                TipoArma.ESPADA_CURTA,
                TipoArma.MACHADINHA,
                TipoArma.LANCA
        );
    }

    public static List<TipoArma> obterArmasParaMago() {
        return List.of(
                TipoArma.FOICE,
                TipoArma.TRIDENTE,
                TipoArma.SABRE,
                TipoArma.KATANA
        );
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public int getAtaque() {
        return ataque;
    }
}
