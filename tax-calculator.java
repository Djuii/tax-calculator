package com.mycompany.assignmentq1;

/**
 *
 * @author nkomo
 */
public class AssignmentQ1 {
    String name;
    int number;
    double salary;
    final double [] Tax_Rates = {0.0, 0.1, 0.2, 0.25};
    final double [] Tax_Brackets =  {10000, 20000, 40000};
    
    public AssignmentQ1(String name, int number, double  salary){
        this.name = name;
        this.number = number;
        this.salary = salary;
    }
    
    public double calculatorTaxAmount(){
    double taxableAmount = this.salary;
    double totalTax = 0.0;
    
    for(int i = 0; i < Tax_Brackets.length; i++){
    if (taxableAmount > Tax_Brackets[i]) {
    double bracketAmount = taxableAmount - Tax_Brackets[i];
    totalTax += bracketAmount * Tax_Rates[i+1];
    taxableAmount -= bracketAmount;
    } else {
    totalTax += taxableAmount * Tax_Rates[i];
    break;
    }
    }
    return totalTax;
    }
    
    public double getTaxPercentage() {
        double taxableAmount = this.salary;
        for (int i = 0; i < Tax_Brackets.length; i++) {
            if (taxableAmount > Tax_Brackets[i]) {
                taxableAmount -= Tax_Brackets[i];
            } else {
                return Tax_Rates[i] * 100;
            }
        }
        return Tax_Rates[Tax_Rates.length - 1] * 100;
    }
    
    public double getSalaryAfterTax() {
    double taxAmount = calculatorTaxAmount();
    double salaryAfterTax = this.salary - taxAmount;
    return salaryAfterTax;
}
    
    public void displayEmployeeInfo() {
        double taxAmount = calculatorTaxAmount();
        double taxPercentage = getTaxPercentage();
        double salaryAfterTax = getSalaryAfterTax();
        System.out.printf("Employee Name: " + this.name);
        System.out.printf("Employee Number: " + this.number);
        System.out.printf("Employee Salary: R" + this.salary);
        System.out.printf("Tax Amount: R" + taxAmount);
        System.out.printf("Tax Percentage: " + taxPercentage + "%");
        System.out.printf("Salary after Tax: R" + salaryAfterTax);
    }
    
    
    
    public static void main(String[] args) {
        
       AssignmentQ1 employee = new AssignmentQ1("Junior Nkomo", 4021, 35000);
employee.displayEmployeeInfo();
    }
}
