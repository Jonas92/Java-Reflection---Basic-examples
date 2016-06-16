package br.com.alura.capVI_exceptions.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExecutorDeTestes {

	public void testar(Object aExecutar) throws Throwable {
		Class<?> classeParaExecutar = aExecutar.getClass();

		for (Method metodo : classeParaExecutar.getMethods()) {

			if (metodo.getName().startsWith("test"))
				if (metodo.getReturnType().equals(void.class))
					if (metodo.getParameterTypes().length == 0)
						try {
							metodo.invoke(aExecutar);
						} catch (InvocationTargetException e) {
							throw e.getTargetException();
						}

		}
	}

}
