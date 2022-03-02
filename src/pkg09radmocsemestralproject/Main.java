package pkg09radmocsemestralproject;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    
    static Scanner sc = new Scanner(System.in);
    static Locale loc = new Locale ("CS", "cz");    
    
    public static void main(String[] args) {        
        
        sc.useLocale(loc);
        
        boolean end = false;
        
        do {            
            displayMainMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1: // Semestrální úloha
                    SemestralniUloha.mainCalculation();
                    break;
                case 2: // Vánoční úloha
                    VanocniUloha.main();
                    break;
                case 0: // Konec
                    end = true;
                    break;
                default:
                    System.out.println("Neplatná volba");
                    break;
            }
        } while (!end);
        
    }
    
    private static void displayMainMenu() {
        System.out.println("1 – Semestrální úloha\n2 – Vánoční úloha\n0 – Konec");
    }

}
