package pkg09radmocsemestralproject;

/**
 * Program načte přímku zadanou dvěma body; následně načte sadu bodů a ty vypíše seřazené podle jejich vzdálenosti od dané přímky.
 * @author radmoc
 * @version 1 2022-01-09
 */
public class SemestralniUloha {
    
    static void mainCalculation() throws Exception {
        
        boolean run = true;
        
        do {        
            // NAČÍTÁNÍ OD UŽIVATELE
            // Načtení bodů přímky
            System.out.println("Zadejte body přímky:");
            float[] lineRaw = new float[4]; // x0 y0 x1 y2  
            for (int i = 0; i < 4; i++) {
                lineRaw[i] = Main.sc.nextFloat();
            }
            // Kontrola, zdali body nejsou stejné
            if (lineRaw[0] == lineRaw[2] && lineRaw[1] == lineRaw[3]) {
                throw new Exception("Body definující přímku nesmí být stejné");
            }
            // Načtení jednotlivých bodů
            System.out.println("Zadejte počet bodů:");
            int pointsCount = Main.sc.nextInt();    
            // Matice – co bod, to řádek se třemi prvky: [souřadnice x][souřadnice y][vzdálenost od přímky]
            System.out.println("Zadejte souřadnice bodů:");
            float[][] points = new float[pointsCount][3];        
            for (int i = 0; i < pointsCount; i++) {
                points[i][0] = Main.sc.nextFloat();
                points[i][1] = Main.sc.nextFloat();            
            }   

            // LOGIKA
            // Výpočet koeficientů obecné rovnice přímky
            float[] line = getLinearEquationCoefficients(lineRaw);
            // Výpočet jednotlivých vzdáleností od přímky
            for (int i = 0; i < pointsCount; i++) {
                points[i][2] = getDistanceFromLine(line, points[i][0], points[i][1]);  
            }             
            // Seřazení podle velikosti
            sortMatrixByThirdColumn(points);

            // VÝPIS
            System.out.println("Setříděné body:");
            for (int i = 0; i < pointsCount; i++) {
                System.out.printf("%.2f\t", points[i][0]);
                System.out.printf("%.2f%n", points[i][1]);
            }
            
            // OPAKOVÁNÍ            
            while (true) {
                System.out.println("Pokračovat ve zpracování? [a/n]");                
                char choice = Main.sc.next().toUpperCase().charAt(0);
                if (choice == 'A') break;
                else if (choice == 'N') {
                    run = false;
                    break;
                }
            }
            Main.sc.nextLine();
        } while(run);
        
    }
    
    /**
     * Vrátí pole obsahující koeficienty obecné rovnice přímky, která prochází dvěma vstupními body.
     * @param lineRaw float[] obsahující 4 prvky, souřadnice dvou bodů – x0 y0 x1 y1
     * @return float[] obsahující 3 prvky a b c – koeficienty rovnice ax + by + c = 0
     */
    static float[] getLinearEquationCoefficients(float[] lineRaw) {
        // Normálový vektor získáme odečtením dvou bodů, poté body prohodíme a jeden z nich vynásobíme minus jedničkou
        float b = lineRaw[0] - lineRaw[2];
        float a = (lineRaw[1] - lineRaw[3]) * -1;
        // a, b už známe; koeficent c získáme dosazením jednoho z bodů do rovnice ax + by = -c
        float c = -1 * (a * lineRaw[0] + b * lineRaw[1]);        
        return new float[]{a, b, c};
    }
    
    /**
     * Výpočítá vzdalenost bodu od přímky.
     * @param line float[] obsahující 3 prvky a b c – koeficienty rovnice ax + by + c = 0
     * @param x souřadnice x daného bodu
     * @param y souřadnice y daného bodu
     * @return Vzdálenost bodu popsaného proměnnýmy x,y od přímky line
     */
    static float getDistanceFromLine(float[] line, float x, float y) {
        float a = line[0];
        float b = line[1];
        float c = line[2];
        // Použití vzorce
        return Math.abs(a * x + b * y + c) / (float)Math.sqrt(a * a + b * b);        
    }
    
    /**
     * Seřadí řádky 2D pole podle jejich hodnoty ve třetím sloupci.
     * @param mx Pole, které bude seřazeno.
     */
    static void sortMatrixByThirdColumn(float[][] mx) {
        int len = mx.length;
        // Bubble sort, zaměňují se celé řádky podle hodnoty řádek[2]
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (mx[j][2] > mx[j+1][2]) {
                    float[] temp = mx[j];
                    mx[j] = mx[j+1];
                    mx[j+1] = temp;
                }
            }
        }
    }
    
    // Pro testovací účely    
    public static void main(String[] args) throws Exception {        
        //float[] coeff;
        //coeff = getLinearEquationCoefficients(new float[]{-9, 8, 5, -4});
        //coeff = getLinearEquationCoefficients(new float[]{1, 0, -1, 0});        
        //coeff = getLinearEquationCoefficients(new float[]{100, 100, 100, 100});        
        //coeff = getLinearEquationCoefficients(new float[]{1, 2, 3, 4});        
        //coeff = getLinearEquationCoefficients(new float[]{0.01f, 0.06f, -5.5f, 6.6f});        
        //coeff = getLinearEquationCoefficients(new float[]{0,0,0,0});        
        //for (int i = 0; i < 3; i++) System.out.println(coeff[i]);      
        //System.out.println(coeff[0]+"x + "+coeff[1]+"y + "+coeff[2]+" = 0");
        //System.out.println(Float.MAX_VALUE);
        //System.out.println(getDistanceFromLine(coeff, 10.32f, 0));
        //System.out.println(getDistanceFromLine(coeff, -3, -8));
        //System.out.println(getDistanceFromLine(coeff, 15, 20));
        //System.out.println(getDistanceFromLine(coeff, 1, 0));
        /*
        float[][] mx = new float[][] {{1,0,5},{0,2,4},{6,4,3},{0,0,2.5f},{0,0,-6}};
        for (int i = 0; i < mx.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(mx[i][j]+" ");
            }
            System.out.println("");
        }        
        sortMatrixByThirdColumn(mx);
        System.out.println("");
        for (int i = 0; i < mx.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(mx[i][j]+" ");
            }
            System.out.println("");
        }         
        */
        mainCalculation();
    }    
}
