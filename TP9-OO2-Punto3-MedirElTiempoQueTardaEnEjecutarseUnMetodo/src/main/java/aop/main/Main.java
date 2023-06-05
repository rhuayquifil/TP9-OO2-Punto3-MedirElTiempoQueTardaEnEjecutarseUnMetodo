package aop.main;

import java.util.ArrayList;
import java.util.List;

import aop.domain.model.FabricaNombresAleatorios;
import aop.domain.portsout.GuardarDato;
import aop.domain.portsout.InfrastructureExceptions;
import aop.infrastructure.data.BaseDeDatosGuardarDato;
import aop.infrastructure.data.BaseDeDatosPropiedades;

public class Main {

	public static void main(String[] args) {
		try {

			List<String> listaNombre = new ArrayList<String>();

			int i = 0;
			FabricaNombresAleatorios fabricaDeNombres = new FabricaNombresAleatorios();
			while (i < 5) {
				listaNombre.add(fabricaDeNombres.generarNombreAleatorio());
				i++;
			}

			GuardarDato base = new BaseDeDatosGuardarDato(
					new BaseDeDatosPropiedades("jdbc:mysql://127.0.0.1/tp9_registro_de_nombres", "root", ""),
					"INSERT INTO nombres (nombre)" + "VALUES (?);");

			base.registrar(listaNombre);
		} catch (InfrastructureExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
