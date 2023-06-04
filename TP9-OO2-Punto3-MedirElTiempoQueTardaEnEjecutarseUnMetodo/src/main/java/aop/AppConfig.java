package aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import aop.domain.portsout.GuardarDato;
import aop.domain.portsout.InfrastructureExceptions;
import aop.infrastructure.data.BaseDeDatosGuardarDato;
import aop.infrastructure.data.BaseDeDatosPropiedades;

@Configuration
public class AppConfig {

	@Bean
	public GuardarDato guardarDato() throws InfrastructureExceptions {
		return (new BaseDeDatosGuardarDato(new BaseDeDatosPropiedades(urlBaseDeDatos(), "root", ""),
				"INSERT INTO nombres (nombre) VALUES (?);"));
	}

	@Bean
	public String urlBaseDeDatos() {
		return "jdbc:mysql://127.0.0.1/tp9_registro_de_nombres";
	}
}
