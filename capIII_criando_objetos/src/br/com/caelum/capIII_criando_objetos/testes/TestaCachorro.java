package br.com.caelum.capIII_criando_objetos.testes;

import br.com.caelum.capIII_criando_objetos.modelo.Animal;
import br.com.caelum.capIII_criando_objetos.util.MapaDeClasses;

public class TestaCachorro {
	public static void main(String[] args) throws Exception {

		MapaDeClasses mapaDeClasses = new MapaDeClasses("classes.prop");

		Object[] parametrosDoCachorro = new Object[] {"Totó", "vira-lata", 5.9};

		Animal cachorroComParametros = mapaDeClasses.getObject("br.com.caelum.capIII_criando_objetos.modelo.Animal",
			parametrosDoCachorro);

		System.out.println(cachorroComParametros);

		System.out.println();

	}

}
