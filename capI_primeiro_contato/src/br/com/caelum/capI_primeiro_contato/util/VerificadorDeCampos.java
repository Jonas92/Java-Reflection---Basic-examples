package br.com.caelum.capI_primeiro_contato.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerificadorDeCampos {

	public List<String> pegaCamposNulosEm(Object objeto) {
		List<String> camposNulos = new ArrayList<>();

		try {

			Class<?> classe = objeto.getClass();

			for (Field atributo : classe.getFields())
				if (atributo.get(objeto) == null)
					camposNulos.add(atributo.getName());

		} catch (Exception e) {
			System.err.println("Erro ao adicionar campo com valor nulo! " + e.getMessage());
		}

		return Collections.unmodifiableList(camposNulos);
	}

	public List<String> pegaAtributosQueContemComoValorA(String stringPesquisada, Object objeto) {

		List<String> atributosComValoresQueContemAStringDesejada = new ArrayList<>();

		try {

			Class<?> classe = objeto.getClass();

			for (Field atributo : classe.getFields())
				if (stringPesquisada.equals(atributo.get(objeto)))
					atributosComValoresQueContemAStringDesejada.add(atributo.getName());

		} catch (Exception e) {
			System.err.println("Erro ao adicionar campo com valor desejado! " + e.getMessage());
		}

		return Collections.unmodifiableList(atributosComValoresQueContemAStringDesejada);
	}

}
