package br.com.alura.capV_executando_metodos.util;

import java.lang.reflect.Method;

public class ExecutorDeTestes {

	public void testar(Object aExecutar) throws Exception {
		Class<?> classeParaExecutar = aExecutar.getClass();

		for (Method metodo : classeParaExecutar.getMethods()) {

			if (metodo.getName().startsWith("test"))
				if (metodo.getReturnType().equals(void.class))
					if (metodo.getParameterTypes().length == 0)
						metodo.invoke(aExecutar);

		}
	}

}
