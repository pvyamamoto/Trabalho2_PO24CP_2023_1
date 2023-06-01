import java.util.Random;

public class VeiculoMotorizado extends Veiculo{

    private String[] desenho = new String[4];
    private double gasolina = 2.5;

    private boolean ipva;

    public VeiculoMotorizado(int id) {
        super(id);

        Random rd = new Random(); // gerar ipva aleatorio

        this.setIpva(rd.nextBoolean()); // gerar ipva aleatorio

    }

    public boolean isIpva() {
        return ipva;
    }

    public void setIpva(boolean ipva) {
        this.ipva = ipva;
    }
}
