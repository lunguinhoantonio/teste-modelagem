import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean go = true;
        byte continueCase4 = 1;
        String continueCase2 = "";
        String continueCase3;
        String respCase5;
        int addAge, rmvAge;
        ArrayList<Integer> idades = new ArrayList<>();

        while (idades.size() < 10) {
            int randomNum = (int) (Math.random() * 101);
            if (!idades.contains(randomNum)) {
                idades.add(randomNum);
            }
        }

        do {
            System.out.println("--------------------------------");
            System.out.println("Lista de idades: " + idades);
            System.out.println("1. Consultar quantidade de idades");
            System.out.println("2. Adicionar idade");
            System.out.println("3. Remover idade");
            System.out.println("4. Ordenar lista");
            System.out.println("5. Limpar lista");
            System.out.println("6. Fechar programa");
            System.out.print("Resposta: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Quantidade de idades na lista: " + idades.size());
                    break;
                case 2:
                    do {
                        System.out.print("Adicionar idade: ");
                        addAge = scan.nextInt();
                        if (addAge < 0) {
                            System.out.println("A idade não pode ser negativa!");
                            continue;
                        } else if (addAge > 120){
                            System.out.println("É pouco provável que exista alguém com essa idade!");
                            continue;
                        } else {
                            idades.add(addAge);
                        }
                        System.out.print("Continuar adicionando? [S/N] ");
                        continueCase2 = scan.next().toUpperCase();
                    } while (continueCase2.equals("S"));
                    break;
                case 3:
                    do {
                        System.out.print("Remover idade: ");
                        rmvAge = scan.nextInt();
                        boolean removed = idades.remove(Integer.valueOf(rmvAge));
                        String msgCase3 = (removed) ? "Idade removida!" : "Idade não encontrada!";
                        System.out.println(msgCase3);
                        System.out.print("Continuar removendo? [S/N] ");
                        continueCase3 = scan.next().toUpperCase();
                    } while (continueCase3.equals("S"));
                    break;
                case 4:
                    do {
                        System.out.println("Ordenar em ordem: ");
                        System.out.println("1. Crescente");
                        System.out.println("2. Decrescente");
                        int choiceCase4 = scan.nextInt();
                        switch (choiceCase4) {
                            case 1:
                                Collections.sort(idades);
                                continueCase4 = 0;
                                break;
                            case 2:
                                idades.sort(Collections.reverseOrder());
                                continueCase4 = 0;
                                break;
                            default:
                                System.out.println("Insira um valor válido!");
                                continueCase4 = 0;
                        }
                    } while (continueCase4 != 0);
                    System.out.println("Lista ordenada!");
                    break;
                case 5:
                    System.out.print("Tem certeza dessa ação? [S/N] ");
                    respCase5 = scan.next().toUpperCase();

                    if (respCase5.equals("S")) {
                        idades.clear();
                        System.out.println("Lista limpa!");
                        break;
                    } else {
                        break;
                    }
                case 6:
                    scan.close();
                    go = false;
                    break;
                default:
                    System.out.println("Selecione uma opção válida!");


            }

        } while (go);
    }
}