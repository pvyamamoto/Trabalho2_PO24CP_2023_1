import java.io.Serializable;
import java.util.Random;

public class Roda implements Serializable{
    //declaracao de variaveis
    private boolean calibragemPneu;

    //construtor da classe Roda
    public Roda(){
        Random rd = new Random();
        this.setCalibragemPneu(rd.nextBoolean());
    }

    //sobrecarga da funcao toString na classe Roda, onde printa se o pneu esta calibrado
    public String toString(){
        if(this.isCalibragemPneu()){
            return "O pneu esta calibrado";
        }else{
            return "O pneu nao esta calibrado";
        }
    }

    //getter da variavel calibragemPneu
    public boolean isCalibragemPneu() {
        return this.calibragemPneu;
    }

    //setter da variavel calibragemPneu
    public void setCalibragemPneu(boolean calibragemPneu) {
        this.calibragemPneu = calibragemPneu;
    }
}

