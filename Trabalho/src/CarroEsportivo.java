public class CarroEsportivo extends VeiculoMotorizado implements IPVA{


    private String[] desenho = new String[4];
    private final int quantidadeRodas = 4;
    private final int movimento = 10;

    public CarroEsportivo(int id) {
        super(id);
    }

    public double calculaIpva() {
        return base*cte_esp;
    }
}
