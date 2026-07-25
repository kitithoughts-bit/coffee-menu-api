package com.example.miniproj.controller;

import com.example.miniproj.model.Coffee;
import com.example.miniproj.service.CoffeeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService){
        this.coffeeService = coffeeService;
    }

    @GetMapping
    public List<Coffee> getAllCoffee(){
        return coffeeService.getAll(); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coffee> getCoffeeById(@PathVariable Long id){
        Optional<Coffee> result = coffeeService.getById(id);

        return result.map(coffee -> ResponseEntity.ok(coffee))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Coffee addCoffee(@RequestBody Coffee newCoffee){
        return coffeeService.add(newCoffee);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Coffee> updateCoffee(@PathVariable Long id, @RequestBody Coffee updatedCoffee){
        Optional<Coffee> result = coffeeService.update(id, updatedCoffee);

        return result.map(coffee -> ResponseEntity.ok(coffee))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoffee(@PathVariable Long id){
        boolean result = coffeeService.delete(id);

        return result ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
