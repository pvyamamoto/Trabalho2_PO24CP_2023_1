public class Motocicleta extends VeiculoMotorizado implements IPVA{

    private String[] desenho = new String[4];
    private final int quantidadeRodas = 2;
    private final int movimento = 3;
    public Motocicleta(int id) {
        super(id);
    }

    public String[] inicializaDesenho(){
        String[] desenho = new String[4];

        desenho[0] = "   ,_oo\n";
        desenho[1] = ".-/c-//::  \n";
        desenho[2] = "(_)'==(_)\n";

        return desenho;
    }

    public double calculaIpva() {
        return base*cte_moto;
    }
}
