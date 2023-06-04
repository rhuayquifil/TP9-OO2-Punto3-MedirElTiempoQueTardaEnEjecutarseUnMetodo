package aop.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aop.domain.model.FabricaNombresAleatorios;
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

	@RequestMapping("/medirTiempo")
	public String medirTiempo(@RequestParam("cantidadPersonas") int cantidadPersonas) {

		List<String> listaNombre = new ArrayList<String>();

		int i = 0;
		FabricaNombresAleatorios fabricaDeNombres = new FabricaNombresAleatorios();
		while (i < 5) {
			listaNombre.add(fabricaDeNombres.generarNombreAleatorio());
			i++;
		}

		guardarDato.registrar(listaNombre);
		return "NASHEIIII";
	}
}
