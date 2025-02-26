package spring.aop;

import java.util.Iterator;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PositiveParamsAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation m) throws Throwable {
		Object[] args=m.getArguments();
	for(int i=0;i<args.length;i++){
		args[i]=Math.abs((Integer)args[i]);
		System.out.println("inside around advice ");
		
		
	}
	return m.proceed();
	}
}
