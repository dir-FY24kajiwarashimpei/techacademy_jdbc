package dbSample.entity;

public class Country {
    //フィールド
    private String name;
    private int population;
    
    //引数なしのコンストラクタ
    public Country() {
        
    }
    
    //引数ありのコンストラクタ
    public Country(String name, int population) {
        this.name = name;
        this.population;
    }
    
    //getter/setter
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPopulation() {
        return population;
    }
    
    public void setPopulation(int population){
        this.population = population;
    }

}
