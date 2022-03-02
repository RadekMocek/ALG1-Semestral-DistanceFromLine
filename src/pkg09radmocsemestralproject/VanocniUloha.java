package pkg09radmocsemestralproject;

public class VanocniUloha {
    
    static void main() {                   
        
        System.out.println("Račte zadat rozměry ŠTĚDROVEČERNÍ večeře");
        System.out.println("Šířka:");
        int wid = Main.sc.nextInt();
        System.out.println("Výška:");
        int hei = Main.sc.nextInt();
        
        if (hei % 2 == 0) hei++;
        
        int halfHei = hei / 2;
        int quadHei = hei / 4;
        
        int spacesCount = (halfHei - 1) * 2;
        final int initSpacesCount = spacesCount;        
        
        for (int i = 0; i < hei; i++) {
                        
            // Levá část
            repeatChar(' ', spacesCount);
            repeatChar('*', 2);            
            // Horní/dolní
            if (i == 0 || i == hei - 1) {
                repeatChar('*', wid);
            }
            else {                
                // Tělo – pravá část + šupiny                
                repeatChar(' ', (initSpacesCount - spacesCount));
                String scales = (i % 2 == 0) ? " )" : ") ";
                repeatStr(scales, (wid + (initSpacesCount - spacesCount) * 2 - 2) / 2);
                System.out.print("**");                
            }            
            // Ploutev
            if (i >= quadHei && i <= hei - quadHei - 1) {                
                if (!(i <= halfHei + 1 && i >= halfHei - 1)) {
                    repeatChar(' ', spacesCount * 3 - 2);
                    System.out.print("**");
                }
                repeatChar('=', (initSpacesCount - spacesCount) / 2);
                System.out.print("*");                
            }                
            
            // Nový řádek
            System.out.println();
            
            // Změna hodnot
            if (i == halfHei - 1 || i == halfHei) {
                spacesCount = 0;
            }
            else if (i > halfHei - 1) {
                spacesCount += 2;
            }            
            else {                
                spacesCount -= 2;                
            }
        }        
        
        System.out.println("\nDobrou chuť :-)\n");
    }
    
    private static void repeatChar(char ch, int times) {        
        for (int i = 0; i < times; i++) {
            System.out.print(ch);
        }        
    }
    
    private static void repeatStr(String s, int times) {        
        for (int i = 0; i < times; i++) {
            System.out.print(s);
        }        
    }

}
