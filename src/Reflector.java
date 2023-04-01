import java.util.Arrays;

public class Reflector {
    private final String ukw_A = "EJMZALYXVBWFCRQUONTSPIKHGD";
    private final String ukw_B = "YRUHQSLDPXNGOKMIEBFZCWVJAT";
    private final String ukw_C = "FVPJIAOYEDRZXWGCTKUQSBNMHL";
    private int[][] wiring;
    private char reflecLetter;
    public Reflector(char reflecLetter) {
        this.reflecLetter = reflecLetter;
        wiring = new int[26][2];
        switch (reflecLetter){
            case 'A' ->{
                for (int i = 0; i < ukw_A.length(); i++) {
                    wiring[i][1]=i;
                    wiring[i][0]=ukw_A.charAt(i)-'A';
                }
            }
            case 'B' ->{
                for (int i = 0; i < ukw_B.length(); i++) {
                    wiring[i][1]=i;
                    wiring[i][0]=ukw_B.charAt(i)-'A';
                }
            }
            case 'C' ->{
                for (int i = 0; i < ukw_C.length(); i++) {
                    wiring[i][1]=i;
                    wiring[i][0]=ukw_C.charAt(i)-'A';
                }
            }
        }
    }
    public int refRun(int refIn){
        return wiring[refIn][0];
    }
}
