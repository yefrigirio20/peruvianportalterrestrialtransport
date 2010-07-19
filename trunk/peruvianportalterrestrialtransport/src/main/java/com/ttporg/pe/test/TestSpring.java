package com.ttporg.pe.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
/**
 *
 * @author Lennon Shimokawa
 **/
public class TestSpring{
	
	
	public static void main( String[] args ){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext( "classpath*:/applicationContext.xml" );  
		
		//CollectionsBean example = (CollectionsBean) ctx.getBean("collectionsExample");
		//System.out.println( "CollectionsBean: " + example );
		
		//System.out.println( "Lista Departamento: " + example.getTheList() );
		
		//Departamento departamento = new Departamento();
		//departamento.setNombre( "LIMA" );
		
		Object departamento = (Object)ctx.getBean( "transaccion" );
		System.out.println( "transaccion: " + departamento );
	}
     
}
