package com.example.miniproj.service;

import com.example.miniproj.model.Coffee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CoffeeService {

    private final List<Coffee> coffees = new ArrayList<>();
    private long nextId = 1; 

    public CoffeeService() {
        add(new Coffee(null, "Espresso", 45.0));
        add(new Coffee(null, "Matcha", 45.0));

    }

    public List<Coffee> getAll() {
        return coffees;
    }

    public Optional<Coffee> getById(Long id) {
        return coffees.stream()
        .filter(coffee -> coffee.getId().equals(id))
        .findFirst();
    }

    public Coffee add(Coffee newCoffee) {
        newCoffee.setId(nextId++);
        coffees.add(newCoffee);

        return newCoffee;
    }

    public Optional<Coffee> update(Long id, Coffee updatedData) {
        Optional<Coffee> coffeeOpt = getById(id);

        if (coffeeOpt.isPresent()) {
            Coffee coffee = coffeeOpt.get();

            coffee.setName(updatedData.getName());
            coffee.setPrice(updatedData.getPrice());

            return coffeeOpt;
        }

        return Optional.empty();
    }


    public boolean delete(Long id) {
        return coffees.removeIf(coffee -> coffee.getId().equals(id));

    }

}
