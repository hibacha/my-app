package com.nash.advisor;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

import com.nash.interceptor.FinderIntroductionInterceptor;

public class FinderIntroductionAdvisor extends DefaultIntroductionAdvisor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FinderIntroductionAdvisor() {
		super(new FinderIntroductionInterceptor());
	}

	
}
