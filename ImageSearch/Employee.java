package proj1;
public class Employee implements Comparable<Employee>{
    private int experience; // number of years an employee is with the company
    private String firstName;
    private String lastName;
    enum DegreeType {None, Associate, Bachelors, Masters, Doctorate};
    private DegreeType degree;
    
    public Employee(){
        firstName = "Stan";
        lastName = "Dupp";
        experience = 0;
        degree = DegreeType.None;
                
    } // end const
    
    public Employee(DegreeType degree, String firstName, String lastName, int experience ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.experience = experience;
        this.degree = degree;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public DegreeType getDegree() {
        return degree;
    }

    public void setDegree(DegreeType degree) {
        this.degree = degree;
    }
    
    @Override
    public String toString(){
        String sentence = getFirstName() +" "+ getLastName() + " has been with the company for " + getExperience() 
                 + " years and has a degree level of " + getDegree(); 
        return sentence;
    }
    
    // Value Points are used by this company to estimate an employee's value.
    // It is solely based on their experience and their degree type. 
    
    // Checks if this employee's value points are equal to another employee
    @Override
    public boolean equals(Object other){
        boolean result = false;
        if(other instanceof Employee){
            Employee otherEmployee = (Employee) other;
            int valuePoints = getExperience() * (getDegree().ordinal()+1); 
            int valuePointsOther = otherEmployee.getExperience() * (otherEmployee.getDegree().ordinal()+1) ;
            if(valuePoints == valuePointsOther){
                result = true;
            }
        }
        return result;
    }
    
    // Prints -1 if this employee's value points are less than the value points of another employee.
    // Prints 0 if this employee's value points are equal to the value points of another employee.
    // Prints 1 if this employee's value points are greater than the value points of another employee.
    @Override
    public int compareTo(Employee otherEmployee){
        int state;
        int valuePoints = getExperience() * (getDegree().ordinal()+1); 
        int valuePointsOther = otherEmployee.getExperience() * (otherEmployee.getDegree().ordinal()+1);
        if(valuePoints < valuePointsOther){
            state = -1;
        }else if(equals(otherEmployee)){
            state = 0;
        }else {
            state = 1;
        }
        
        return state; 
    }
    
}
