package edu.cientifica.minimarket.services;

import edu.cientifica.minimarket.model.DetalleEntradaProducto;
import edu.cientifica.minimarket.model.EntradaProducto;

public interface EntradaProductoService {

	public int asignarIdEp();

	public int guardarEntradaProducto(EntradaProducto entradap);

	public int guardarDetalleEntradaProducto(DetalleEntradaProducto detalleEP);
	

}
