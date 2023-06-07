package aop.domain.model;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MedirTiempoAspect {

	@Around("@annotation(Time)")
	public void aroundAdvice(ProceedingJoinPoint point) throws Throwable {

		long inicio = System.currentTimeMillis();
		System.out.println("antes del proceso: " + inicio);

		var value = point.proceed();

		long fin = System.currentTimeMillis();
		System.out.println("despues del proceso: " + fin);

		System.out.println("final: " + (fin - inicio));
//		return fin - inicio;
	}
}
