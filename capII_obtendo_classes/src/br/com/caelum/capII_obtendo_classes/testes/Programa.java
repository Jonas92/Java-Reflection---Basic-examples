package br.com.caelum.capII_obtendo_classes.testes;

import br.com.caelum.capII_obtendo_classes.util.MapaDeClasses;

public class Programa {

	public static void main(String[] args) throws Exception {

		MapaDeClasses mapaDeClasses = new MapaDeClasses("classes.prop");

		System.out.println(mapaDeClasses.getClass("java.util.List"));
		System.out.println(mapaDeClasses.getClass("java.util.Map"));
	}
}
