package br.com.caelum.capIII_criando_objetos.util;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@SuppressWarnings("unchecked")
public class MapaDeClasses {

	private Map<Class<?>, Class<?>> mapa = new HashMap<>();

	public MapaDeClasses(String nomeArquivo) {
		try {
			carregar(nomeArquivo);
		} catch (Exception e) {
			System.out.println("Erro ao carregar o arquivo!\n" + e.getMessage());
		}
	}

	public Class<?> getClass(String nomeAbstracao) throws Exception {

		Class<?> abstracao = Class.forName(nomeAbstracao);

		if (!abstracao.isInterface())
			throw new RuntimeException("Não é uma interface!");

		if (!mapa.containsKey(abstracao))
			throw new RuntimeException(abstracao + " não encontrada");

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

	public <o> o getObject(String nomeAbstracao, Object... parametros) {
		try {

			Class<?> implementacaoDesejada = getClass(nomeAbstracao);

			Class<?>[] tiposDosParametros = new Class<?>[parametros.length];

			for (int i = 0; i < parametros.length; i++) {
				if (parametros[i].getClass().getName().equals(Double.class.getName()))
					tiposDosParametros[i] = double.class;
				else
					tiposDosParametros[i] = parametros[i].getClass();
			}

			Constructor<?> constructor = implementacaoDesejada.getConstructor(tiposDosParametros);

			return (o) constructor.newInstance(parametros);

		} catch (Exception e) {
			throw new RuntimeException("Erro ao instanciar o objeto. " + e.getMessage());
		}
	}

	public <o> o getObject(String nomeAbstracao) throws Exception {
		try {
			return (o) getClass(nomeAbstracao).newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao instanciar o objeto. " + e.getMessage());
		}
	}

}
