package com.example.demo.controller;


import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/categoria")

public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("")
    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }


    @GetMapping("/{id_categoria}")
    public Optional<Categoria> getCategoriaById(@PathVariable(value = "id_categoria") int id_categoria) {


        return categoriaRepository.findById(id_categoria);

    }

    @PostMapping("")
    public Categoria saveCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @DeleteMapping("/{id_categoria}")
    public void deleteCategoria(@PathVariable(value = "id_categoria") int id_categoria) {
        categoriaRepository.deleteById(id_categoria);
    }

    @PutMapping("/{id_categoria}")
    public Categoria updateCategoria(@RequestBody Categoria categoria, @PathVariable(value = "id_categoria") int id_categoria) {

        Categoria categoria1 = new Categoria();
        categoria1 = categoriaRepository.getOne(id_categoria);
        categoria1.setNombreCategoria(categoria.getNombreCategoria());
        categoria1.setDescripcionCategoria(categoria.getDescripcionCategoria());
        categoria1.setSubCategoria(categoria.getSubCategoria());

        return categoriaRepository.save(categoria1);
    }

  @GetMapping("/byName")
       public Optional<Categoria> getCategoriaByName(@RequestParam(value = "nombreCategoria") String nombreCategoria){

        return categoriaRepository.findByNombreCategoria(nombreCategoria);
       }





}


