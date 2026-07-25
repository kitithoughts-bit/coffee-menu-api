package com.example.coffeemenu.service;

import com.example.coffeemenu.model.Coffee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CoffeeService {

    private final List<Coffee> coffees = new ArrayList<>();
    private long nextId = 1; // TODO: คิดว่าตัวแปรนี้ใช้ทำอะไร ใช้ยังไง

    public CoffeeService() {
        // TODO: เรียก add() เพิ่มกาแฟ 2 แก้วไว้ล่วงหน้า
        // เช่น add(new Coffee(null, "Espresso", 45.0));
        add(new Coffee(null, "Espresso", 45.0));
        add(new Coffee(null, "Matcha", 45.0));

    }

    public List<Coffee> getAll() {
        // TODO: ง่ายสุด แค่ return list
        return coffees;
    }

    public Optional<Coffee> getById(Long id) {
        // TODO: หา coffee ที่ id ตรงกับที่ส่งมา
        // ใบ้: ใช้ coffees.stream().filter(...).findFirst()
        return coffees.stream()
        .filter(coffee -> coffee.getId().equals(id))
        .findFirst();
    }

    public Coffee add(Coffee newCoffee) {
        // TODO: 1. gen id ใหม่ให้ newCoffee (ใช้ setId)
        newCoffee.setId(nextId++);
        // TODO: 2. เพิ่มเข้า list
        coffees.add(newCoffee);
        // TODO: 3. return newCoffee กลับไป
        return newCoffee;
    }

    public Optional<Coffee> update(Long id, Coffee updatedData) {
        // TODO: หา coffee เดิมด้วย id ก่อน
        // 1. เรียกใช้เมธอด getById ที่เราเคยเขียนไว้ มาเก็บในตัวแปร
        Optional<Coffee> coffeeOpt = getById(id);

        // 2. เช็กว่าเจอข้อมูลไหม
        if (coffeeOpt.isPresent()) {
            // ดึงวัตถุ Coffee ออกมาจาก Optional ด้วย .get()
            Coffee coffee = coffeeOpt.get();

            // เอาค่า name และ price จาก updatedData มาเซ็ตทับตัวเดิม
            coffee.setName(updatedData.getName());
            coffee.setPrice(updatedData.getPrice());

            // ส่ง Optional ของกาแฟที่อัปเดตแล้วกลับไป
            return coffeeOpt;
        }

        // 3. ถ้าหาไม่เจอ ให้คืนค่า Optional เปล่า
        return Optional.empty();
    }


    public boolean delete(Long id) {
        // TODO: ลบออกจาก list ถ้าเจอ id ที่ตรงกัน
        // ใบ้: List มี method removeIf(...) ที่คืนค่า boolean ให้อยู่แล้วว่าลบสำเร็จไหม
        return coffees.removeIf(coffee -> coffee.getId().equals(id));

    }

}
