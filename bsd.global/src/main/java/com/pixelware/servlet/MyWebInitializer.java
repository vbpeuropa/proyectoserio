package com.pixelware.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.pixelware.config.SpringRootConfig;
import com.pixelware.config.SpringWebConfig;

public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{SpringRootConfig.class};
		
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{SpringWebConfig.class};
		
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}

	/**Se ejetua cuando la aplicacion cimenza y
	 * lo vamos a utilizar para pner el perfil activo para hsql
	 * inicialmente
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		servletContext.setInitParameter("spring.profiles.active", "hsql");//los profiels metidos anteriormente
	}

}
