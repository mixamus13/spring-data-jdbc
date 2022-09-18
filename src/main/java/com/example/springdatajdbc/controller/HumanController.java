package com.example.springdatajdbc.controller;

import com.example.springdatajdbc.model.Human;
import com.example.springdatajdbc.service.HumanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class HumanController {

    private final HumanService humanService;

    @GetMapping("/api/humanAll")
    public List<Human> getAllHuman() {
        return humanService.getAllHuman();
    }

    @GetMapping("/api/humanBuId/{id}")
    public Optional<Human> getHumanById(@PathVariable("id") long id) {
        return humanService.getHumanById(id);
    }

    @PostMapping("/api/humanCreate")
    public void createHuman(@RequestBody Human human) {
        humanService.createHuman(human);
    }

    @DeleteMapping("/api/humanDelete/{id}")
    public void deleteHuman(@PathVariable("id") int id) {
        humanService.deleteHuman(id);
    }

    @PutMapping("/api/humanUpdate/{id}")
    public void updateHuman(@RequestBody Human human, @PathVariable("id") long id) {
        humanService.updateHuman(human, id);
    }
}
