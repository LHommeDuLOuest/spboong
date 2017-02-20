/**
 * This file replace the XML Spring Servlet Dispatcher 
 */

package com.ima.proj.web.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @author LYES K ⴿⴻⵔⴱⵉⵛ
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.ima.proj.web.ctrl"})
public class DispatcherConf extends WebMvcConfigurerAdapter {

}
