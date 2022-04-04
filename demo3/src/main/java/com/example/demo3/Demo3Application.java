package com.example.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import model.Articulo;
import services.BaseDatos;

@SpringBootApplication
public class Demo3Application implements CommandLineRunner{

	 @Autowired
	    private BaseDatos baseDatosService;
	
	
	 public static void main(String[] args) {
	        SpringApplication.run(Demo3Application.class, args);
	    }
	
	@Override
	public void run(String... args) throws Exception {
		baseDatosService.iniciar();
        Articulo articulo = new Articulo("Calcetines", 5.95);
        baseDatosService.insertarArticulo(articulo);
        baseDatosService.buscarArticulo(baseDatosService.lastIndex());
		
	}

	
	

}
