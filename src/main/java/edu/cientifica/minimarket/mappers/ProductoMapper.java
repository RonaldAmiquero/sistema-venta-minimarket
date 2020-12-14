package edu.cientifica.minimarket.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.cientifica.minimarket.model.Producto;
import edu.cientifica.minimarket.model.ProductoProveedor;

@Mapper
public interface ProductoMapper {
	
	@Insert("INSERT INTO productos (id_producto, codigo_barra, nombre, costo_unitario, precio_venta, stock_producto, fecha_vencimiento, id_categoria) "
			+ "VALUES (#{idProducto}, #{codigoBarras}, #{nombre}, #{costoUnitario}, #{precioVenta}, #{stockProducto}, #{fechaVencimiento}, #{categoria.idCategoria})")
	public int addProducto(Producto producto);
	
	@Select("SELECT IFNULL(max(id_producto), 0)+1 as codigo from productos")
	@ResultType(Integer.class)
	public int findId();
	
	@Insert("INSERT INTO proveedores_productos (id_producto, id_proveedor) VALUES (#{idProducto}, #{proveedor.id})")
	public int addTabProductoProveedor(Producto producto);
	
	@Select("SELECT * FROM productos WHERE id_producto = #{idProducto}")
	@ResultMap("edu.cientifica.minimarket.mappers.ProductoMapper.productoResultMap")
	public Producto findProductId(int idProducto);
	
	@Select("SELECT * FROM productos WHERE codigo_barra = #{codBarras}")
	@ResultMap("edu.cientifica.minimarket.mappers.ProductoMapper.productoResultMap")
	public Producto findProductCodBarras(String codBarras);
	
	@Update("UPDATE productos SET codigo_barra= #{codigoBarras}, nombre= #{nombre}, costo_unitario= #{costoUnitario}, "
			+"precio_venta= #{precioVenta}, stock_producto= #{stockProducto}, fecha_vencimiento= #{fechaVencimiento}, id_categoria= #{categoria.idCategoria} WHERE id_producto= #{idProducto}")
	public int updateProducto(Producto producto);
	
	@Select("SELECT * FROM productos")
	@ResultMap("edu.cientifica.minimarket.mappers.ProductoMapper.productoResultMap")
	public List<Producto> findAllProducts();
	
	@Select("SELECT * FROM proveedores_productos where id_producto = #{idProducto}")
	@ResultMap("edu.cientifica.minimarket.mappers.ProductoProveedorMapper.productoProveedorResultMap")
	public ProductoProveedor findIdProveedor(int idProducto);
}
