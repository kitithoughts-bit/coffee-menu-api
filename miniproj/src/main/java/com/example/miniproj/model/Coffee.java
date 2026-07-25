public class Coffee {
    private Long id;
    private String name;
    private double price;

    public Coffee(){

    }

    public Coffee(Long id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

}
