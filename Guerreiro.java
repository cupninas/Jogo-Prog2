package Jogo;

public class Guerreiro extends Classe {
	private String maoSecundaria;
	
	public Guerreiro(String nome, String arma, String tipoDano, String habilidade, String maoSecundaria) {
		super(nome, arma, tipoDano, habilidade);
		this.maoSecundaria = maoSecundaria;
	}

	public String getMaoSecundaria() {
		return maoSecundaria;
	}

	public void setMaoSecundaria(String maoSecundaria) {
		this.maoSecundaria = maoSecundaria;
	}
}
