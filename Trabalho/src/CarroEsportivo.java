public class CarroEsportivo extends VeiculoMotorizado implements IPVA{


    private String[] desenho = new String[4];
    private final int quantidadeRodas = 4;
    private final int movimento = 10;

    public CarroEsportivo(int id) {

        super(id);
    }

    public boolean mover(){

        return false;

    }

    public String[] inicializaDesenho(){
        String[] desenho = new String[4];

        desenho[0] = "       __\n\n";
        desenho[1] = "     ~( @\\ \\\n\n";
        desenho[2] = "  _____]_[_/_>____\n\n";
        desenho[3] = " /  __ \\<>  |  __ \\\n\n";
        desenho[4] = " /  __ \\<>  |  __ \\\n\n";
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
}
