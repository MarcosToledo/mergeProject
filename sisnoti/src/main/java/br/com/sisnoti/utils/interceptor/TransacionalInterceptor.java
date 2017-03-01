package br.com.sisnoti.utils.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import br.com.sisnoti.utils.annotation.Transacional;

@Interceptor
@Transacional
public class TransacionalInterceptor {
	@Inject
	private EntityManager entityManager;

	@AroundInvoke
	public Object intercept(InvocationContext ctx) {
		Object resultado = null;
		try {
			entityManager.joinTransaction();
			resultado = ctx.proceed();
		} catch (Exception e) {
			System.out.println("Erro no commit da transação: " + e);
		}
		return resultado;
	}
}
