import java.io.*;
import java.util.Scanner;

public class UsaSimulador{
    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        int opcao;
        int auxId;
        char c;
        Simulador simulador = new Simulador();


        do{
            System.out.println("\n=====           Menu           ======");
            System.out.println("===== Escolha uma Opcao Abaixo ======");
            System.out.println("1 - Incluir Veiculo");
            System.out.println("2 - Remover Veiculo");
            System.out.println("3 - Abastecer Veiculo");
            System.out.println("4 - Paga IPVA de um veiculo");
            System.out.println("5 - Paga IPVA de todos os veiculos");
            System.out.println("6 - Movimentar um Veiculo");
            System.out.println("7 - Movimentar Todos os Veiculos");
            System.out.println("8 - Imprimir Dados de um Veiculo");
            System.out.println("9 - Imprimir os Dados de um Tipo de Veiculo");
            System.out.println("10 - Imprimir Dados de todos os Veiculos");
            System.out.println("11 - Calibrar Pneu Especifico");
            System.out.println("12 - Esvaziar Pneu Especifico");
            System.out.println("13 - Calibrar Todos os Pneus de um Carro");
            System.out.println("14 - Calibrar Todos os Pneus de um Tipo de Veiculo");
            System.out.println("15 - Esvaziar Todos os Pneus de um Tipo de Veiculo");
            System.out.println("16 - Calibrar Todos os Pneus de Todos os Veiculos");
            System.out.println("17 - Imprimir Pista de Corrida");
            System.out.println("18 - Gravar Veiculos em um Arquivo");
            System.out.println("19 - Ler Veiculos em um Arquivo");
            System.out.println("20 - Sair da Aplicacao");

            opcao = teclado.nextInt();

            switch(opcao) {
                case 1:
                    if(simulador.getQtidVeiculos() < simulador.getMaxVeiculos()) {
                        do{
                            System.out.println("Qual veiculo gostaria de incluir? (B, M, C ou E)");
                            c = teclado.next().charAt(0);
                            if(c != 'B' && c != 'b' && c != 'M' && c != 'm' && c != 'C' && c != 'c' && c != 'E' && c != 'e')
                                System.out.println("Informe um caractere valido!\n");
                            else
                                simulador.incluirVeiculo(c);
                        }while(c != 'B' && c != 'b' && c != 'M' && c != 'm' && c != 'C' && c != 'c' && c != 'E' && c != 'e');
                        System.out.println("\nO veiculo " + simulador.getVeiculos()[simulador.getQtidVeiculos() - 1].getId() + " foi adicionado!");
                    }else{
                        System.out.println("\nQuantidade maxima de veiculos atingida!");
                    }
                    break;
                case 2:
                    System.out.println("Informe o id do veiculo que voce deseja remover:");
                    auxId = teclado.nextInt();
                    simulador.removerVeiculo(simulador.getVeiculoPos(auxId));
                    break;
                case 3:
                    System.out.println("Informe o id do veiculo que voce deseja abastecer:");
                    auxId = teclado.nextInt();
                    System.out.println("Informe quanto de combustivel gostaria de colocar:");
                    double auxD = teclado.nextDouble();
                    simulador.abastecer(simulador.getVeiculoPos(auxId), auxD);
                    break;
                case 4:
                    System.out.println("informe o id do veiculo que voce deseja pagar o ipva:");
                    auxId = teclado.nextInt();
                    simulador.pagaIPVA(auxId);
                    break;
                case 5:
                    simulador.pagaIPVA();
                    System.out.println("\nOs IPVA de todos os veiculos estao pagos!");
                    break;
                case 6:
                    System.out.println("Informe o id do veiculo que voce deseja movimentar:");
                    auxId = teclado.nextInt();
                    simulador.mover(simulador.getVeiculoPos(auxId));
                    break;
                case 7:
                    simulador.mover();
                    System.out.println("\nTodos os veiculos foram movidos!");
                    break;
                case 8:
                    System.out.println("Informe o id do veiculo que voce deseja saber os dados:");
                    auxId = teclado.nextInt();
                    System.out.println(simulador.toString(simulador.getVeiculoPos(auxId)));
                    break;
                case 9:
                    System.out.println("Informe o tipo de veiculo que voce deseja saber os dados:");
                    c = teclado.next().charAt(0);
                    if(c == 'B' || c == 'b'){
                        for (int i = 0; i < simulador.getQtidVeiculos(); i++) {
                            if(simulador.getVeiculos()[i] instanceof Bicicleta){
                                System.out.println(simulador.getVeiculos()[i].toString());
                            }
                        }
                    }else if(c == 'M' || c == 'm'){
                        for (int i = 0; i < simulador.getQtidVeiculos(); i++) {
                            if(simulador.getVeiculos()[i] instanceof Motocicleta){
                                System.out.println(simulador.getVeiculos()[i].toString());
                            }
                        }
                    }else if(c == 'C' || c == 'c'){
                        for (int i = 0; i < simulador.getQtidVeiculos(); i++) {
                            if(simulador.getVeiculos()[i] instanceof CarroPasseio){
                                System.out.println(simulador.getVeiculos()[i].toString());
                            }
                        }
                    }else if(c == 'E' || c == 'e'){
                        for (int i = 0; i < simulador.getQtidVeiculos(); i++) {
                            if(simulador.getVeiculos()[i] instanceof CarroEsportivo){
                                System.out.println(simulador.getVeiculos()[i].toString());
                            }
                        }
                    }
                    break;
                case 10:
                    System.out.println("\nOs veiculos sao os seguintes:");
                    for (int i = 0; i < simulador.getQtidVeiculos(); i++) {
                        System.out.println(simulador.getVeiculos()[i].toString());
                    }
                    break;
                case 11:
                    System.out.println("Informe o id do veiculo que voce deseja calibrar o pneu:");
                    auxId = teclado.nextInt();
                    if(simulador.getVeiculos()[auxId] instanceof Bicicleta || simulador.getVeiculos()[auxId] instanceof Motocicleta){
                        System.out.println("Informe o pneu do veiculo (1-2):");
                    }else {
                        System.out.println("Informe o pneu do veiculo (1-4):");
                    }
                    int pneu = teclado.nextInt();
                    simulador.calibraPneu(simulador.getVeiculoPos(auxId),pneu);
                    break;
                case 12:
                    System.out.println("Informe o id do veiculo que voce deseja esvaziar o pneu:");
                    auxId = teclado.nextInt();
                    if(simulador.getVeiculos()[auxId] instanceof Bicicleta || simulador.getVeiculos()[auxId] instanceof Motocicleta){
                        System.out.println("Informe o pneu do veiculo (1-2):");
                    }else{
                        System.out.println("Informe o pneu do veiculo (1-4):");
                    }
                    pneu = teclado.nextInt();
                    simulador.descalibraPneu(simulador.getVeiculoPos(auxId),pneu);
                    break;
                case 13:
                    System.out.println("Informe o id do veiculo que voce deseja calibrar os pneus:");
                    auxId = teclado.nextInt();
                    simulador.calibraPneu(simulador.getVeiculoPos(auxId));
                    break;
                case 14:
                    System.out.println("Informe o tipo de veiculo que voce deseja calibrar os pneus:");
                    c = teclado.next().charAt(0);
                    if(c == 'B' || c == 'b'){
                        simulador.calibraTipo(c);
                    }else if(c == 'M' || c == 'm'){
                        simulador.calibraTipo(c);
                    }else if(c == 'C' || c == 'c'){
                        simulador.calibraTipo(c);
                    }else if(c == 'E' || c == 'e'){
                        simulador.calibraTipo(c);
                    }
                    break;
                case 15:
                    System.out.println("Informe o tipo de veiculo que voce deseja esvaziar os pneus:");
                    c = teclado.next().charAt(0);
                    if(c == 'B' || c == 'b'){
                        simulador.descalibraTipo(c);
                    }else if(c == 'M' || c == 'm'){
                        simulador.descalibraTipo(c);
                    }else if(c == 'C' || c == 'c'){
                        simulador.descalibraTipo(c);
                    }else if(c == 'E' || c == 'e'){
                        simulador.descalibraTipo(c);
                    }
                    break;
                case 16:
                    simulador.calibraPneu();
                    break;
                case 17:
                    simulador.imprimirPista();
                    break;
                case 18:
                    teclado.nextLine();
                    System.out.println("Informe o caminho para salvar o arquivo (formato \"C:\\caminho\\\"):");
                    String pathOut = teclado.nextLine();
                    System.out.println("Informe o nome do arquivo: ");
                    String nomeOut = teclado.nextLine();

                    File simOut = new File(pathOut+"\\"+nomeOut+".txt");
                    try{
                        FileOutputStream fos = new FileOutputStream(simOut);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);

                        oos.writeObject(simulador);

                        oos.flush();
                        oos.close();
                        fos.close();

                        System.out.println("\nOs veiculos foram gravados.");
                    }catch(Exception ex){
                        System.err.println("erro: "+ ex);
                    }
                    break;
                case 19:
                    teclado.nextLine();
                    System.out.println("Informe o caminho para ler o arquivo (formato \"C:\\caminho\\\"):");
                    String pathIn = teclado.nextLine();
                    System.out.println("Informe o nome do arquivo: ");
                    String nomeIn = teclado.nextLine();
                    File simIn = new File(pathIn+"\\"+nomeIn+".txt");
                    try{
                        FileInputStream fin = new FileInputStream(simIn);
                        ObjectInputStream oin = new ObjectInputStream(fin);

                        simulador = (Simulador) oin.readObject();

                        oin.close();
                        fin.close();
                        System.out.println("\nSucesso na leitura.");
                    }catch(Exception ex){
                        System.err.println("erro: "+ex);
                    }
                    break;
                case 20:
                    System.out.println("\nVoce saiu da aplicacao.");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente Novamente.");
            }
        }while(opcao != 20);

    }
}