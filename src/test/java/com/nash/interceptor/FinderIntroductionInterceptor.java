package com.nash.interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;



public class FinderIntroductionInterceptor implements IntroductionInterceptor{

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		// TODO Auto-generated method stub
		return methodInvocation.proceed();
	}

	@Override
	public boolean implementsInterface(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
