# Programacion Reactiva

## Repository
Se usa ReactiveCrudRepository. Para crear querys especificas funciona igual que JPA
```java
Flux<Producto> findBynombreContainingIgnoreCase(String nombre);
```
## Clases Principales
Se utiliza Flex para retornar una lista y Mono para cualquier objeto

## Metodo de ejemplo 
```java
public Flux<ProductoDtoResponse> buscarProductoPorNombre(String nombre){
        return productoRepository.findBynombreContainingIgnoreCase(nombre).flatMap(producto ->
                categoriaRepository.findById(producto.getCategoriaId())
                        .map(categoria -> ProductoDtoResponse.builder()
                                .id(producto.getId())
                                .nombre(producto.getNombre())
                                .descripcion(producto.getDescripcion())
                                .precio(producto.getPrecio())
                                .categoriaDtoResponse(
                                        new CategoriaDtoResponse(
                                                categoria.getId(),
                                                categoria.getNombreCategoria()
                                        )
                                )
                                .stockActual(producto.getStockActual())
                                .build())
        );

    }
```
La clave es:
```
flatMap → porque haces otra consulta reactiva
map → porque transformas el resultado final a DTO
```

