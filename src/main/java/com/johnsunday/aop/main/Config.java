package com.johnsunday.aop.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// Indicamos que es un archivo de configuración.
@Configuration
//Indicamos dónde debe la app buscar los aspectos.
@ComponentScan("com.johnsunday.aop")
// Habilitamos la Programación Orientada a Aspectos. 
@EnableAspectJAutoProxy
public class Config {

	
}
