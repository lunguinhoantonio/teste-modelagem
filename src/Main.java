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
            System.out.println("0. Fechar programa");
            System.out.println("1. Consultar quantidade de idades");
            System.out.println("2. Adicionar idade");
            System.out.println("3. Remover idade");
            System.out.println("4. Ordenar lista");
            System.out.println("5. Informações da lista");
            System.out.print("Resposta: ");
            byte choice = scan.nextByte();
            System.out.println("-----------------------------------------------------");

            switch (choice) {
                case 0:
                    scan.close();
                    idades.clear();
                    System.out.println("Espero ter gostado do programa! :D");
                    System.out.println("-----------------------------------------------------");
                    go = false;
                    break;
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
                        System.out.print("Continuar adicionando? [S/N]: ");
                        continueCase2 = scan.next().toUpperCase();
                        System.out.println("Idades adicionadas!");
                        System.out.println("-----------------------------------------------------");
                    } while (continueCase2.equals("S"));
                    break;
                case 3:
                    System.out.println("0. Voltar");
                    System.out.println("1. Remover todas abaixo de 18");
                    System.out.println("2. Remover todas acima ou iguais a 18 e abaixo de 60");
                    System.out.println("3. Remover todas acima ou iguais a 60");
                    System.out.println("4. Personalizar remoções");
                    System.out.println("5. Remover todas as idades");
                    System.out.print("Resposta: ");
                    byte choiceCase3 = scan.nextByte();
                    System.out.println("-----------------------------------------------------");
                    switch (choiceCase3) {
                        case 0:
                            break;
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
                                System.out.print("Continuar removendo? [S/N]: ");
                                continueCase3 = scan.next().toUpperCase();
                                System.out.println("-----------------------------------------------------");
                            } while (continueCase3.equals("S"));
                            break;
                        case 5:
                            System.out.print("Tem certeza dessa ação? [S/N]: ");
                            respCase5 = scan.next().toUpperCase();
                            System.out.println("-----------------------------------------------------");

                            if (respCase5.equals("S")) {
                                idades.clear();
                                System.out.println("Lista limpa!");
                                System.out.println("-----------------------------------------------------");
                            }
                            break;
                        default:
                            System.out.println("Selecione uma opção válida!");
                    }
                    break;
                case 4:
                    boolean goCase4 = true;
                    while (goCase4) {
                        System.out.println("Ordenar em ordem: ");
                        System.out.println("0. Voltar");
                        System.out.println("1. Crescente");
                        System.out.println("2. Decrescente");
                        System.out.print("Resposta: ");
                        byte choiceCase4 = scan.nextByte();
                        System.out.println("-----------------------------------------------------");
                        switch (choiceCase4) {
                            case 0:
                                goCase4 = false;
                                break;
                            case 1:
                                Collections.sort(idades);
                                System.out.println("Lista ordenada!");
                                goCase4 = false;
                                break;
                            case 2:
                                idades.sort(Collections.reverseOrder());
                                System.out.println("Lista ordenada!");
                                goCase4 = false;
                                break;
                            default:
                                System.out.println("Selecione uma opção válida!");
                                goCase4 = false;
                        }
                    }
                    break;
                case 5:
                    boolean goCase5 = true;
                    while (goCase5) {
                        System.out.println("0. Voltar");
                        System.out.println("1. Ver a soma de todas as idades");
                        System.out.println("2. Ver a média aritmética das idades");
                        System.out.println("3. Ver idades pares e ímpares");
                        System.out.println("4. Ver quantidade de menores de idade/adultos/idosos");
                        System.out.print("Resposta: ");
                        byte choiceCase5 = scan.nextByte();
                        System.out.println("-----------------------------------------------------");
                        switch (choiceCase5) {
                            case 0:
                                goCase5 = false;
                                break;
                            case 1:
                                int somaCase5Option1 = 0;
                                for (int num : idades) {
                                    somaCase5Option1 += num;
                                }

                                System.out.println("A soma de todas as idades é: " + somaCase5Option1);
                                System.out.println("-----------------------------------------------------");
                                goCase5 = false;
                                break;
                            case 2:
                                int somaCase5Option2 = 0;
                                double mediaArith;
                                for (int num : idades) {
                                    somaCase5Option2 += num;
                                }

                                mediaArith = (double) somaCase5Option2 / idades.size();
                                System.out.println("A média aritmética de todas as idades é " + mediaArith);
                                System.out.println("-----------------------------------------------------");
                                goCase5 = false;
                                break;
                            case 3:
                                ArrayList<Integer> pares = new ArrayList<>();
                                ArrayList<Integer> impares = new ArrayList<>();

                                for (int num : idades) {
                                    if (num % 2 == 0) {
                                        pares.add(num);
                                    } else {
                                        impares.add(num);
                                    }
                                }

                                System.out.println("Pares: " + pares);
                                System.out.println("Ímpares: " + impares);
                                System.out.println("-----------------------------------------------------");

                                pares.clear();
                                impares.clear();
                                goCase5 = false;
                                break;
                            case 4:
                                ArrayList<Integer> menoresIdade = new ArrayList<>();
                                ArrayList<Integer> adultosIdade = new ArrayList<>();
                                ArrayList<Integer> idososIdade = new ArrayList<>();

                                for (int num : idades) {
                                    if (num < 18) {
                                        menoresIdade.add(num);
                                    } else if (num < 60) {
                                        adultosIdade.add(num);
                                    } else {
                                        idososIdade.add(num);
                                    }
                                }

                                if (menoresIdade.isEmpty()) {
                                    System.out.println("Não tem menores de idade!");
                                } else {
                                    Collections.sort(menoresIdade);
                                    System.out.println("Menores de idade: " +
                                            menoresIdade.size() +
                                            ", e são eles: " + menoresIdade);
                                }

                                if (adultosIdade.isEmpty()) {
                                    System.out.println("Não tem adultos!");
                                } else {
                                    Collections.sort(adultosIdade);
                                    System.out.println("Adultos: " +
                                            adultosIdade.size() +
                                            ", e são eles: " + adultosIdade);
                                }

                                if (idososIdade.isEmpty()) {
                                    System.out.println("Não tem idosos!");
                                } else {
                                    Collections.sort(idososIdade);
                                    System.out.println("Idosos: " +
                                            idososIdade.size() +
                                            ", e são eles: " + idososIdade);
                                }

                                System.out.println("-----------------------------------------------------");

                                menoresIdade.clear();
                                adultosIdade.clear();
                                idososIdade.clear();
                                goCase5 = false;
                                break;
                            default:
                                System.out.println("Selecione uma opção válida!");
                                goCase5 = false;
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("Selecione uma opção válida!");
                    break;

            }
        } while (go);
    }
}