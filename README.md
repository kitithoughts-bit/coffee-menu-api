# Coffee Menu API ☕

โปรเจกต์นี้เป็น RESTful API สำหรับการจัดการเมนูกาแฟ (Coffee Menu Service) โดยใช้หลักการ Layered Architecture (Model-Service-Controller) พัฒนาด้วย Java และ Spring Boot 

## 👥 สมาชิกในกลุ่ม (Sec. 1)
1. 673380509-6 กิติญาดา กองคำ
2. 673380513-5 นาเดีย คิดอ่าน

---

## 📄 รายงานผลการทดสอบ (Result & Discussion)
รูปภาพผลการทดสอบ API ทั้ง 5 Endpoints (Expected Result) และคำตอบ Discussion ได้ที่ไฟล์นี้:
[Result & Discussion](https://github.com/kitithoughts-bit/coffee-menu-api/blob/main/Lab05_Result%20%26%20%20Discussion%20.pdf)
---

## 🚀 วิธีการรันโปรเจกต์ (How to Run)

โปรเจกต์นี้ใช้ **Gradle** ในการจัดการ dependencies สามารถรันแอปพลิเคชันผ่าน Terminal/Command Prompt ได้ดังนี้:

**สำหรับ Windows (CMD/PowerShell):**
```bash
gradlew bootRun
```
*หรือคลิกปุ่ม Run บนคลาส `MiniprojApplication.java` ผ่าน VS Code ได้โดยตรง*

แอปพลิเคชันจะรันและเปิดพอร์ต `8080` (http://localhost:8080)

---

## 🛠️ API Endpoints & Curl Examples (ตัวอย่างการเรียก API)

นี่คือตัวอย่างคำสั่ง `curl` สำหรับทดสอบ API ครบทั้ง 5 Endpoints (รวมถึงการทดสอบ 404 Not Found)

### 1. ดูเมนูกาแฟทั้งหมด (GET All)
ดึงข้อมูลเมนูกาแฟทั้งหมดในระบบ
```bash
curl -i http://localhost:8080/coffees
```

### 2. ดูรายละเอียดเมนูกาแฟตาม ID (GET by ID)
ดึงข้อมูลเมนูกาแฟรายการที่ `id = 1`
```bash
curl -i http://localhost:8080/coffees/1
```

### 3. เพิ่มเมนูกาแฟใหม่ (POST)
เพิ่มเมนูกาแฟรายการใหม่ (เช่น Cappuccino ราคา 60.0) เข้าไปในระบบ
```bash
curl -i -X POST http://localhost:8080/coffees -H "Content-Type: application/json" -d "{\"name\":\"Cappuccino\",\"price\":60.0}"
```

### 4. แก้ไขข้อมูลเมนูกาแฟ (PUT)
อัปเดตข้อมูลเมนูกาแฟที่ `id = 2` (เช่น เปลี่ยนชื่อเป็น Latte และราคาเป็น 45.0)
```bash
curl -i -X PUT http://localhost:8080/coffees/2 -H "Content-Type: application/json" -d "{\"name\":\"Latte\",\"price\":45.0}"
```

### 5. ลบเมนูกาแฟ (DELETE)
ลบเมนูกาแฟที่ `id = 3` ออกจากระบบ
```bash
curl -i -X DELETE http://localhost:8080/coffees/3
```

### 🌟 Bonus Test: ลบเมนูกาแฟที่ไม่มีอยู่จริง (404 Not Found)
ทดสอบการจัดการ Error เมื่อพยายามลบเมนูที่ไม่มี ID นี้ในระบบ
```bash
curl -i -X DELETE http://localhost:8080/coffees/999
```

---

## 📂 โครงสร้างโปรเจกต์ (Layered Architecture)
* **Model (`Coffee.java`):** คลาสสำหรับเก็บโครงสร้างข้อมูลกาแฟ (`id`, `name`, `price`)
* **Service (`CoffeeService.java`):** ชั้นจัดการ Business Logic และจัดการข้อมูลใน Memory (ArrayList)
* **Controller (`CoffeeController.java`):** ชั้นจัดการ HTTP Request (GET, POST, PUT, DELETE) และส่ง Response กลับไปยัง Client
