package br.com.alura.capV_executando_metodos.modelo;

public class Usuario {

	public void naoEhParaInvocar() {
		executando("naoEhParaInvocar()");
	}

	public void teste(int inteiro) {
		executando("Teste(int inteiro)");
	}

	public boolean teste() {
		executando("boolean Teste()");
		return true;
	}

	public void teste2() {
		executando("Teste2()");
	}

	public void teste3() {
		executando("Teste3()");
	}

	private void executando(String nomeDoMetodo) {
		System.out.println("Executando " + nomeDoMetodo);
	}
}
