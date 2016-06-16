package br.com.alura.capVI_exceptions.modelo;

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
		throw new RuntimeException();
	}

	public void teste3() {
		executando("Teste3()");
	}

	private void executando(String nomeDoMetodo) {
		System.out.println("Executando " + nomeDoMetodo);
	}
}
