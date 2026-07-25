public class CoffeeService {

    private final List<Coffee> coffees = new ArrayList<>();
    private long nextId = 0; // TODO: คิดว่าตัวแปรนี้ใช้ทำอะไร ใช้ยังไง

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
        // ถ้าเจอ ให้เปลี่ยน name/price ของตัวเดิม แล้ว return Optional ของมัน
        // ถ้าไม่เจอ return Optional.empty()
        
    }

    public boolean delete(Long id) {
        if Long id == id:
        // TODO: ลบออกจาก list ถ้าเจอ id ที่ตรงกัน
        // ใบ้: List มี method removeIf(...) ที่คืนค่า boolean ให้อยู่แล้วว่าลบสำเร็จไหม
    }

}
