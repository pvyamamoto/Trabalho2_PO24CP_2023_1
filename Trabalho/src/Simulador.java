import java.io.Serializable;

public class Simulador implements Serializable{
    //declaracao de variaveis
    private Veiculo[] veiculos = new Veiculo[this.getMaxVeiculos()];
    private int qtidVeiculos;
    private int id = 0;
    private final int maxVeiculos = 20;
    public Simulador(){
        this.setQtidVeiculos(0);
    }//construtor da classe simulador

    public int nextId(){
        return id+=1;
    }//adiciona +1 ao id

    //inclui um veiculo no array de veiculos
    public void incluirVeiculo(){


//        Veiculo v = new Veiculo(nextId(),maxVeiculos);
//        this.setVeiculos(v, this.getQtidVeiculos()); // inicializa um veiculo no espaço do do vetor
//        this.setQtidVeiculos(this.getQtidVeiculos() + 1);// adiciona 1 no set
    }

    public void incluirCarroP(){

    }

    public void incluirCarroE(){

    }

    public void inclueirMotocicleta(){

    }

    public void incluirBicicleta(){

    }

    //calibra um pneu de um veiculo especifico
    public void calibraPneu(int idC,int idP){
        if(idC == -1){
            System.out.println("Veiculo inexistente! Tente novamente\n");
        }else if(idP != 1 && idP != 2 && idP != 3 && idP != 4 ){
            System.out.println("Pneu Inexistente! Tente novamente\n");
        }else{
            this.veiculos[idC].getRodas()[idP - 1].setCalibragemPneu(true);
            System.out.println("O pneu " + idP + ", do carro " + (idC+1) + " esta calibrado!");
        }
    }

    //calibra os pneus de um veiculos
    public void calibraPneu(int id){
        if(id == -1){
            System.out.println("Veiculo inexistente! Tente novamente\n");
        }else{
            for (int i = 1; i <= this.veiculos[id].getQuantidadeRodas(); i++) {
                if(!this.veiculos[id].getRodas()[i-1].isCalibragemPneu()) {
                    this.calibraPneu(id, i);
                }
            }
            System.out.println("Todos os pneus do carro " + (id+1) + " foram calibrados\n");
        }
    }

    //calibra todos os pneus de todos os veiculos
    public void calibraPneu() {
        for (int i = 0; i < this.getQtidVeiculos(); i++) {
            for (int j = 1; j <= this.veiculos[i].getQuantidadeRodas(); j++) {
                if(!this.veiculos[i].getRodas()[j-1].isCalibragemPneu()){
                    this.calibraPneu(i, j);
                }
            }
        }
        System.out.println("\nTodos os pneus de todos os carros foram calibrados\n");
    }

    //paga o IPVA de um veiculo especifico
    public void pagaIPVA(int id){
        if(id == -1){
            System.out.println("Veiculo inexistente! Tente novamente\n");
        }else{
            this.veiculos[this.getVeiculoPos(id)].setIpva(true);
            System.out.println("\nO veiculo com o id: " + id + " esta com o IPVA pago!\n");
        }
    }
    //paga o IPVA de todos os veiculos
    public void pagaIPVA(){
        for(int i =0;i<this.getQtidVeiculos();i++){
            this.veiculos[i].setIpva(true);
        }
    }

    //remove um veiculo do array veiculos e move todos os veiculos -1 posicao
    public void removerVeiculo(int id){
        if(id == -1){
            System.out.println("Veiculo inexistente! Tente novamente\n");
        }else{
            this.veiculos[id] = null;
            for(int i = id; i<this.getQtidVeiculos()-1; i++)
                this.setVeiculos(this.veiculos[i+1],i);
            this.setQtidVeiculos(this.getQtidVeiculos() - 1);

            System.out.println("Veiculo removido!\n");
        }
    }

    //abastece quant de combustivel em um veiculo especifico
    public void abastecer(int id, double quant){
        if(id == -1){
            System.out.println("Veiculo inexistente! Tente novamente\n");
        }else{
            this.veiculos[id].setCombustivel(this.veiculos[id].getCombustivel() + quant);// setando o combustivel com oq tem + o adicionado
            System.out.printf("\nO veiculo com o id: " + (id+1) + " esta com  %.2f L de combustivel no tanque\n",(float) this.veiculos[id].getCombustivel());

        }
    }

    //move um veiculo 5 blocos
    public void mover(int id){
        if(id == -1){
            System.out.println("Veiculo inexistente! Tente novamente\n");

        }else{
            if(this.veiculos[id].mover()){
                this.veiculos[id].mover();
                System.out.println("\nO veiculo com o id: " + (id+1) + " se moveu\n");
            }else{
                System.out.println("\nO veiculo com o id: " + (id+1) + " nao se moveu\n");
            }
        }
    }

    //move todos os veiculos 5 blocos
    public void mover(){
        for(int i=0;i<this.getQtidVeiculos(); i++){
            this.veiculos[i].mover();
        }

    }

    //imprime a pista
    public void imprimirPista(){
        for(int i = 0;i<this.getQtidVeiculos();i++){
            System.out.println("Veiculo "+this.veiculos[i].getId()+":");
            this.veiculos[i].geraDesenho();
        }
    }

    //sobrecarga da funcao toString na classe Simulador
    public String toString(int id){
        if(id == -1){
            return "Veiculo inexistente! Tente novamente\n";
        }else{
            return this.veiculos[id].toString();
        }

    }

    //getter da variavel qtidVeiculos
    public int getQtidVeiculos() {
        return this.qtidVeiculos;
    }

    //setter da variavel qtidVeiculos
    public void setQtidVeiculos(int qtidVeiculos) {
        if(this.getQtidVeiculos()>=20){
            System.out.println("Impossivel completar operacao, o vetor esta cheio\n");
        }else{
            this.qtidVeiculos = qtidVeiculos;
        }
    }

    //getter da variavel veiculos
    public Veiculo[] getVeiculos(){
        return veiculos;
    }

    //setter da variavel veiculos
    public void setVeiculos(Veiculo[] veiculos){
        this.veiculos = veiculos;
    }


    //setter de uma posicao da variavel veiculos
    public void setVeiculos(Veiculo veiculo, int pos){
        this.veiculos[pos] = veiculo;
    }

    //getter da variavel maxVeiculos, e como a variavel é final nao possui setter
    public int getMaxVeiculos(){
        return maxVeiculos;
    }

    //funcao para achar um veiculo especifico na array de veiculos
    public int getVeiculoPos(int id){
        for(int i = 0; i<this.getQtidVeiculos(); i++) {
            if(veiculos[i].getId() == id)
                return i;
        }

        return -1;
    }
}