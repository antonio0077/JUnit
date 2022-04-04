package services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import model.Articulo;

@RunWith(MockitoJUnitRunner.class)
public class CarritoCompraServiceImplTest2 {

	@InjectMocks
	private CarritoCompraServiceImpl carritoService = new CarritoCompraServiceImpl();

	@Mock
	private BaseDatos baseDatos;

	@Test
	public void testLimpiarCestar() {
		carritoService.addArticulo(new Articulo("Camiseta", 15.99));
		assertFalse(carritoService.getArticulos().isEmpty());
		carritoService.limpiarCestar();
		assertTrue(carritoService.getArticulos().isEmpty());
	}

	@Test
	public void testAddArticulo() {
		carritoService.addArticulo(new Articulo("Camiseta", 15.99));
		assertFalse(carritoService.getArticulos().isEmpty());
		assertTrue(carritoService.getArticulos().size() == 1);
	}

	@Test
	public void testGetNumArticulos() {
		assertFalse(carritoService.getArticulos().size() == -1);
		assertTrue(carritoService.getArticulos().size() == 0);
	}

	@Test
	public void testGetArticulos() {
		List<Articulo> articulos = carritoService.getArticulos();
		assertFalse(articulos != carritoService.getArticulos());
		assertTrue(articulos == carritoService.getArticulos());
	}

	@Test
	public void testTotalPrice() {
		carritoService.addArticulo(new Articulo("Camiseta", 15.99));
		assertFalse(carritoService.totalPrice() == 0);
		assertTrue(carritoService.totalPrice() == 15.99);
	}

	@Test
	public void testCalculadorDescuento() {
		assertEquals(Double.valueOf(90D), carritoService.calculadorDescuento(100D, 10D));
	}

	@Test
	public void testAplicarDescuento() {
		Articulo articulo = new Articulo("Camiseta", 20.00);
		when(baseDatos.buscarArticulo(1)).thenReturn(articulo);
		Double res = carritoService.aplicarDescuento(1, 10D);
		assertEquals(Double.valueOf(18D), res);
		verify(baseDatos, atLeast(1)).buscarArticulo(1);
	}

	@Test
	public void testInsertarArticulo() {

		Articulo articulo = new Articulo("Zapatilla", 190.9D);
		int id = 1;

		when(baseDatos.insertarArticulo(articulo)).thenReturn(8);
		id = carritoService.insertar(articulo);

		assertEquals(8, id);
		assertTrue(carritoService.getArticulos().contains(articulo));
		verify(baseDatos, atLeast(1)).insertarArticulo(any(Articulo.class));
	}

}
