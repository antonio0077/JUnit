package services;

import java.util.HashMap;
import java.util.Map;

import model.Articulo;

public class BaseDatosImpl implements BaseDatos {

	private Map<Integer, Articulo> baseDatos;
	
	
	@Override
	public void iniciar() {
		baseDatos = new HashMap<>();
		baseDatos.put(1, new Articulo("Camiseta", 20.00));
		baseDatos.put(1, new Articulo("Pantalon", 10.00));
		baseDatos.put(1, new Articulo("Chaqueta", 30.00));
		baseDatos.put(1, new Articulo("Jersey", 35.00));
	}

	@Override
	public Integer insertarArticulo(Articulo articulo) {
		baseDatos.put(baseDatos.size()+1, articulo);
		return baseDatos.size();
	}

	@Override
	public Articulo buscarArticulo(Integer identificador) {
		return baseDatos.get(identificador);
	}

	@Override
	public Integer lastIndex(){
	return baseDatos.size();
	}

	
	
}
