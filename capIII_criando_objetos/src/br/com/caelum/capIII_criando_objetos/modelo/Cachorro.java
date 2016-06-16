package br.com.caelum.capIII_criando_objetos.modelo;

public class Cachorro implements Animal {

	private String nome;
	private String raca;
	private double peso;

	public Cachorro(String nome, String raca, double peso) {
		this.nome = nome;
		this.raca = raca;
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Cachorro " + nome + " da raça " + raca + " com peso " + peso + "Kg";
	}
}
