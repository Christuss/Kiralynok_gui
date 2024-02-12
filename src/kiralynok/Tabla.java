/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kiralynok;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author User
 */
public class Tabla {
    String[][] T;
    String UresCella;
    Random rnd = new Random();

    public Tabla(String UresCella) {
        this.UresCella = UresCella;
        T = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                T[i][j] = this.UresCella;
        }
        }
        
    }
    
    public int UresOszlopokSzama() {
        int s = 0;
        for (int i = 0; i < 8; i++) {
            if (!UresOszlop(i)) {
                s++;
            }
        }
        return s;
        
    }
    
    public int UresSorokSzama() {
        int s = 0;
        for (int i = 0; i < 8; i++) {
            if (!UresSor(i)) {
                s++;
            }
        }
        return s;
     
    }
    
    public void Elhelyez(int n) {
        for (int i = 0; i < n; i++) {
            int s1 = rnd.nextInt(8);
            int s2 = rnd.nextInt(8);
            if (T[s1][s2].equals("K")) {
                s1 = rnd.nextInt(8);
                s2 = rnd.nextInt(8);
            }
            T[s1][s2] = "K";
        }
    }
    
    void FajlbaIr() throws IOException {
        String s = "";
        File fajl = new File("tablak64.txt");
        for (int i = 0; i < 64; i++) {
            s += new Tabla("*").Megjelenit() + "\n";
        }
        try (FileWriter fIr = new FileWriter(fajl)) {
            fIr.write(s);
        }
    }
    
    public String Megjelenit() {
       String s = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                s += T[i][j] + " ";
            }
            s += "\n";
            
        }
       return s; 
    }
    
    
    public boolean UresOszlop(int oszlop) {
        for (int i = 0; i < 8; i++) {
            if (T[oszlop][i].equals("K")) {
                return true;
            }
            
        }
        return false;
    }
    
    public boolean UresSor(int sor) {
        for (int i = 0; i < 8; i++) {
            if (T[i][sor].equals("K")) {
                return true;
            }
            
        }
        return false;
    }
}
