package services;

import java.util.List;

import model.Articulo;

public interface CarritoCompraService {

	public void limpiarCestar();
	
	public void addArticulo(Articulo articulo);
	
	public Integer getNumArticulos();
	
	public List<Articulo> getArticulos();
	
	public Double totalPrice();
	
	public Double calculadorDescuento(Double precio, Double porcentaje);
	
	public Double aplicarDescuento(Integer idArticulo, Double porcentaje);

	public Integer insertar(Articulo articulo);
}
