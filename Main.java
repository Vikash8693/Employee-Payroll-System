
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// first all we are creating a abstraction class in this projects
abstract class Employee{
    private  String name;
    private int id;

// make a constructor(parametrized constructor)
    public Employee(String name,int id){
        this.name =name;
        this.id =id;
    }
    // now we are using encapsulation
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    // abstract method in double type
    public abstract double calculateSalary();
    // now we are using polymorphism
    @Override
    public String toString() {
        return "Employee[name=" + name + ",id=" + id + ",salary=" + calculateSalary() + "]";

    }
}
class FullTimeEmployee extends Employee{
    private double monthlySalary;
// make a constructor;
    public FullTimeEmployee(String name,int Id, double monthlySalary){
        super(name,Id);
        this.monthlySalary=monthlySalary;
    }
    @Override
    public double calculateSalary(){

        return monthlySalary;
    }
}
class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name,int id,double hourlyRate,int hoursWorked){
        super(name,id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }
        @Override
    public double calculateSalary(){
        return hoursWorked * hourlyRate ;
        }
}
//4 class
class PayrollSystem{
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
            if(employee.getId()==id){
                employeeToRemove =employee;
                break;
            }
        }
        if(employeeToRemove!=null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployee(){
        for(Employee employee:employeeList){
            System.out.println(employee);
        }
    }
}
public class Main {
    public static void main(String[] args) {
     PayrollSystem payrollSystem=new PayrollSystem();
     FullTimeEmployee emp1=new FullTimeEmployee("vikash",1, 70000.0);
     PartTimeEmployee emp2=new PartTimeEmployee("Alxenda",2, 40, 30);

     payrollSystem.addEmployee(emp1);
     payrollSystem.addEmployee(emp2);
     System.out.println("intial Employee Details: ");
     payrollSystem.displayEmployee();
     System.out.println("removing employee");
     payrollSystem.removeEmployee(2);
     System.out.println("Remaining Employe details: ");
     payrollSystem.displayEmployee();


    }
}