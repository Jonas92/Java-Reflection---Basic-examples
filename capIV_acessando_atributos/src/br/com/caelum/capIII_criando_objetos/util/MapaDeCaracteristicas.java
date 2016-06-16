package br.com.caelum.capIII_criando_objetos.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import br.com.caelum.capIII_criando_objetos.modelo.Animal;

public class MapaDeCaracteristicas {

	private Map<String, Object> caracteristicas;

	public MapaDeCaracteristicas() {
		caracteristicas = new HashMap<>();
	}

	public void gravar(Animal animal) throws Exception {

		for (Field atributo : animal.getClass().getDeclaredFields()) {
			atributo.setAccessible(true);
			caracteristicas.put(atributo.getName().toUpperCase(), atributo.get(animal));
		}
	}

	public void recuperar() {
		System.out.println(caracteristicas);
	}

}
