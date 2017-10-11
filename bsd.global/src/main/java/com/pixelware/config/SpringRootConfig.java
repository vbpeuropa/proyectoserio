package com.pixelware.config;

import javax.sql.DataSource;

import javax.annotation.PostConstruct;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Clase para configuracion  de los componentes de la aplicacion  buscando  en 
 * el resro de paquetes de la aplicacion
 */
@Configuration
@ComponentScan("{com.pixelware}")
public class SpringRootConfig {
	//Inyectamos dataSPurces con la BBDD de trabajo
	@Autowired
		private DataSource dataSource;
	/**
	 * Metodo qued evuelve el componente cin la plantillas asociada al datasoruce
	 * para trabajar con la BBDD
	 * @return
	 */
	@Bean
	public NamedParameterJdbcTemplate getTemplate(){
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
	/**
	 * AL temrinar de configurar la clase e instanciar un objeto
	 * de la isma , llamar a este metodo para mostrar aplicaicon
	 * de arranque de BBDD
	 */
		@PostConstruct
		public void startManagerDD(){
			//Para HSQL 
			DatabaseManagerSwing.main(new String[]{
				"--url","jdbc:hsqldb:mem:testdb",
				"--user","SA","--password"	,""
				});
			
		}
	/* H2
		@PostConstruct
		public void startManagerDD(){
			//Para HSQL 
			DatabaseManagerSwing.main(new String[]{
				"--url","jdbc:h2:mem:testdb",
				"--user","SA","--password"	,""
				});
			
		}
		*/
		
		/* DERBY
		@PostConstruct
		public void startManagerDD(){
			//Para HSQL 
			DatabaseManagerSwing.main(new String[]{
				"--url","jdbc:derby:memory:testdb",
				"--user","SA","--password"	,""
				});
			
		}
		*/
}
