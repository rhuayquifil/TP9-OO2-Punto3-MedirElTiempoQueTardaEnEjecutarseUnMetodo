package aop.infrastructure.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import aop.domain.portsout.GuardarDato;
import aop.domain.portsout.InfrastructureExceptions;
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
	public void registrar(List<String> listaRegistros) throws InfrastructureExceptions {

		try (Connection conn = DriverManager.getConnection(properties.get("url"), properties.get("usuario"),
				properties.get("contrasena"));
				java.sql.PreparedStatement state = conn.prepareStatement(sqlInsertNombre)) {

//			"INSERT INTO nombres (nombre) VALUES (?);"

			for (String registro : listaRegistros) {

				state.setString(1, registro);

				int cantidad = state.executeUpdate();

				if (cantidad <= 0) {
					throw new InfrastructureExceptions("error al ingresar Registro");
				}
			}

		} catch (SQLException | NumberFormatException e) {
			throw new InfrastructureExceptions("error al prosesar consulta");
		}
	}
}
