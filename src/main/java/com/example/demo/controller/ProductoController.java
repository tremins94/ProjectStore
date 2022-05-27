package com.example.demo.controller;


import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;


    @GetMapping("")
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    @GetMapping("/{id_producto}")
    public Optional<Producto> getProductoById(@PathVariable(value = "id_producto") int id_producto) {
        return productoRepository.findById(id_producto);
    }

    @PostMapping("")
    public  Producto saveProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id_producto}")
    public void deleteProducto(@PathVariable(value = "id_producto") int id_producto){
        productoRepository.deleteById(id_producto);
    }


}
