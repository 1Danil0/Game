package com.danilermolenko.spring.game.controllers;


import com.danilermolenko.spring.game.dto.CreatureDTO;
import com.danilermolenko.spring.game.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/game")
public class Controller1 {
    private  final Service service;
    @Autowired
    public Controller1(Service service) {
        this.service = service;
    }

    @GetMapping("/123")
    public String hello(){
        return "page";
    }

    @GetMapping("/")
    public String game(){
        return "first-page";
    }

    @GetMapping("/create")
    public String player(Model model){
        if(service.findPlayer() != null){
            model.addAttribute("text", "Enter details of Monster");
        } else {
            model.addAttribute("text", "Enter details of your hero");
        }
        model.addAttribute("player", service.findPlayer());
        return "create-page";
    }
    @PostMapping("/count")
    public String monster(Model model){
        model.addAttribute("text", "Enter details of Monster");
        return "create-page";
    }
    @PostMapping("/create")
    public String save(CreatureDTO creature, @RequestParam("count") int count){
        service.createCreature(creature);
        do{
            count--;
            return "redirect:create";
        } while (count > 0);
    }
    @GetMapping("/battling")
    public String battle(Model model){
        model.addAttribute("player", service.findPlayer());
        model.addAttribute("monsters", service.findMonsters());
        return "battling-page";
    }
    @PostMapping("/hit/{id}")
    public String hit(@PathVariable("id") int id){
        service.hit(id);
        return "redirect:battling";
    }
    @PostMapping("/cure")
    public String cure(){
        service.findPlayer().cure();
        return "redirect:battling";
    }
}
