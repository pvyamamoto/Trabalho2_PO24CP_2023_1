public class Motocicleta extends VeiculoMotorizado implements IPVA{

    private String[] desenho = new String[4];
    private final int quantidadeRodas = 2;
    private final int movimento = 3;
    public Motocicleta(int id) {
        super(id);
    }

    public double calculaIpva() {
        return base*cte_moto;
    }
}
