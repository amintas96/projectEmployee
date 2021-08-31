package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();
        List<Employee> listEmployee = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            System.out.println("Emplyoee #" + (i + 1) + ":");
            System.out.print("ID: ");
            Integer id = sc.nextInt();
            while (hasId(listEmployee, id)) { //equanto for diferente de nullo, refaz o loop.
                System.out.println("Id already taken! Try again: ");
                id = sc.nextInt();

            }
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary:");
            Double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);

            listEmployee.add(emp);

            System.out.println();

        }
        System.out.print("Enter the employee id that will have salary increase :");
        int incrimentId = sc.nextInt();

        Employee emp = listEmployee.stream().filter(x -> x.getId() == incrimentId).findFirst().orElse(null);

        if (emp == null) {

            System.out.println("This id does not exist!");
            System.out.println();

        }else{
            System.out.print("Enter the percentage:");
            double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);

        }

        System.out.println("List of employees:");



        for(Employee e : listEmployee){
            System.out.println(e);
        }
        sc.close();
    }


    public static boolean hasId(List<Employee> List, int id) {
        Employee emp = List.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}

