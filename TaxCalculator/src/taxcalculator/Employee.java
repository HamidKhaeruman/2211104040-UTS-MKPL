/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Kelas Employee merepresentasikan data pegawai.
 * 
 * Refactoring:
 * 1. Mengganti magic number dengan konstanta (SALARY_GRADE, FOREIGNER_SALARY_MULTIPLIER)
 * 2. Membuat kelas inner untuk Spouse dan Child untuk mengenkapsulasi data mereka
 * 3. Mengganti LinkedList dengan ArrayList karena tidak ada kebutuhan untuk menggunakan LinkedList
 * 4. Menghilangkan duplicate code pada method setMonthlySalary dengan menggunakan array SALARY_GRADE
 * 5. Membuat method getMonthWorkingInYear untuk mengenkapsulasi logika perhitungan bulan kerja
 */
public class Employee {

    // Konstanta untuk gaji berdasarkan grade
    private static final double FOREIGNER_SALARY_MULTIPLIER = 1.5;
    private static final int[] SALARY_GRADE = {3000000, 5000000, 7000000};

    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;

    private int yearJoined;
    private int monthJoined;
    private int dayJoined;

    private boolean isForeigner;
    private boolean gender; 

    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    private Spouse spouse;
    private List<Child> children;

    public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, int yearJoined, int monthJoined, int dayJoined, boolean isForeigner, boolean gender) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.yearJoined = yearJoined;
        this.monthJoined = monthJoined;
        this.dayJoined = dayJoined;
        this.isForeigner = isForeigner;
        this.gender = gender;

        children = new ArrayList<>();
    }

    /**
     * Method untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya.
     * 
     * Refactoring:
     * 1. Mengganti if-else dengan array SALARY_GRADE
     * 2. Menghilangkan duplicate code untuk perhitungan gaji asing
     */
    public void setMonthlySalary(int grade) {
        if (grade < 1 || grade > 3) {
            throw new IllegalArgumentException("Invalid grade");
        }
        monthlySalary = (int) (SALARY_GRADE[grade - 1] * (isForeigner ? FOREIGNER_SALARY_MULTIPLIER : 1));
    }

    public void setAnnualDeductible(int deductible) {	
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {	
        this.otherMonthlyIncome = income;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public void addChild(Child child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(child);
    }

    /**
     * Method untuk menghitung bulan kerja dalam tahun ini.
     * 
     * Refactoring:
     * 1. Mengenkapsulasi logika perhitungan bulan kerja
     */
    public int getMonthWorkingInYear() {
        LocalDate date = LocalDate.now();
        if (date.getYear() == yearJoined) {
            return date.getMonthValue() - monthJoined;
        } else {
            return 12;
        }
    }

    // Getters untuk TaxFunction
    public int getMonthlySalary() {
        return monthlySalary;
    }

    public int getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    public int getAnnualDeductible() {
        return annualDeductible;
    }

    public boolean isMarried() {
        return spouse != null && spouse.getSpouseIdNumber() != null && !spouse.getSpouseIdNumber().isEmpty();
    }

    public int getNumberOfChildren() {
        return children == null ? 0 : children.size();
    }
}
