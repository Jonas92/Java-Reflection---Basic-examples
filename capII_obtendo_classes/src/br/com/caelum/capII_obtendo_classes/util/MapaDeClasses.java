package br.com.caelum.capII_obtendo_classes.util;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MapaDeClasses {

	private Map<Class<?>, Class<?>> mapa = new HashMap<>();

	public MapaDeClasses(String nomeArquivo) {
		try {
			carregar(nomeArquivo);
		} catch (Exception e) {
			System.out.println("Erro ao carregar o arquivo!\n" + e.getMessage());
		}
	}

	public Class<?> getClass(String abstracaoParam) throws Exception {

		Class<?> abstracao = Class.forName(abstracaoParam);

		if (!abstracao.isInterface())
			throw new RuntimeException("Não é uma interface!");

		return mapa.get(abstracao);
	}

	private void carregar(String nomeArquivo) throws Exception {
		Properties properties = new Properties();
		properties.load(new FileInputStream(nomeArquivo));

		for (Object key : properties.keySet()) {
			Class<?> abstracao = Class.forName(key.toString());
			Class<?> implementacao = Class.forName(properties.get(key).toString());

			if (abstracao.isAssignableFrom(implementacao))
				mapa.put(abstracao, implementacao);
			else
				throw new RuntimeException(implementacao + " não implementa " + abstracao);
		}

	}
}
