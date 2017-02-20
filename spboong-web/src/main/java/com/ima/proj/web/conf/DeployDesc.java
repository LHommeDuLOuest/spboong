/**
 * This file replace Deployment Descriptor web.xml for Servlet x3.
 */

package com.ima.proj.web.conf;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * @author LYES K ⴿⴻⵔⴱⵉⵛ
 *
 */
public class DeployDesc extends AbstractAnnotationConfigDispatcherServletInitializer{

	
	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
		
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(DispatcherConf.class);
        ServletRegistration.Dynamic spboongServlet = servletContext.addServlet("spboongServlet", new DispatcherServlet(rootContext));
        spboongServlet.setLoadOnStartup(1);
        spboongServlet.addMapping("/");
        servletContext.addListener(new ContextLoaderListener(rootContext));
        servletContext.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"))
            .addMappingForUrlPatterns(null, false, "/*");
    }
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {DispatcherConf.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	/*@Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter utf8Filter = new CharacterEncodingFilter();
        utf8Filter.setEncoding("UTF-8");
        utf8Filter.setForceEncoding(true);

        return new Filter[] { utf8Filter };
	}*/
	
	//spring 4 mvc dispatcher servlet config
}
