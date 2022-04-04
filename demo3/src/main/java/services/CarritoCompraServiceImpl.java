package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import model.Articulo;

public class CarritoCompraServiceImpl implements CarritoCompraService {

	@Autowired
	private BaseDatos baseDatos;

	private List<Articulo> cesta = new ArrayList<>();

	@Override
	public void limpiarCestar() {
		cesta.clear();
	}

	@Override
	public void addArticulo(Articulo articulo) {
		cesta.add(articulo);
	}

	@Override
	public Integer getNumArticulos() {
		return cesta.size();
	}

	@Override
	public List<Articulo> getArticulos() {
		return cesta;
	}

	@Override
	public Double totalPrice() {
		Double total = 0D;
		for (Articulo articulo : cesta) {
			total += articulo.getPrecio();
		}
		return total;
	}

	@Override
	public Double calculadorDescuento(Double precio, Double porcentaje) {
		return precio - precio * porcentaje / 100;
	}

	@Override
	public Double aplicarDescuento(Integer idArticulo, Double porcentaje) {
		baseDatos.iniciar();
		Articulo articulo = baseDatos.buscarArticulo(idArticulo);
		if (Optional.ofNullable(articulo).isPresent()) {
			return calculadorDescuento(articulo.getPrecio(), porcentaje);
		} else {
			System.out.println("No se han encontrado el articulo con ID: " + idArticulo);
		}

		return 0D;
	}

	@Override
	public Integer insertar(Articulo articulo) {
		Integer nuevoId = baseDatos.insertarArticulo(articulo);
		cesta.add(articulo);
		return nuevoId;
	}
	
	

}
