package aop.infrastructure.data;

import java.util.Objects;
import java.util.Properties;

import org.springframework.stereotype.Component;

import aop.domain.portsout.InfrastructureExceptions;
import aop.domain.portsout.Propiedades;

@Component
public class BaseDeDatosPropiedades implements Propiedades {

	private Properties propiedades;

	public BaseDeDatosPropiedades(String urlBaseDeDatos, String usuario, String contrasena)
			throws InfrastructureExceptions {

		if (Objects.isNull(urlBaseDeDatos)) {
			throw new InfrastructureExceptions("Datos nulos urlBaseDeDatos BaseDeDatosPropiedades");
		}

		if (Objects.isNull(usuario)) {
			throw new InfrastructureExceptions("Datos nulos usuario BaseDeDatosPropiedades");
		}

		if (Objects.isNull(contrasena)) {
			throw new InfrastructureExceptions("Datos nulos contrasena BaseDeDatosPropiedades");
		}

		propiedades = new Properties();

		propiedades.put("url", urlBaseDeDatos);
		propiedades.put("usuario", usuario);
		propiedades.put("contrasena", contrasena);
	}

	public String get(String key) {
		return propiedades.getProperty(key);
	}
}
