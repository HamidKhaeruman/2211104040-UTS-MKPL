/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

public class TaxFunction {

    private static final int NON_TAXABLE_INCOME = 54000000;
    private static final int ADDITIONAL_NON_TAXABLE_INCOME_FOR_SPOUSE = 4500000;
    private static final int ADDITIONAL_NON_TAXABLE_INCOME_PER_CHILD = 4500000;
    private static final double TAX_RATE = 0.05;
    private static final int MAX_CHILDREN_FOR_TAX_CALCULATION = 3;

    public static int calculateTax(Employee employee) {
        int monthWorkingInYear = employee.getMonthWorkingInYear();
        if (monthWorkingInYear > 12) {
            System.err.println("More than 12 month working per year");
        }

        int numberOfChildren = Math.min(employee.getNumberOfChildren(), MAX_CHILDREN_FOR_TAX_CALCULATION);

        int taxableIncome = (employee.getMonthlySalary() + employee.getOtherMonthlyIncome()) * monthWorkingInYear - employee.getAnnualDeductible();
        int nonTaxableIncome = NON_TAXABLE_INCOME;
        if (employee.isMarried()) {
            nonTaxableIncome += ADDITIONAL_NON_TAXABLE_INCOME_FOR_SPOUSE;
        }
        nonTaxableIncome += numberOfChildren * ADDITIONAL_NON_TAXABLE_INCOME_PER_CHILD;

        int tax = (int) Math.round(TAX_RATE * (taxableIncome - nonTaxableIncome));
        return Math.max(tax, 0);
    }
}
