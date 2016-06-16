package br.com.alura.capVI_exceptions.testes;

import br.com.alura.capVI_exceptions.modelo.Usuario;
import br.com.alura.capVI_exceptions.util.ExecutorDeTestes;

public class Programa {

	public static void main(String[] args) throws Throwable {

		ExecutorDeTestes executorDeTestes = new ExecutorDeTestes();
		Usuario usuario = new Usuario();
		executorDeTestes.testar(usuario);
	}
}
