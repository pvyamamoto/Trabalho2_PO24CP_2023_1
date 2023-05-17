import java.io.Serializable;
import java.util.Random;

public class Veiculo implements Serializable{
    //declaracao de variaveis
    private int id = 0;
    private String[] desenho = new String[4];
    private int distanciaPercorrida;
    private static final int quantidadeRodas = 4;
    private Roda[] rodas = new Roda[getQuantidadeRodas()];
    private boolean ipva;
    private double combustivel;

    //construtor da classe Veiculo
    public Veiculo(int id){
        Random rd = new Random(); // gerar ipva aleatorio

        this.setId(id); //gera o prox ID
        this.setDistanciaPercorrida(0);
        this.setIpva(rd.nextBoolean()); // gerar ipva aleatorio
        this.setRodas();
        this.setCombustivel(2.5); // combustivel base tem q ser 2.5
        this.setDesenho(inicializaDesenho()); // desenho do carro
    }

    //move o veiculo 5 blocos
    public boolean mover(){
        if((this.getCombustivel() >= 0.55) && (this.isIpva())){
            for(int i = 0; i<this.getQuantidadeRodas(); i++){
                if(!this.getRodas()[i].isCalibragemPneu()) {
                    return false;
                }
            }
            String[] desenhoAux = this.getDesenho();
            for(int i = 0; i<this.desenho.length; i++){
                desenhoAux[i] = "     "+desenhoAux[i];
            }
            this.setCombustivel(this.getCombustivel() - 0.55);
            this.setDistanciaPercorrida(this.getDistanciaPercorrida() + 5);

            this.setDesenho(desenhoAux);
            return true;
        }else
            return false;
    }

    //printa o desenho do veiculo
    public void geraDesenho() {
        for(int i=0;i<4;i++){
            System.out.print(this.getDesenho()[i]);
        }
    }

    //sobrecarga da funcao toString na classe veiculo, onde printa todas as informacoes sobre o veiculo
    public String toString(){
        String aux;
        aux = "Id: "+this.getId()+"\nQuantidade de rodas: "+this.getQuantidadeRodas()+"\n";
        for(int i = 0; i<this.getQuantidadeRodas(); i++){
            aux += "Roda "+(i+1)+": "+this.rodas[i].toString()+"\n";
        }
        if(this.isIpva())
            aux += "Ipva esta pago";
        else
            aux += "Ipva nao esta pago";

        aux += "\nCombustivel no tanque: " +this.getCombustivel()+"L"+ "\nDistancia percorrida: "+this.distanciaPercorrida+" blocos\n";

        return aux;
    }

    //getter da variavel id
    public int getId(){
        return id;
    }

    //setter da variavel id
    public void setId(int id){
        this.id = id;
    }

    //getter da variavel distanciaPercorrida
    public int getDistanciaPercorrida(){
        return distanciaPercorrida;
    }

    //setter da variavel distanciaPercorrida
    public void setDistanciaPercorrida(int distanciaPercorrida){
        this.distanciaPercorrida = distanciaPercorrida;
    }

    //getter da variavel rodas
    public Roda[] getRodas() {
        return rodas;
    }

    //getter da variavel quantidadeRodas
    public int getQuantidadeRodas() {
        return this.quantidadeRodas;
    }

    //getter da variavel ipva
    public boolean isIpva(){
        return ipva;
    }

    //setter da varivael ipva
    public void setIpva(boolean ipva) {
        this.ipva = ipva;
    }

    //getter da variavel combustivel
    public double getCombustivel() {
        return combustivel;
    }

    //setter da variavel combustivel
    public void setCombustivel(double combustivel) {
        this.combustivel = combustivel;
    }

    //getter da varivel desenho
    public String[] getDesenho() {
        return desenho;
    }

    //setter da varivel desenho
    public void setDesenho(String[] desenho){
        this.desenho = desenho;
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

    //setter da variavel rodas do veiculo
    public void setRodas(){
        for(int i=0;i<this.getQuantidadeRodas();i++){
            this.rodas[i] = new Roda();
        }
    }
}