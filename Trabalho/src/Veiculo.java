import java.io.Serializable;
import java.util.Random;

public abstract class Veiculo implements Serializable{
    //declaracao de variaveis
    private int id = 0;
    private int distanciaPercorrida;
    private int quantidadeRodas;
    private Roda[] rodas;
    private String[] desenho;

    //construtor da classe Veiculo
    public Veiculo(int id){

        this.setId(id); //gera o prox ID
        this.setDistanciaPercorrida(0);
        this.setRodas();
    }

    public abstract String[] inicializaDesenho();

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
    public abstract void geraDesenho();

    public void calibraPneu(){
        if(this.id == -1){
            System.out.println("Veiculo inexistente! Tente novamente\n");
        }else{
            for (int i = 1; i <= this.getQuantidadeRodas(); i++) {
                if(!this.getRodas()[i-1].isCalibragemPneu()) {
                    this.calibraPneu(i);
                }
            }
            System.out.println("Todos os pneus do carro " + (id+1) + " foram calibrados\n");
        }
    }
    public void calibraPneu(int idP) {
        if(this.id == -1){
            System.out.println("Veiculo inexistente! Tente novamente\n");
        }else if(this.getQuantidadeRodas() == 4) {
            if(idP != 1 && idP != 2 && idP != 3 && idP != 4)
                System.out.println("Pneu Inexistente! Tente novamente\n");
            else{
                this.getRodas()[idP - 1].setCalibragemPneu(true);
                System.out.println("O pneu " + idP + ", do carro " + (this.id+1) + " esta calibrado!");
            }
        }else if(this.getQuantidadeRodas() == 2){
            if(idP != 1 && idP != 2)
                System.out.println("Pneu Inexistente! Tente novamente\n");
            else{
                this.getRodas()[idP - 1].setCalibragemPneu(true);
                System.out.println("O pneu " + idP + ", do carro " + (this.id+1) + " esta calibrado!");
            }
        }
    }

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

//        return aux;
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