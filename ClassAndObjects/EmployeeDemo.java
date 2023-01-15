package proj1;
public class EmployeeDemo {
    public static void main(String[] args){
        Employee currentEmployee = new Employee();
        Employee otherEmployee = new Employee(Employee.DegreeType.Bachelors, "Hedda", "Hare", 5);
        Employee experiencedEmployee = new Employee(Employee.DegreeType.Masters, "Jerry", "Attrick", 10);
        Employee newEmployee = new Employee(Employee.DegreeType.Doctorate, "Max", "Milly", 3 );
        
        System.out.println("A brief bio about the employees in our company");
        System.out.println(currentEmployee.toString());
        System.out.println(otherEmployee.toString());
        System.out.println(experiencedEmployee.toString());
        System.out.println(newEmployee.toString()); 
        
        System.out.println("\nList of the valuePoints of our employees");
        System.out.println("Stan : " + currentEmployee.getExperience() * (currentEmployee.getDegree().ordinal()+1));
        System.out.println("Hedda : " + otherEmployee.getExperience() * (otherEmployee.getDegree().ordinal()+1));
        System.out.println("Jerry : " + experiencedEmployee.getExperience() * (experiencedEmployee.getDegree().ordinal()+1));
        System.out.println("Max : " + newEmployee.getExperience() * (newEmployee.getDegree().ordinal()+1));
        
        System.out.println("\nAre some of our employees equal to each other? (Are their valuePoints equal?)");
        System.out.print("Comparing Stan and Jerry: ");
        System.out.println(currentEmployee.equals(experiencedEmployee));
        System.out.print("Comparing Hedda and Max: ");
        System.out.println(otherEmployee.equals(newEmployee));
        
        System.out.println("\nComparing an employee with another:");
        System.out.print("Comparing Max with Jerry: ");
        System.out.println(newEmployee.compareTo(experiencedEmployee));
        System.out.print("Comparing Hedda with Max: ");
        System.out.println(otherEmployee.compareTo(newEmployee));   
        System.out.print("Comparing Max with Stan: ");
        System.out.println(newEmployee.compareTo(currentEmployee));   
        
        
    }
}
