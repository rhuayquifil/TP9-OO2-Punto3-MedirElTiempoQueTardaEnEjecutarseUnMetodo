package aop.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aop.domain.model.FabricaNombresAleatorios;
import aop.domain.model.Time;
import aop.domain.portsout.GuardarDato;
import aop.domain.portsout.InfrastructureExceptions;

@org.springframework.stereotype.Controller
public class MedirTiempoController {

	private GuardarDato guardarDato;

	@Autowired
	public MedirTiempoController(GuardarDato guardarDato) throws InfrastructureExceptions {
		super();
		this.guardarDato = guardarDato;
	}

	@RequestMapping("/registrar10nombres")
	@Time
	public String registrar10nombres() throws InfrastructureExceptions {

		List<String> listaNombre = new ArrayList<String>();

		generarNombres(listaNombre, 10);

		guardarDato.registrar(listaNombre);
		return "NASHEIIII";
	}

	private void generarNombres(List<String> listaNombre, int cantidadPersonas) {
		int i = 0;
		FabricaNombresAleatorios fabricaDeNombres = new FabricaNombresAleatorios();
		while (i < cantidadPersonas) {
			listaNombre.add(fabricaDeNombres.generarNombreAleatorio());
			i++;
		}
	}

	@RequestMapping("/medirTiempo")
	public String medirTiempo(@RequestParam("cantidadPersonas") int cantidadPersonas) throws InfrastructureExceptions {

		List<String> listaNombre = new ArrayList<String>();

		generarNombres(listaNombre, cantidadPersonas);

		guardarDato.registrar(listaNombre);
		return "NASHEIIII";
	}
}
