public class Motocicleta extends VeiculoMotorizado implements IPVA{

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

    public boolean mover(){
        if((this.getCombustivel() >= 0.55) && (this.isIpva())){
            for(int i = 0; i<this.getQuantidadeRodas(); i++){
                if(!this.getRodas()[i].isCalibragemPneu()) {
                    return false;
                }
            }
            String[] desenhoAux = this.getDesenho();
            for(int i = 0; i<this.desenho.length; i++){
                desenhoAux[i] = "          "+desenhoAux[i];
            }
            this.setCombustivel(this.getCombustivel() - 0.25);
            this.setDistanciaPercorrida(this.getDistanciaPercorrida() + movimento);

            this.setDesenho(desenhoAux);
            return true;
        }else{
            return false;
        }
    }

    public double calculaIpva() {
        return base*cte_moto;
    }
}
