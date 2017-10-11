package com.bsd.pixelware.spring.config.db;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.*;

/**
 * Clase asociada al perfil "hsql" para configuracion del origen
 * de datos de la aplicacion .
 * 
 * Basicamente es indicar donde se ecuentran los ficheros de trbaajp con la BBDD
 * y su ejecucion
 *
 */

@Profile("hsql")
@Configuration
public class DerbyDataSource {
	/**
	 * data source eblaxad a la BBDD con la cadena de conexion => jdbc:hsqldb:mem:testdb
	 */
	@Bean
	public DataSource dataSource(){
	EmbeddedDatabaseBuilder builder  =  new EmbeddedDatabaseBuilder();
	
	EmbeddedDatabase database = builder.setType(EmbeddedDatabaseType.HSQL).addScript("db/sql/create-db.sql").
			addScript("db/sql/insert-data.sql")
			.build();
	return database;
	}
	
}
