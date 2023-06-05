package aop.domain.portsout;

import java.util.List;

public interface GuardarDato {

	void registrar(List<String> listaRegistros) throws InfrastructureExceptions;

}
