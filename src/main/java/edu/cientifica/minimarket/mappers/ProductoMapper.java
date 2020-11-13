package edu.cientifica.minimarket.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import edu.cientifica.minimarket.model.Producto;

@Mapper
public interface ProductoMapper {
	
	@Insert("INSERT INTO productos (id_producto, codigo_barra, nombre, costo_unitario, precio_venta, stock_producto, fecha_vencimiento, id_categoria) "
			+ "VALUES (#{idProducto}, #{codigoBarras}, #{nombre}, #{costoUnitario}, #{precioVenta}, #{stockProducto}, #{fechaVencimiento}, #{categoria.idCategoria})")
	public int addProducto(Producto producto);
	
	@Select("select max(id_producto) + 1 as codigo from productos")
	@ResultType(Integer.class)
	public int findId();
	
	@Insert("INSERT INTO proveedores_productos (id_producto, id_proveedor) VALUES (#{idProducto}, #{proveedor.id})")
	public int addTabProductoProveedor(Producto producto);
	
	@Select("SELECT * FROM productos WHERE id_producto = #{idProducto}")
	@ResultType(Producto.class)
	public Producto findProductId(int idProducto);
	
	@Select("SELECT * FROM productos WHERE codigo_barra = #{codBarras}")
	@ResultMap("edu.cientifica.minimarket.mappers.Producto.productoResultMap")
	public Producto findProductCodBarras(String codBarras);

}
