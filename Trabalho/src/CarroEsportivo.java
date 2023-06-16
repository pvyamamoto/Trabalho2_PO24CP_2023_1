import java.util.Random;

public class CarroEsportivo extends VeiculoMotorizado implements IPVA{
    public CarroEsportivo(int id) {
        super(id,7, 4, 10);

        Random rd = new Random(); // gerar ipva aleatorio

        this.setIpva(rd.nextBoolean());
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
        String[] desenho = new String[7];

        desenho[0] = "       __\n";
        desenho[1] = "     ~( @\\ \\\n";
        desenho[2] = "  _____]_[_/_>____\n";
        desenho[3] = " /  __ \\<>  |  __ \\\n";
        desenho[5] = "=\\_/__\\_\\___|_/__\\_D\n";
        desenho[6] = "   (__)       (__)    \n";


        return desenho;
    }

    public void geraDesenho(){
        for(int i = 0;i<this.getDesenho().length;i++){
            System.out.println(this.getDesenho()[i]);
        }
    }

    public String toString(){
        String aux;
        if(this.isIpva()){
            aux = "\nIpva de valor R$"+this.calculaIpva()+" esta pago\n";
        }
        else
            aux = "\nIpva de valor R$"+this.calculaIpva()+" nao esta pago\n";

        return aux;
    }

    public double calculaIpva() {
        return base*cte_esp;
    }
}
