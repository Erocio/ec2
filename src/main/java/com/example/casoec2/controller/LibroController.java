/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.casoec2.controller;

import com.example.casoec2.entity.Libro;
import com.example.casoec2.repository.AutorMyBatisRepository;
import com.example.casoec2.repository.EditorialMyBatisRepository;
import com.example.casoec2.repository.LibroMyBatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Juan
 */
@Controller
public class LibroController {
    
     @Autowired
    private LibroMyBatisRepository libroMyBatisRepository;

    @Autowired
    private AutorMyBatisRepository autorMyBatisRepository;

    @Autowired
    private EditorialMyBatisRepository editorialMyBatisRepository;

    

    @RequestMapping("/libs")
    public String libs(Model model) {
        model.addAttribute("libs", libroMyBatisRepository.findAll());
        return "libs";
    }

    @RequestMapping("/create")
    public String createauto(Model model) {
        model.addAttribute("autos", autorMyBatisRepository.findAll());
        model.addAttribute("edits", editorialMyBatisRepository.findAll());
        return "addLibro";
    }

    @RequestMapping("/libroadd")
    public String guardarlibro(@RequestParam String nombre, @RequestParam int idautor, @RequestParam int ideditorial, Model model) {
        Libro lib = new Libro();
        lib.setNombre(nombre);
        lib.setIdautor(idautor);
        lib.setIdeditorial(ideditorial);
        libroMyBatisRepository.insert(lib);
        return "redirect:/libs";
    }

    @RequestMapping("/dellibro/{id}")
    public String deletelibro(@PathVariable(value = "id") int id) {

        libroMyBatisRepository.deleteById(id);
        return "redirect:/libs";
    }

    @RequestMapping("/editlibro/{id}")
    public String edit(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("lib", libroMyBatisRepository.readLibro(id));
        model.addAttribute("autos", autorMyBatisRepository.findAll());
        model.addAttribute("edits", editorialMyBatisRepository.findAll());

        return "editlibro";
    }

    @RequestMapping("/update")
    public String update(@RequestParam int id, @RequestParam String nombre,
            @RequestParam int idautor, @RequestParam int ideditorial) {
        System.out.println(id + "/" + nombre + "/" + idautor + "/" + ideditorial);
        Libro lib = libroMyBatisRepository.readLibro(id);
        lib.setNombre(nombre);
        lib.setIdautor(idautor);
        lib.setIdeditorial(ideditorial);
        libroMyBatisRepository.update(lib);
        return "redirect:/libs";
    }
}