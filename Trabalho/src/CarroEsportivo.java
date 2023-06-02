public class CarroEsportivo extends VeiculoMotorizado implements IPVA{


    private final int quantidadeRodas = 4;
    private final int movimento = 10;

    public CarroEsportivo(int id) {

        super(id,7);
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
            this.setCombustivel(this.getCombustivel() - 2.3);
            this.setDistanciaPercorrida(this.getDistanciaPercorrida() + movimento);

            this.setDesenho(desenhoAux);
            return true;
        }else{
            return false;
        }
    }

    public String[] inicializaDesenho(){
        String[] desenho = new String[4];

        desenho[0] = "       __\n";
        desenho[1] = "     ~( @\\ \\\n";
        desenho[2] = "  _____]_[_/_>____\n";
        desenho[3] = " /  __ \\<>  |  __ \\\n";
        desenho[5] = "=\\_/__\\_\\___|_/__\\_D\n";
        desenho[6] = "   (__)       (__)    \n";


        return desenho;
    }

    public void geraDesenho(int num){
        for(int i = 0;i<num;i++){
            System.out.println(this.getDesenho()[i]);
        }
    }


    public double calculaIpva() {
        return base*cte_esp;
    }

    public String[] getDesenho() {
        return desenho;
    }

    public void setDesenho(String[] desenho) {
        this.desenho = desenho;
    }

    public int getTamanhoDesenho() {
        return tamanhoDesenho;
    }
}
