import java.util.Random;

public class Motocicleta extends VeiculoMotorizado implements IPVA{
    public Motocicleta(int id) {
        super(id, 2, 2, 3);

        Random rd = new Random(); // gerar ipva aleatorio

        this.setIpva(rd.nextBoolean());
        this.setDesenho(inicializaDesenho());
    }

    public String[] inicializaDesenho(){
        String[] desenho = new String[4];

        desenho[0] = "   ,_oo\n";
        desenho[1] = ".-/c-//::  \n";
        desenho[2] = "(_)'==(_)\n";

        return desenho;
    }

    public void geraDesenho(){
        for(int i=0;i<this.getDesenho().length;i++){
            System.out.print(this.getDesenho()[i]);
        }
    }

    public boolean mover(){
        if((this.getCombustivel() >= 0.55) && (this.isIpva())){
            for(int i = 0; i<this.getQuantidadeRodas(); i++){
                if(!this.getRodas()[i].isCalibragemPneu()) {
                    return false;
                }
            }
            String[] desenhoAux = this.getDesenho();
            for(int i = 0; i<this.getDesenho().length; i++){
                desenhoAux[i] = "          "+desenhoAux[i];
            }
            this.setCombustivel(this.getCombustivel() - 0.25);
            this.setDistanciaPercorrida(this.getDistanciaPercorrida() + this.getMovimento());

            this.setDesenho(desenhoAux);
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        String aux;
        if(this.isIpva()){
            aux = "Ipva de valor R$"+this.calculaIpva()+" esta pago";
        }
        else
            aux = "Ipva de valor R$"+this.calculaIpva()+" nao esta pago";

        return aux;
    }

    public double calculaIpva() {
        return base*cte_moto;
    }
}
