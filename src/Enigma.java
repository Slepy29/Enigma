import java.util.Scanner;
public class Enigma {
    private Plugs plugs;
    private Rotor firstRotor;
    private Rotor secondRotor;
    private Rotor thirdRotor;
    private Reflector reflector;
    public static void main(String[] args) {
        Enigma enigma = new Enigma(new Plugs(),new Rotor(5,0),new Rotor(8,3),new Rotor(19,2),new Reflector('A'));
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        input = input.toUpperCase();
        int i = 0;
        while (i < input.length()) {
            enigma.enigmaRun(input.charAt(i)-'A');
            i++;
        }
    }

    public Enigma(Plugs plugs, Rotor firstRotor, Rotor secondRotor, Rotor thirdRotor, Reflector reflector) {
        this.plugs = plugs;
        this.firstRotor = firstRotor;
        this.secondRotor = secondRotor;
        this.thirdRotor = thirdRotor;
        this.reflector = reflector;
    }

    public void moveRotors(){
        firstRotor.rotorPosition++;
        if (firstRotor.rotorPosition==firstRotor.getTurnover()){
            firstRotor.rotorPosition=0;
            secondRotor.rotorPosition++;
            if (secondRotor.rotorPosition==secondRotor.getTurnover()){
                secondRotor.rotorPosition=0;
                thirdRotor.rotorPosition++;
                if (thirdRotor.rotorPosition==26)
                    thirdRotor.rotorPosition=0;
            }
        }
    }

    public void enigmaRun(int a){
        int out;
        out = plugs.plugsRun(a);
        out = firstRotor.rotRun(out,true);
        out = secondRotor.rotRun(out,true);
        out = thirdRotor.rotRun(out,true);
        out = reflector.refRun(out);
        out = thirdRotor.rotRun(out,false);
        out = secondRotor.rotRun(out,false);
        out = firstRotor.rotRun(out,false);
        out = plugs.plugsRun(out);
        moveRotors();
        System.out.print((char)(out+'A'));
    }

    public void setPositions(int r1, int r2, int r3){
        this.firstRotor.setTurnover(r1);
        this.secondRotor.setTurnover(r2);
        this.thirdRotor.setTurnover(r3);
    }

    public void setPlugs(int[][] arr){
        this.plugs.setPairs(arr);
    }
}
