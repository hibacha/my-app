package com.nash.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

import com.nash.finder.FinderExecutor;



public class FinderIntroductionInterceptor implements IntroductionInterceptor{

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		Method method = methodInvocation.getMethod();
		Object[] args = methodInvocation.getArguments();
		String methodName = method.getName();
		if(methodName.startsWith("find")){
			FinderExecutor genericDaoImpl = (FinderExecutor)methodInvocation.getThis();
			genericDaoImpl.executeFinder(method,args );
		}
		return methodInvocation.proceed();
	}

	@Override
	public boolean implementsInterface(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
