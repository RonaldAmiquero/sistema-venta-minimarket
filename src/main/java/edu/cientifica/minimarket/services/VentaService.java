package edu.cientifica.minimarket.services;

import java.sql.Date;
import java.util.List;

import edu.cientifica.minimarket.model.DetalleVenta;
import edu.cientifica.minimarket.model.Venta;

public interface VentaService {	
	
	public int asignarIdVenta();

	public int registrarDetalleVenta(DetalleVenta detalleVenta);

	public int guardarVenta(Venta venta);

	public List<Venta> listarVentas();
	
	public List<Venta> buscarVenta(Date fechaInicio, Date fechaFin);
	
}
