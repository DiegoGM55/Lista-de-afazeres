/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.ListaTreino.Controller;

import ch.qos.logback.core.model.Model;
import com.project.ListaTreino.Models.Treino;
import com.project.ListaTreino.Repository.TreinoRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author augus
 */
@Controller
public class TreinoController {
    
    @Autowired
    private TreinoRepository tr;
    
    
    
    
    @RequestMapping("/treinos")
    public ModelAndView listaTreinos() {
        ModelAndView mv = new ModelAndView("index");
        Iterable<Treino> treinos = tr.findAll();
        mv.addObject("treinos", treinos);

        return mv;
    }
    
    
    @RequestMapping("/cadastrarTreino") 
    public String formTreino() {
        return "formTreino";
    }
    
    @PostMapping("/cadastrarTreino")
    public String formTreino(@Valid Treino treino,
            BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute(
                    "mensagem", "Verifique os campos!");
            return "redirect:/cadastrarTreino";
        }
        tr.save(treino);
        return "redirect:/treinos";
    }
    
}
