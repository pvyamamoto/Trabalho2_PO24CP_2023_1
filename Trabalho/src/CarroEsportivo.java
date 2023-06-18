import java.util.Random;

public class CarroEsportivo extends VeiculoMotorizado implements IPVA{
    public CarroEsportivo(int id) {
        super(id,7, 4, 10);

        this.setDesenho(inicializaDesenho());
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
            this.setCombustivel(this.getCombustivel() - 2.3);
            this.setDistanciaPercorrida(this.getDistanciaPercorrida() + this.getMovimento());

            this.setDesenho(desenhoAux);
            return true;
        }else{
            return false;
        }
    }

    public String[] inicializaDesenho(){
        String[] desenho = new String[6];

        desenho[0] = "       __";
        desenho[1] = "     ~( @\\ \\";
        desenho[2] = "  _____]_[_/_>____";
        desenho[3] = " /  __ \\<>  |  __ \\";
        desenho[4] = "=\\_/__\\_\\___|_/__\\_D";
        desenho[5] = "   (__)       (__)    ";


        return desenho;
    }

    public void geraDesenho(){
        for(int i = 0;i<this.getDesenho().length;i++){
            System.out.println(this.getDesenho()[i]);
        }
    }

    public String toString(){
        String aux;
        aux = super.toString();

        if(this.isIpva()){
            aux += "\n-Ipva de valor R$"+this.calculaIpva()+" esta pago";
        }
        else
            aux += "\n-Ipva de valor R$"+this.calculaIpva()+" nao esta pago";

        return aux;
    }

    public double calculaIpva() {
        return base*cte_esp;
    }
}
