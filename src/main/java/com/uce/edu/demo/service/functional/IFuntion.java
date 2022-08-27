package com.uce.edu.demo.service.functional;
@FunctionalInterface
public interface IFuntion<R,T> {
	
	public R apply(T arga1);
}
