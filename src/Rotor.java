import java.util.Arrays;

public class Rotor {
    //private final String ewt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String r1 = "EKMFLGDQVZNTOWYHXUSPAIBRCJ"; //notch Y turnover Q
    private final String r2 = "AJDKSIRUXBLHWTMCQGZNPYFVOE"; //notch M turnover E
    private final String r3 = "BDFHJLCPRTXVZNYEIWGAKMUSQO"; //notch D turnover V
    private final String r4 = "ESOVPZJAYQUIRHXLNFTGKDCMWB"; //notch R turnover J
    private final String r5 = "VZBRGITYUPSDNHLXAWMJQOFECK"; //notch H turnover Z

    private int[][] wiring;
    public int rotorPosition=0;
    private int rotorNumber;
    private int turnover;
    public Rotor(int rotorPosition, int rotorNumber) {
        this.rotorPosition = rotorPosition;
        this.rotorNumber = rotorNumber;
        wiring = new int[26][2];
        switch (rotorNumber){
            case 0 ->{
                for (int i = 0; i < r1.length(); i++) {
                    wiring[i][1]=i;
                    wiring[i][0]=r1.charAt(i)-'A';
                }
                turnover='Q'-'A';
            }
            case 1 ->{
                for (int i = 0; i < r2.length(); i++) {
                    wiring[i][1]=i;
                    wiring[i][0]=r2.charAt(i)-'A';
                }
                turnover='E'-'A';
            }
            case 2 ->{
                for (int i = 0; i < r3.length(); i++) {
                    wiring[i][1]=i;
                    wiring[i][0]=r3.charAt(i)-'A';
                }
                turnover='V'-'A';
            }
            case 3 ->{
                for (int i = 0; i < r4.length(); i++) {
                    wiring[i][1]=i;
                    wiring[i][0]=r4.charAt(i)-'A';
                }
                turnover='J'-'A';
            }
            case 4 ->{
                for (int i = 0; i < r5.length(); i++) {
                    wiring[i][0]=i;
                    wiring[i][1]=r5.charAt(i)-'A';
                }
                turnover='Z'-'A';
            }
        }
    }

    public int getTurnover() {
        return turnover;
    }

    public void setTurnover(int turnover) {
        this.turnover = turnover;
    }

    public int rotRun(int rotIn, boolean forward){
        if (forward)
            return wiring[(rotIn+rotorPosition)%26][0];
        else{
            for (int i = 0; i < wiring.length; i++) {
                if (wiring[i][0]==rotIn){
                    int out = i-rotorPosition;
                    while (out<0)
                        out+=26;
                    out%=26;
                    return out;
                }
            }
        }
        throw new RuntimeException();
    }

}
