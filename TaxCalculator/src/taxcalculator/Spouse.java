/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculator;

/**
 * Kelas Spouse merepresentasikan data pasangan pegawai.
 */
public class Spouse {
    private String spouseName;
    private String spouseIdNumber;

    public Spouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
    }

    public String getSpouseIdNumber() {
        return spouseIdNumber;
    }
}
