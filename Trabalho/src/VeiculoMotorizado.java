import java.util.Random;

public abstract class VeiculoMotorizado extends Veiculo{

    private String[] desenho = new String[4];
    private double combustivel = 2.5;

    private boolean ipva;

    public VeiculoMotorizado(int id, int tamanhoDesenho) {
        super(id,tamanhoDesenho);

        Random rd = new Random(); // gerar ipva aleatorio

        this.setIpva(rd.nextBoolean()); // gerar ipva aleatorio

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
