package br.com.caelum.capIII_criando_objetos.testes;

import java.util.List;

import br.com.caelum.capIII_criando_objetos.modelo.Animal;
import br.com.caelum.capIII_criando_objetos.util.MapaDeClasses;

public class Programa {

	public static void main(String[] args) throws Exception {

		MapaDeClasses mapaDeClasses = new MapaDeClasses("classes.prop");

		System.out.println(mapaDeClasses.getClass("java.util.List"));
		System.out.println(mapaDeClasses.getClass("java.util.Map"));
		System.out.println(mapaDeClasses.getClass("br.com.caelum.capIII_criando_objetos.modelo.Animal"));

		List<Integer> teste = mapaDeClasses.getObject("java.util.List");
		teste.add(0);
		teste.add(1);
		teste.add(2);

		System.out.println(teste);
		System.out.println(mapaDeClasses.getObject("java.util.Map"));

		// TEM QUE DAR PAU PQ NÃO TEM CONSTRUTOR SEM ARGUMENTOS
		// Animal cachorroSemParametros =
		// mapaDeClasses.getObject("br.com.caelum.capIII_criando_objetos.modelo.Animal");
		// System.out.println(cachorroSemParametros);

		// Object[] parametros = new Object[] {"toto", "vira-lata"};

		// DA PAU PQ TEM QUE FAZER O CASTING DE double PRA DOUBLE
		Object[] parametros = new Object[] {"toto", "vira-lata", 5.9};

		// Animal cachorroComParametros =
		// mapaDeClasses.getObject("br.com.caelum.capIII_criando_objetos.modelo.Animal",
		// "toto", "vira-lata");

		Animal cachorroComParametros = mapaDeClasses.getObject("br.com.caelum.capIII_criando_objetos.modelo.Animal",
			parametros);

		System.out.println(cachorroComParametros);

		System.out.println();

	}

}
