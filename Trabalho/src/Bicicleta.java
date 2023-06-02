public class Bicicleta extends Veiculo{

    public Bicicleta(int id){
        super(id, 3, 2, 2);

    }
    public String[] inicializaDesenho(){
        String[] desenho = new String[3];

        desenho[0] = "   __o \n";
        desenho[1] = " _`\\<,_\n";
        desenho[2] = "(*)/ (*)\n";

        return desenho;
    }

    public void geraDesenho(){
        for(int i=0;i<this.getDesenho().length;i++){
            System.out.print(this.getDesenho()[i]);
        }
    }

    public boolean mover() {
        String[] desenhoAux = this.getDesenho();
        for(int i = 0; i<this.getDesenho().length; i++){
            desenhoAux[i] = "  "+desenhoAux[i];
        }
        this.setDistanciaPercorrida(this.getDistanciaPercorrida() + this.getMovimento());
        this.setDesenho(desenhoAux);

        return true;
    }
}