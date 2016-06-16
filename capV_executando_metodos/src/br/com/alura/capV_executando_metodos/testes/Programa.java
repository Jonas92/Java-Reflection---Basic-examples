package br.com.alura.capV_executando_metodos.testes;

import br.com.alura.capV_executando_metodos.modelo.Usuario;
import br.com.alura.capV_executando_metodos.util.ExecutorDeTestes;

public class Programa {

	public static void main(String[] args) throws Exception {

		ExecutorDeTestes executorDeTestes = new ExecutorDeTestes();
		Usuario usuario = new Usuario();
		executorDeTestes.testar(usuario);
	}
}
