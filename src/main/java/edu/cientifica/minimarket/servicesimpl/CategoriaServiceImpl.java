package edu.cientifica.minimarket.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cientifica.minimarket.mappers.CategoriaMapper;
import edu.cientifica.minimarket.model.Categoria;
import edu.cientifica.minimarket.services.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	CategoriaMapper categoriaMapper;

	@Override
	public List<Categoria> listarCategoria() {
		
		return categoriaMapper.finAllCategory();
	}
	
}
