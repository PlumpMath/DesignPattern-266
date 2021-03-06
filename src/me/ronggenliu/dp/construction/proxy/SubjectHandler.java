package me.ronggenliu.dp.construction.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectHandler implements InvocationHandler {

	Subject realSubject = null;
	
	public SubjectHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("Dynamic Proxy - Before process");
		// lazy loading.
		if(realSubject == null) {
			realSubject = new RealSubject();
		}
//		realSubject.process();
		Object obj = method.invoke(realSubject, args);
		System.out.println("Dynamic Proxy - After process");
		return obj;
	}
}
