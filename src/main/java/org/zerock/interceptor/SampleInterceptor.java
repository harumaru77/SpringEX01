package org.zerock.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter {
	// * 작성된 SampleInterceptor를 스프링에서 인식하려면 servelet-context.xml에 설정이 추가되어야 한다.
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		// * 컨트롤러 메소드의 실행이 끝나고, 아직 화면처리는 안된 상태이므로 필요하다면 메소드의 실행 이후에 추가적인 작업이 가능함.
		
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
		// * 리턴값이 boolean인데... 이를 이용해서 다음 interceptor나 대상 컨트롤러를 호출하도록 할 것인지를 결정한다.
		// * 3번째 파라미터 handler는 현재 실행하려는 메소드 자체를 의미한다. 이를 활용하면 현재 실행되는 컨트롤러를 파악하거나, 
		//   추가적인 메소드를 실행하는 등의 작업이 가능하다. 
		System.out.println("pre handle ................");
		
		HandlerMethod method = (HandlerMethod)handler;
		Method methodObj = method.getMethod();
		
		System.out.println("Bean: " + method.getBean());
		System.out.println("Method: " + methodObj);
		
		return super.preHandle(request, response, handler);
	}
}
