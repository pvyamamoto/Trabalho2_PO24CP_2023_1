import java.util.Random;

public class CarroPasseio extends VeiculoMotorizado implements IPVA{
    public CarroPasseio(int id) {
        super(id, 4, 4, 5);

        this.setDesenho(inicializaDesenho()); // desenho do carro

    }

    //inicializador para gerar o desenho no construtor
    public String[] inicializaDesenho(){
        String[] desenho = new String[4];

        desenho[0] = "    ____";
        desenho[1] = " __/  |_ \\_";
        desenho[2] = "|  _     _``-.";
        desenho[3] = "'-(_)---(_)--'";

        return desenho;
    }

    public boolean mover() {
        if((this.getCombustivel() >= 0.55) && (this.isIpva())){
            for(int i = 0; i<this.getQuantidadeRodas(); i++){
                if(!this.getRodas()[i].isCalibragemPneu()) {
                    return false;
                }
            }
            String[] desenhoAux = this.getDesenho();
            for(int i = 0; i<this.getDesenho().length; i++){
                desenhoAux[i] = "     "+desenhoAux[i];
            }
            this.setCombustivel(this.getCombustivel() - 0.75);
            this.setDistanciaPercorrida(this.getDistanciaPercorrida() + this.getMovimento());

            this.setDesenho(desenhoAux);
            return true;
        }else
            return false;
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
            aux += "\nIpva de valor R$"+this.calculaIpva()+" esta pago\n";
        }
        else
            aux += "\nIpva de valor R$"+this.calculaIpva()+" nao esta pago\n";

        return aux;
    }

    public double calculaIpva() {
        return base*cte_passeio;
    }
}
