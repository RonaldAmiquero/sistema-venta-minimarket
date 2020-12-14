package edu.cientifica.minimarket.services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.cientifica.minimarket.model.Proveedor;

public interface ProveedorService {
	public int registrarProveedor(Proveedor proveedor);
	public List<Proveedor> listarProveedores();
	public int asignarId();
	public int actualizarProveedor(Proveedor proveedor);
	public Proveedor buscarProveedorId(int id);
	
	
	
}
