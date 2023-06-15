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
            System.out.println(" =====        Menu        ====== ");
            System.out.println(" ===== Escolha uma Opcao Abaixo ====== ");
            System.out.println("1 - Incluir Veiculo");
            System.out.println("2 - Remover Veiculo");
            System.out.println("3 - Abastecer Veiculo");
            System.out.println("4 - Paga IPVA de um veiculo");
            System.out.println("5 - Paga IPVA de todos os veiculos");
            System.out.println("6 - Movimentar um Veiculo");
            System.out.println("7 - Movimentar Todos os Veiculos");
            System.out.println("8 - Imprimir Dados de um Veiculo");
            System.out.println("9 - Imprimir Dados de todos os Veiculos");
            System.out.println("10 - Calibrar Pneu Especifico");
            System.out.println("11 - Calibrar Todos os Pneus de um Carro");
            System.out.println("12 - Calibrar Todos os Pneus de Todos os Carros");
            System.out.println("13 - Imprimir Pista de Corrida");
            System.out.println("14 - Gravar Veiculos em um Arquivo");
            System.out.println("15 - Ler Veiculos de um Arquivo");
            System.out.println("16 - Sair da Aplicacao");
            opcao = teclado.nextInt();

            switch(opcao) {
                case 1:
                    if (simulador.getQtidVeiculos() < simulador.getMaxVeiculos()) {
                        System.out.println("Qual veiculo gostaria de incluir? (B, M, C ou E)");
                        c = teclado.next().charAt(0);
                        if(c == 'B' || c == 'b'){
                            simulador.incluirBicicleta();
                        }else if(c == 'M' || c == 'm'){
                            simulador.inclueirMotocicleta();
                        }else if(c == 'C' || c == 'c'){
                            simulador.incluirCarroP();
                        }else if(c == 'E' || c == 'e'){
                            simulador.incluirCarroE();
                        }
                        System.out.println("\nO veiculo " + simulador.getVeiculos()[simulador.getQtidVeiculos() - 1].getId() + " foi adicionado\n");
                    } else {
                        System.out.println("\nQuantidade maxima de veiculos atingida!\n");
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
                    System.out.println("\nOs IPVA de todos os veiculos estao pagos!\n");
                    break;
                case 6:
                    System.out.println("Informe o id do veiculo que voce deseja movimentar:");
                    auxId = teclado.nextInt();
                    simulador.mover(simulador.getVeiculoPos(auxId));
                    break;
                case 7:
                    simulador.mover();
                    System.out.println("\nTodos os veiculos foram movidos!\n");
                    break;
                case 8:
                    System.out.println("Informe o id do veiculo que voce deseja saber os dados:");
                    auxId = teclado.nextInt();
                    System.out.println(simulador.toString(simulador.getVeiculoPos(auxId)));
                    break;
                case 9:
                    System.out.println("\nOs carros sao os seguintes:\n");
                    for (int i = 0; i < simulador.getQtidVeiculos(); i++) {
                        System.out.println(simulador.getVeiculos()[i].toString());
                    }
                    break;
                case 10:
                    System.out.println("Informe o id do veiculo que voce deseja calibrar o pneu:");
                    auxId = teclado.nextInt();
                    System.out.println("Informe o pneu do carro (1-4):");
                    int pneu = teclado.nextInt();
                    simulador.calibraPneu(simulador.getVeiculoPos(auxId),pneu);
                    break;
                case 11:
                    System.out.println("Informe o id do veiculo que voce deseja calibrar os pneus:");
                    auxId = teclado.nextInt();
                    simulador.calibraPneu(simulador.getVeiculoPos(auxId));
                    break;
                case 12:
                    simulador.calibraPneu();
                    break;
                case 13:
                    simulador.imprimirPista();
                    break;
                case 14:
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

                        System.out.println("\nOs veiculos foram gravados.\n");
                    }catch(Exception ex){
                        System.err.println("erro: "+ ex);
                    }
                    break;
                case 15:
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
                        System.out.println("\nSucesso na leitura.\n");
                    }catch(Exception ex){
                        System.err.println("erro: "+ex);
                    }
                    break;
                case 16:
                    System.out.println("\nVoce saiu da aplicacao.");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente Novamente.");
            }
        }while(opcao != 16);

    }
}