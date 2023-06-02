public class CarroPasseio extends VeiculoMotorizado implements IPVA{
    public CarroPasseio(int id) {
        super(id, 4, 4, 5);
        calculaIpva();
        this.setDesenho(inicializaDesenho()); // desenho do carro

    }

    //inicializador para gerar o desenho no construtor
    public String[] inicializaDesenho(){
        String[] desenho = new String[4];

        desenho[0] = "    ____\n";
        desenho[1] = " __/  |_ \\_\n";
        desenho[2] = "|  _     _``-.\n";
        desenho[3] = "'-(_)---(_)--'\n\n\n";

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

    public double calculaIpva() {
        return base*cte_passeio;
    }
}
