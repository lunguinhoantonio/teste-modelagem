import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean go = true;
        boolean isListOrganizedAscending = false;
        boolean isListOrganizedDescending = false;
        String msgInvalidOpt = "Selecione uma opção válida!";
        ArrayList<Short> ages = new ArrayList<>();
        ArrayList<Short> addedAges = new ArrayList<>();
        ArrayList<Short> removedAges = new ArrayList<>();
        ArrayList<Short> EditAges = new ArrayList<>();

        // Criando números aleatórios entre 1 e 80 até que o tamanho do array seja de 100

        while (ages.size() < 100) {
            short randomNum = (short) (1 + (Math.random() * 80));
            ages.add(randomNum);
        }

        /* Criando números aleatórios entre 1 e 110 até que o tamanho da array seja de 120. Fiz
        separado para que a probabilidade de uma idade ser maior que 80 seja menor */

        while (ages.size() < 120) {
            short randomNum = (short) (1 + (Math.random() * 110));
            ages.add(randomNum);
        }

        ArrayList<Short> copyOfAges = new ArrayList<>(ages);

        do {
            System.out.println("Lista de idades: " + ages);
            System.out.println("0. Fechar programa");
            System.out.println("1. Consultar quantidade de idades");
            System.out.println("2. Manipular dados");
            System.out.println("3. Ordenar lista");
            System.out.println("4. Mais opções da lista");
            System.out.print("Resposta: ");
            byte choice = scan.nextByte();
            Dividir.dividirTerminal();

            switch (choice) {
                case 0:
                    scan.close();
                    ages.clear();
                    System.out.println("Espero ter gostado do programa! :D");
                    Dividir.dividirTerminal();
                    go = false;
                    break;
                case 1:
                    System.out.println("Quantidade de idades na lista: " + ages.size());
                    Dividir.dividirTerminal();
                    break;
                case 2:
                    System.out.println("0. Voltar");
                    System.out.println("1. Adicionar idade");
                    System.out.println("2. Editar idade");
                    System.out.println("3. Remover idade");
                    System.out.print("Resposta: ");
                    byte choiceCase2 = scan.nextByte();
                    Dividir.dividirTerminal();
                    switch (choiceCase2) {
                        case 0:
                            break;
                        case 1:
                            short addAge;
                            System.out.println("0. Voltar");
                            System.out.println("1. Adicionar quantidades predefinidas");
                            System.out.println("2. Adicionar quantos quiser");
                            System.out.print("Resposta: ");
                            byte subChoice1 = scan.nextByte();
                            Dividir.dividirTerminal();
                            switch (subChoice1) {
                                case 0:
                                    break;
                                case 1:
                                    System.out.print("Quantas idades deseja adicionar? ");
                                    short numberAges = scan.nextShort();
                                    for (int c = 0; c < numberAges; c++) {
                                        System.out.print("Adicionar idade: ");
                                        addAge = scan.nextShort();
                                        if (addAge < 0) {
                                            System.out.println("A idade não pode ser negativa!");
                                            Dividir.dividirTerminal();
                                        } else if (addAge > 120) {
                                            System.out.println("É pouco provável que exista alguém com essa idade!");
                                            Dividir.dividirTerminal();
                                        } else {
                                            ages.add(addAge);
                                            addedAges.add(addAge);
                                            System.out.println("Idade adicionada!");
                                            Dividir.dividirTerminal();
                                        }
                                    }
                                    System.out.println("Lista atualizada!");
                                    Dividir.dividirTerminal();
                                    break;
                                case 2:
                                    String continueCase2Opt2 = "";
                                    do {
                                        System.out.print("Adicionar idade: ");
                                        addAge = scan.nextShort();
                                        if (addAge < 0) {
                                            System.out.println("A idade não pode ser negativa!");
                                            continue;
                                        } else if (addAge > 120) {
                                            System.out.println("É pouco provável que exista alguém com essa idade!");
                                            continue;
                                        } else {
                                            ages.add(addAge);
                                            addedAges.add(addAge);
                                        }
                                        System.out.print("Continuar adicionando? [S/N]: ");
                                        continueCase2Opt2 = scan.next().toUpperCase();
                                        Dividir.dividirTerminal();
                                    } while (continueCase2Opt2.equals("S"));
                                    System.out.println("Idades adicionadas!");
                                    Dividir.dividirTerminal();
                                    break;
                                default:
                                    System.out.println(msgInvalidOpt);
                                    Dividir.dividirTerminal();
                            }
                            break;
                        case 2:
                            if (ages.isEmpty()) {
                                System.out.println("Não é possível editar a lista porque ela está vazia!");
                                Dividir.dividirTerminal();
                                break;
                            }

                            System.out.println("0. Cancelar");
                            System.out.print("Selecionar idade: ");
                            short editAge = scan.nextShort();
                            Dividir.dividirTerminal();
                            if (editAge == 0) {
                                break;
                            }

                            boolean ageFound = ages.contains(editAge);

                            if (ageFound) {
                                int editedIndex = ages.indexOf(editAge);
                                EditAges.add(editAge);
                                System.out.println("Idade selecionada: [" + editAge + "]");
                                System.out.println("Índice: [" + editedIndex + "]");
                                System.out.print("Nova idade: ");
                                editAge = scan.nextShort();
                                Dividir.dividirTerminal();

                                if (editAge < 0) {
                                    System.out.println("A idade não pode ser negativa!");
                                    Dividir.dividirTerminal();
                                    break;
                                } else if (editAge > 120) {
                                    System.out.println("É pouco provável que exista alguém com essa idade!");
                                    Dividir.dividirTerminal();
                                    break;
                                }

                                ages.set(editedIndex, editAge);
                                System.out.println("Idade editada!");
                                Dividir.dividirTerminal();
                            } else {
                                System.out.println("Idade não encontrada!");
                                Dividir.dividirTerminal();
                                break;
                            }
                            break;
                        case 3:
                            if (ages.isEmpty()) {
                                System.out.println("A lista já está vazia!");
                                Dividir.dividirTerminal();
                                break;
                            }

                            System.out.println("0. Voltar");
                            System.out.println("1. Remover todas abaixo de 18");
                            System.out.println("2. Remover todas acima ou iguais a 18 e abaixo de 60");
                            System.out.println("3. Remover todas acima ou iguais a 60");
                            System.out.println("4. Personalizar remoções");
                            System.out.println("5. Remover todas as idades");
                            System.out.print("Resposta: ");
                            byte subChoice3 = scan.nextByte();
                            Dividir.dividirTerminal();
                            switch (subChoice3) {
                                case 0:
                                    break;
                                case 1:
                                    /* `num -> num < 18` é chamada de Lambda Expression, tem a mesma função que um forEach:
                                     * for (Integer num : idades) {
                                     *   if (num < 18) {
                                     *   idades.remove(num);
                                     *   }
                                     * }
                                     * */
                                    boolean feedbackCase3Opt1 = ages.removeIf(num -> {
                                        if (num < 18) {
                                            removedAges.add(num);
                                            return true;
                                        }
                                        return false;
                                    });
                                    String msgCase3Opt1 = (feedbackCase3Opt1)
                                            ? "Idade(s) removida(s)!" : "Faixa de idade não encontrada!";
                                    System.out.println(msgCase3Opt1);
                                    Dividir.dividirTerminal();
                                    break;
                                case 2:
                                    boolean feedbackCase3Opt2 = ages.removeIf(num -> {
                                        if (num >= 18 && num < 60) {
                                            removedAges.add(num);
                                            return true;
                                        }
                                        return false;
                                    });
                                    String msgCase3Opt2 = (feedbackCase3Opt2)
                                            ? "Idades removidas!" : "Faixa de idade não encontrada!";
                                    System.out.println(msgCase3Opt2);
                                    Dividir.dividirTerminal();
                                    break;
                                case 3:
                                    boolean feedbackCase3Opt3 = ages.removeIf(num -> {
                                        if (num >= 60) {
                                            removedAges.add(num);
                                            return true;
                                        }
                                        return false;
                                    });
                                    String msgCase3Opt3 = (feedbackCase3Opt3)
                                            ? "Idade(s) removida(s)!" : "Faixa de idade não encontrada!";
                                    System.out.println(msgCase3Opt3);
                                    Dividir.dividirTerminal();
                                    break;
                                case 4:
                                    String continueCase4;
                                    do {
                                        System.out.print("Remover idade: ");
                                        short rmvAge = scan.nextShort();
                                        // Faz a busca binária se a lista está organizada de alguma forma
                                        if (isListOrganizedAscending) {
                                            int index = Search.bynarySearchAscending(ages, rmvAge);
                                            if (index != -1) {
                                                removedAges.add(rmvAge);
                                                ages.remove(index);
                                                System.out.println("Idade removida!");
                                            } else {
                                                System.out.println("Idade não encontrada!");
                                            }
                                        } else if (isListOrganizedDescending) {
                                            int index = Search.bynarySearchDescending(ages, rmvAge);
                                            if (index != -1) {
                                                removedAges.add(rmvAge);
                                                ages.remove(index);
                                                System.out.println("Idade removida!");
                                            } else {
                                                System.out.println("Idade não encontrada!");
                                            }
                                        } else {
                                            // Se não tiver organizada, faz a busca linear padrão
                                            boolean removedOpt4 = ages.remove(Short.valueOf(rmvAge));
                                            if (removedOpt4) {
                                                removedAges.add(rmvAge);
                                                System.out.println("Idade removida!");
                                            } else {
                                                System.out.println("Idade não encontrada!");
                                            }
                                        }
                                        System.out.print("Continuar removendo? [S/N]: ");
                                        continueCase4 = scan.next().toUpperCase();
                                        Dividir.dividirTerminal();
                                    } while (continueCase4.equals("S"));
                                    break;
                                case 5:
                                    System.out.println("Todas as idades serão removidas após o confirmamento dessa ação.");
                                    System.out.print("Tem certeza dessa ação? [S/N]: ");
                                    String respCase5 = scan.next().toUpperCase();
                                    Dividir.dividirTerminal();

                                    if (respCase5.equals("S")) {
                                        removedAges.addAll(ages);
                                        ages.clear();
                                        System.out.println("Lista limpa!");
                                        Dividir.dividirTerminal();
                                    }
                                    break;
                                default:
                                    System.out.println(msgInvalidOpt);
                                    Dividir.dividirTerminal();
                            }
                            break;
                    }
                    break;
                case 3:
                    if (ages.size() <= 1) {
                        System.out.println("Não é possível ordenar a lista com 1 elemento ou menos!");
                        Dividir.dividirTerminal();
                        break;
                    }

                    System.out.println("Ordenar em ordem: ");
                    System.out.println("0. Voltar");
                    if (isListOrganizedAscending) {
                        System.out.println("1. Desfazer ordem crescente");
                    } else {
                        System.out.println("1. Crescente");
                    }

                    if (isListOrganizedDescending) {
                        System.out.println("2. Desfazer ordem decrescente");
                    } else {
                        System.out.println("2. Decrescente");
                    }
                    System.out.print("Resposta: ");
                    byte choiceCase5 = scan.nextByte();
                    Dividir.dividirTerminal();
                    switch (choiceCase5) {
                        case 0:
                            break;
                        case 1:
                            if (isListOrganizedDescending) {
                                isListOrganizedDescending = false;
                            }

                            if (isListOrganizedAscending) {
                                ages.clear();
                                ages.addAll(copyOfAges);
                                isListOrganizedAscending = false;
                                System.out.println("Ordem desfeita!");
                            } else {
                                Collections.sort(ages);
                                isListOrganizedAscending = true;
                                System.out.println("Lista ordenada!");
                            }

                            Dividir.dividirTerminal();
                            break;
                        case 2:
                            if (isListOrganizedAscending) {
                                isListOrganizedAscending = false;
                            }
                            if (isListOrganizedDescending) {
                                ages.clear();
                                ages.addAll(copyOfAges);
                                isListOrganizedDescending = false;
                                System.out.println("Ordem desfeita!");
                            } else {
                                ages.sort(Collections.reverseOrder());
                                isListOrganizedDescending = true;
                                System.out.println("Lista ordenada!");
                            }
                            Dividir.dividirTerminal();
                            break;
                        default:
                            System.out.println(msgInvalidOpt);
                            Dividir.dividirTerminal();
                        }
                    break;
                case 4:
                    System.out.println("0. Voltar");
                    System.out.println("1. Ver a soma de todas as idades");
                    System.out.println("2. Ver a média e mediana das idades");
                    System.out.println("3. Ver idades pares e ímpares");
                    System.out.println("4. Ver quantidade de menores de idade/adultos/idosos");
                    System.out.println("5. Restaurar idades removidas");
                    System.out.println("6. Ver alterações na lista");
                    System.out.print("Resposta: ");
                    byte choiceCase4 = scan.nextByte();
                    Dividir.dividirTerminal();
                    switch (choiceCase4) {
                        case 0:
                            break;
                        case 1:
                            if (ages.size() <= 1) {
                                System.out.println("Não é possível realizar essa ação " +
                                        "com a lista tendo 1 elemento ou menos!");
                                Dividir.dividirTerminal();
                                continue;
                            }
                            short sumCase4Opt1 = 0;
                            for (short numbers : ages) {
                                sumCase4Opt1 += numbers;
                            }

                            System.out.println("A soma de todas as idades é: " + sumCase4Opt1);
                            Dividir.dividirTerminal();
                            break;
                        case 2:
                            if (ages.size() <= 1) {
                                System.out.println("Não é possível realizar essa ação " +
                                        "com a lista tendo 1 elemento ou menos!");
                                Dividir.dividirTerminal();
                                continue;
                            }
                            short sumCase4Opt2 = 0;
                            float mediaArith;
                            for (int num : ages) {
                                sumCase4Opt2 += (short) num;
                            }

                            mediaArith = (float) sumCase4Opt2 / ages.size();
                            System.out.printf("A média aritmética de todas as idades é %.2f!", mediaArith);

                            // Fazendo a clonagem dos elementos do ArrayList idades para toCalcMedian
                            ArrayList<Short> toCalcMedian = new ArrayList<>(ages);
                            float median;
                            short t = (short) toCalcMedian.size();
                            Collections.sort(toCalcMedian);
                            if (t % 2 == 0) {
                                median = (float) ((toCalcMedian.get(t / 2 - 1)
                                        + toCalcMedian.get(t / 2)) / 2.0);
                            } else {
                                median = toCalcMedian.get(t / 2);
                            }
                            System.out.printf("\nA mediana das idades é %.2f!\n", median);
                            Dividir.dividirTerminal();
                            toCalcMedian.clear();
                            break;
                        case 3:
                            if (ages.isEmpty()) {
                                System.out.println("Não é possível realizar essa ação se a lista está vazia!");
                                Dividir.dividirTerminal();
                                continue;
                            }
                            ArrayList<Byte> even = new ArrayList<>();
                            ArrayList<Byte> odd = new ArrayList<>();

                            for (int num : ages) {
                                if (num % 2 == 0) {
                                    even.add((byte) num);
                                } else {
                                    odd.add((byte) num);
                                }
                            }
                            if (even.isEmpty()) {
                                System.out.println("Não existem números pares!");
                            } else {
                                Collections.sort(even);
                                System.out.println("Pares: " + even.size() + ", e são eles: " + even);
                            }

                            if (odd.isEmpty()) {
                                System.out.println("Não existem números ímpares!");
                            } else {
                                Collections.sort(odd);
                                System.out.println("Ímpares: " + odd.size() + ", e são eles: " + odd);
                            }

                            Dividir.dividirTerminal();
                            even.clear();
                            odd.clear();
                            break;
                        case 4:
                            if (ages.isEmpty()) {
                                System.out.println("Não é possível realizar essa ação se a lista está vazia!");
                                Dividir.dividirTerminal();
                                continue;
                            }
                            ArrayList<Byte> minorsAge = new ArrayList<>();
                            ArrayList<Byte> adultAge = new ArrayList<>();
                            ArrayList<Byte> elderlyAge = new ArrayList<>();

                            for (int num : ages) {
                                if (num < 18) {
                                    minorsAge.add((byte) num);
                                } else if (num < 60) {
                                    adultAge.add((byte) num);
                                } else {
                                    elderlyAge.add((byte) num);
                                }
                            }

                            if (minorsAge.isEmpty()) {
                                System.out.println("Não tem menores de idade!");
                            } else {
                                Collections.sort(minorsAge);
                                System.out.println("Menores de idade: " +
                                        minorsAge.size() +
                                        ", e são eles: " + minorsAge);
                            }

                            if (adultAge.isEmpty()) {
                                System.out.println("Não tem adultos!");
                            } else {
                                Collections.sort(adultAge);
                                System.out.println("Adultos: " +
                                        adultAge.size() +
                                        ", e são eles: " + adultAge);
                            }

                            if (elderlyAge.isEmpty()) {
                                System.out.println("Não tem idosos!");
                            } else {
                                Collections.sort(elderlyAge);
                                System.out.println("Idosos: " +
                                        elderlyAge.size() +
                                        ", e são eles: " + elderlyAge);
                            }

                            Dividir.dividirTerminal();

                            minorsAge.clear();
                            adultAge.clear();
                            elderlyAge.clear();
                            break;
                        case 5:
                            System.out.println("Todas as idades que você removeu voltarão após essa ação.");
                            System.out.print("Tem certeza dessa ação? [S/N]: ");
                            String respCase4Opt5 = scan.next().toUpperCase();
                            Dividir.dividirTerminal();
                            if (respCase4Opt5.equals("S")) {
                                ages.addAll(removedAges);
                                System.out.println("Todas as idades removidas foram restauradas!");
                                Dividir.dividirTerminal();
                            }
                            break;
                        case 6:
                            boolean isEnableToBeHere =
                                    addedAges.isEmpty() &&
                                    EditAges.isEmpty() &&
                                    removedAges.isEmpty();

                            if (!isEnableToBeHere) {
                                System.out.println("Quantidades de idades adicionadas: " + addedAges.size());
                                System.out.println("Idades adicionadas: " + addedAges);
                                System.out.println("Quantidades de idades editadas: " + EditAges.size());
                                System.out.println("Idades editadas: " + EditAges);
                                System.out.println("Quantidades de idades removidas: " + removedAges.size());
                                System.out.println("Idades removidas: " + removedAges);
                                Dividir.dividirTerminal();
                                break;
                            }

                            System.out.println("Não houve alterações na lista!");
                            Dividir.dividirTerminal();
                            break;
                        default:
                            System.out.println(msgInvalidOpt);
                            Dividir.dividirTerminal();
                    }
                    break;
                default:
                    System.out.println(msgInvalidOpt);
                    Dividir.dividirTerminal();
            }
        } while (go);
    }
}