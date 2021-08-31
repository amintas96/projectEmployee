package entities;

public class Employee {

    private Integer id;
    private String name;
    private Double salary;

    public Employee(Integer id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public Employee(){};

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void increaseSalary(double percentage){

        this.salary += this.salary * percentage / 100;
    }

    @Override
    public String toString() {

    return id + ", " + name + ", " + String.format("%.2f", salary);
    }
}
