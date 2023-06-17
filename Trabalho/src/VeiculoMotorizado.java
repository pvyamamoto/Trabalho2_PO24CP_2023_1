import java.util.Random;

public abstract class VeiculoMotorizado extends Veiculo{
    private double combustivel = 2.5;
    private boolean ipva;

    public VeiculoMotorizado(int id, int tamanhoDesenho, int qntRodas, int mov) {
        super(id,tamanhoDesenho, qntRodas, mov);

        Random rd = new Random(); // gerar ipva aleatorio

        this.setIpva(rd.nextBoolean()); // gerar ipva aleatorio
    }

    public String toString(){
        String aux = super.toString();

        aux = "\nCombustivel no tanque: " +this.getCombustivel()+"L";

        return aux;
    }
    public boolean mover() {
        return false;
    }

    public boolean isIpva() {
        return ipva;
    }

    public void setIpva(boolean ipva) {
        this.ipva = ipva;
    }

    public double getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(double combustivel) {
        this.combustivel = combustivel;
    }
}
