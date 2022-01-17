#Urls del proyecto

Listar productos
```
  GET
  http://localhost:9090/products
```
Obtener por ID
```
  GET
  http://localhost:9090/products/{id}
```
Guardar
```
  POST
  http://localhost:9090/products
  {
    "name": "Producto de prueba",
    "price": 20000,
    "description": "Descripcion de prueba"
  }
```
Actualizar
```
  PUT
  http://localhost:9090/products/{id}
  {
    "name": "Producto final",
    "price": 30000,
    "description": "Descripcion final"
  }
```
Eliminar
```
  DELETE
  http://localhost:9090/products/{id}
```

El archivo de postman está en la raíz del proyecto.
```
  ./RestApiConsumeSoap.postman_collection.json
```
