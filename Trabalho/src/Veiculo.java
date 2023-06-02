import java.io.Serializable;
import java.util.Random;

public abstract class Veiculo implements Serializable{
    //declaracao de variaveis
    private int id = 0;
    private int distanciaPercorrida;
    private static final int quantidadeRodas = 4;
    private Roda[] rodas = new Roda[getQuantidadeRodas()];

    //construtor da classe Veiculo
    public Veiculo(int id){

        this.setId(id); //gera o prox ID
        this.setDistanciaPercorrida(0);
        this.setRodas();
    }

    public String[] inicializaDesenho(){
        return new String[0];
    }



    public abstract boolean mover();

    //move o veiculo 5 blocos
//    public boolean mover(){
//        if((this.getCombustivel() >= 0.55) && (this.isIpva())){
//            for(int i = 0; i<this.getQuantidadeRodas(); i++){
//                if(!this.getRodas()[i].isCalibragemPneu()) {
//                    return false;
//                }
//            }
//            String[] desenhoAux = this.getDesenho();
//            for(int i = 0; i<this.desenho.length; i++){
//                desenhoAux[i] = "     "+desenhoAux[i];
//            }
//            this.setCombustivel(this.getCombustivel() - 0.55);
//            this.setDistanciaPercorrida(this.getDistanciaPercorrida() + 5);
//
//            this.setDesenho(desenhoAux);
//            return true;
//        }else
//            return false;
//    }

    //printa o desenho do veiculo
    public void geraDesenho() {}

    //sobrecarga da funcao toString na classe veiculo, onde printa todas as informacoes sobre o veiculo
    public String toString(){
        String aux;
        aux = "Id: "+this.getId()+"\nQuantidade de rodas: "+this.getQuantidadeRodas()+"\n";
        for(int i = 0; i<this.getQuantidadeRodas(); i++){
            aux += "Roda "+(i+1)+": "+this.rodas[i].toString()+"\n";
        }
//        if(this.isIpva())
//            aux += "Ipva esta pago";
//        else
//            aux += "Ipva nao esta pago";

//        aux += "\nCombustivel no tanque: " +this.getCombustivel()+"L"+ "\nDistancia percorrida: "+this.distanciaPercorrida+" blocos\n";

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

    //setter da variavel rodas do veiculo
    public void setRodas(){
        for(int i=0;i<this.getQuantidadeRodas();i++){
            this.rodas[i] = new Roda();
        }
    }
}