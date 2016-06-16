package br.com.caelum.capI_primeiro_contato.testes;

import java.lang.reflect.Field;

import br.com.caelum.capI_primeiro_contato.model.Carro;

public class Programa {

	public static void main(String[] args) throws Exception {

		Carro objeto = new Carro();
		objeto.cor = "azul";
		objeto.modelo = "c3";
		// ÚTIL PARA CONSULTAS COM O SGBD;
		System.out.println(objeto.getClass().getSimpleName().toLowerCase().concat("s"));
		System.out.println();

		Field[] fields = objeto.getClass().getFields();
		for (Field field : fields) {
			System.out.print(field.getName() + " - ");
			System.out.print(field.getModifiers() + " - ");
			System.out.print(field.getType().getSimpleName() + "\n");
		}

		System.out.println();
		System.out.println(objeto.getClass().getField("cor").get(objeto));
		System.out.println(objeto.getClass().getField("modelo").get(objeto));
	}
}
