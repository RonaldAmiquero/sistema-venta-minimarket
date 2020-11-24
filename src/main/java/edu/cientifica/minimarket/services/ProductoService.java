package edu.cientifica.minimarket.services;

import java.util.List;

import edu.cientifica.minimarket.model.Producto;
import edu.cientifica.minimarket.model.ProductoProveedor;

public interface ProductoService {
	public int registrarProducto(Producto producto);
	public List<Producto> listarProducto();
	public int asignarId();
	public Producto buscarProductoId(int idProducto);
	public Producto buscarCodBarras(String codBarras);
	public int actualizarProducto(Producto producto);
	public ProductoProveedor buscarIdProveedor(int idProducto);
	
}
