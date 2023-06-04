package aop.infrastructure.data;

import java.util.List;

import org.springframework.stereotype.Component;

import aop.domain.portsout.GuardarDato;
import aop.domain.portsout.Propiedades;

@Component
public class BaseDeDatosGuardarDato implements GuardarDato {

	private Propiedades properties;
	private String sqlInsertNombre;

	public BaseDeDatosGuardarDato(Propiedades properties, String sqlInsertNombre) {
		this.properties = properties;
		this.sqlInsertNombre = sqlInsertNombre;
	}

	@Override
	public void registrar(List<String> listaRegistros) {
		// GAURDA LOS NOMBRES GENERADOS EN LA BASE DE DATOS, UNA VEZ QUE LO GUARDASTE
		// TOMA EL TIEMPO CON ASPECTO
	}
}
