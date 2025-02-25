package Jogo.enums;

import lombok.Getter;

@Getter
public enum TipoMonstro {
    ESPECTRO_DA_AGONIA(0, "Espectro da Agonia", "Criatura etérea que se alimenta do sofrimento das almas vivas."),
    ABOMINACAO_DA_CARNE(1, "Abominação da Carne", "Um amontoado de membros e olhos costurados juntos, movendo-se de forma grotesca."),
    HIDRA_DE_SANGUE(2, "Hidra de Sangue", "Uma serpente monstruosa com cabeças regenerativas que expelem venenos letais."),
    CAVALEIRO_DO_VAZIO(3, "Cavaleiro do Vazio", "Um guerreiro espectral preso em uma armadura negra, guardião de um segredo antigo."),
    COLOSSO_DE_PEDRA_VIVA(4, "Colosso de Pedra Viva", "Uma estátua gigante que desperta para esmagar aqueles que perturbam seu repouso.");

    private final int id;
    private final String nome;
    private final String descricao;

    TipoMonstro(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
}
