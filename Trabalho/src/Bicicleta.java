public class Bicicleta extends Veiculo{

    private String[] desenho = new String[4];

    public String[] inicializaDesenho(){
        String[] desenho = new String[4];

        desenho[0] = "   __o \n";
        desenho[1] = " _`\\<,_\n";
        desenho[2] = "(*)/ (*)\n";

        return desenho;
    }

    public boolean mover() {
        return false;
    }


    public Bicicleta(int id) {
        super(id);
    }
}
