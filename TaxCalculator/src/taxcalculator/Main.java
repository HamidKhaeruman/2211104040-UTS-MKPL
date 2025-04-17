/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taxcalculator;

public class Main {

    public static void main(String[] args) {
        Employee employee = new Employee("E001", "John", "Doe", "123456789", "Jl. Contoh No. 1", 2022, 1, 1, false, true);
        employee.setMonthlySalary(2);
        employee.setAdditionalIncome(1000000);
        employee.setAnnualDeductible(5000000);
        employee.setSpouse(new Spouse("Jane Doe", "987654321"));
        employee.addChild(new Child("Child1", "111111111"));
        employee.addChild(new Child("Child2", "222222222"));

        System.out.println("Annual Income Tax: " + TaxFunction.calculateTax(employee.getMonthlySalary(), employee.getOtherMonthlyIncome(), employee.getMonthWorkingInYear(), employee.getAnnualDeductible(), employee.isMarried(), employee.getNumberOfChildren()));
    }

}
