package Jogo.enums;

import lombok.Getter;

@Getter
public enum TipoArma {
    ESPADA_LONGA(0, "Espada Longa", "Uma espada versátil usada por cavaleiros medievais. Equilibra alcance e poder de ataque."),
    MACHADO_DE_BATALHA(1, "Machado de Batalha", "Uma arma pesada capaz de partir armaduras. Muito usada por guerreiros nórdicos."),
    LANCA(2, "Lança", "Arma de grande alcance, usada desde a Antiguidade para combates e caçadas."),
    ADAGA(3, "Adaga", "Uma lâmina curta, ideal para ataques rápidos e furtivos. Muitas vezes usada por assassinos."),
    ESPADA_CURTA(4, "Espada Curta", "Menor que a espada longa, usada por legionários romanos para combates próximos."),
    ESPADA_BASTARDA(5, "Espada Bastarda", "Também chamada de espada de mão e meia, permite golpes poderosos e rápidos."),
    CLAVA(6, "Clava", "Arma rudimentar, mas eficaz. Um porrete de madeira ou metal usado para esmagar ossos."),
    TRIDENTE(7, "Tridente", "Usado por gladiadores e pescadores, permite ataques de perfuração a média distância."),
    FOICE(8, "Foice", "Originalmente uma ferramenta agrícola, mas usada como arma em revoltas camponesas."),
    KATANA(9, "Katana", "A espada lendária dos samurais. Conhecida por seu fio afiado e cortes precisos."),
    SABRE(10, "Sabre", "Uma lâmina curva usada por cavaleiros e oficiais militares para cortes ágeis."),
    MACHADINHA(11, "Machadinha", "Uma versão menor do machado de batalha, ideal para combate ágil e arremesso.");


    private int id;
    private String nome;
    private String descricao;

    private TipoArma(int id, String nome, String descricao){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
}
