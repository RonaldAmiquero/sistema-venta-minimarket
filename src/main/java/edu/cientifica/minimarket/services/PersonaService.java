package edu.cientifica.minimarket.services;


import edu.cientifica.minimarket.model.Persona;
import edu.cientifica.minimarket.model.Proveedor;

public interface PersonaService {

	int registrarPersona(Proveedor proveedor);
	public Persona buscarPersonarId(int id);
	int actualizarPersona(Proveedor proveedor);

}
