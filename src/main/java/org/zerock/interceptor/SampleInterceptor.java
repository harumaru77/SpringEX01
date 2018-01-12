package org.zerock.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter {
	// * �ۼ��� SampleInterceptor�� ���������� �ν��Ϸ��� servelet-context.xml�� ������ �߰��Ǿ�� �Ѵ�.
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		// * ��Ʈ�ѷ� �޼ҵ��� ������ ������, ���� ȭ��ó���� �ȵ� �����̹Ƿ� �ʿ��ϴٸ� �޼ҵ��� ���� ���Ŀ� �߰����� �۾��� ������.
		
		System.out.println("post handle ................");
		
		Object result = modelAndView.getModel().get("result");
		
		if(result != null) {
			request.getSession().setAttribute("result", result);
			response.sendRedirect("/doA");
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// * ���ϰ��� boolean�ε�... �̸� �̿��ؼ� ���� interceptor�� ��� ��Ʈ�ѷ��� ȣ���ϵ��� �� �������� �����Ѵ�.
		// * 3��° �Ķ���� handler�� ���� �����Ϸ��� �޼ҵ� ��ü�� �ǹ��Ѵ�. �̸� Ȱ���ϸ� ���� ����Ǵ� ��Ʈ�ѷ��� �ľ��ϰų�, 
		//   �߰����� �޼ҵ带 �����ϴ� ���� �۾��� �����ϴ�. 
		System.out.println("pre handle ................");
		
		HandlerMethod method = (HandlerMethod)handler;
		Method methodObj = method.getMethod();
		
		System.out.println("Bean: " + method.getBean());
		System.out.println("Method: " + methodObj);
		
		return super.preHandle(request, response, handler);
	}
}
