package br.com.caelum.capIII_criando_objetos.testes;

import br.com.caelum.capIII_criando_objetos.modelo.Animal;
import br.com.caelum.capIII_criando_objetos.modelo.Cachorro;
import br.com.caelum.capIII_criando_objetos.util.MapaDeCaracteristicas;

public class TestaCachorro {
	public static void main(String[] args) throws Exception {

		Animal cachorro = new Cachorro("Ted", "Puddle", 5.2);

		MapaDeCaracteristicas mapaDeCaracteristicas = new MapaDeCaracteristicas();
		mapaDeCaracteristicas.gravar(cachorro);

		mapaDeCaracteristicas.recuperar();
	}

}
