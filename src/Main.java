import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean go = true;
        String continueCase2 = "";
        String continueCase3;
        String respCase5;
        int addAge, rmvAge;
        ArrayList<Integer> idades = new ArrayList<>();

        while (idades.size() < 10) {
            int randomNum = 1 + (int) (Math.random() * 99);
            if (!idades.contains(randomNum)) {
                idades.add(randomNum);
            }
        }

        do {
            System.out.println("Lista de idades: " + idades);
            System.out.println("1. Consultar quantidade de idades");
            System.out.println("2. Adicionar idade");
            System.out.println("3. Remover idade");
            System.out.println("4. Ordenar lista");
            System.out.println("5. Limpar lista");
            System.out.println("6. Fechar programa");
            System.out.print("Resposta: ");
            int choice = scan.nextInt();
            System.out.println("-----------------------------------------------------");

            switch (choice) {
                case 1:
                    System.out.println("Quantidade de idades na lista: " + idades.size());
                    System.out.println("-----------------------------------------------------");
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
                        System.out.println("Idade adicionada!");
                        System.out.println("-----------------------------------------------------");
                    } while (continueCase2.equals("S"));
                    break;
                case 3:
                    System.out.println("1. Remover menores de idade");
                    System.out.println("2. Remover adultos");
                    System.out.println("3. Remover idosos");
                    System.out.println("4. Personalizar remoção");
                    System.out.println("5. Voltar");
                    System.out.print("Resposta: ");
                    byte choiceCase3 = scan.nextByte();
                    System.out.println("-----------------------------------------------------");
                    switch (choiceCase3) {
                        case 1:
                            boolean removedOption1 = idades.removeIf(num -> num < 18);
                            String msgCase3Option1 = (removedOption1) ? "Idades removidas!" : "Idades não encontradas!";
                            System.out.println(msgCase3Option1);
                            break;
                        case 2:
                            boolean removedOption2 = idades.removeIf(num -> num >= 18 && num < 60);
                            String msgCase3Option2 = (removedOption2) ? "Idades removidas!" : "Idades não encontradas!";
                            System.out.println(msgCase3Option2);
                            break;
                        case 3:
                            boolean removedOption3 = idades.removeIf(num -> num >= 60);
                            String msgCase3Option3 = (removedOption3) ? "Idades removidas!" : "Idades não encontradas!";
                            System.out.println(msgCase3Option3);
                            break;
                        case 4:
                            do {
                                System.out.print("Remover idade: ");
                                rmvAge = scan.nextInt();
                                boolean removedOption4 = idades.remove(Integer.valueOf(rmvAge));
                                String msgCase3Option4 = (removedOption4) ? "Idade removida!" : "Idade não encontrada!";
                                System.out.println(msgCase3Option4);
                                System.out.print("Continuar removendo? [S/N] ");
                                continueCase3 = scan.next().toUpperCase();
                                System.out.println("-----------------------------------------------------");
                            } while (continueCase3.equals("S"));
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Selecione uma opção válida!");
                    }
                    break;
                case 4:
                    boolean goCase4 = true;
                    while (goCase4) {
                        System.out.println("Ordenar em ordem: ");
                        System.out.println("1. Crescente");
                        System.out.println("2. Decrescente");
                        System.out.println("3. Voltar");
                        System.out.print("Resposta: ");
                        int choiceCase4 = scan.nextInt();
                        System.out.println("-----------------------------------------------------");
                        switch (choiceCase4) {
                            case 1:
                                Collections.sort(idades);
                                System.out.println("Lista ordenada!");
                                System.out.println("-----------------------------------------------------");
                                goCase4 = false;
                                break;
                            case 2:
                                idades.sort(Collections.reverseOrder());
                                System.out.println("Lista ordenada!");
                                System.out.println("-----------------------------------------------------");
                                goCase4 = false;
                                break;
                            case 3:
                                goCase4 = false;
                                break;
                            default:
                                System.out.println("Insira um valor válido!");
                                goCase4 = false;
                        }
                    }
                    break;
                case 5:
                    System.out.print("Tem certeza dessa ação? [S/N] ");
                    respCase5 = scan.next().toUpperCase();
                    System.out.println("-----------------------------------------------------");

                    if (respCase5.equals("S")) {
                        idades.clear();
                        System.out.println("Lista limpa!");
                        System.out.println("-----------------------------------------------------");
                    }
                    break;
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
