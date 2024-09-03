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
        byte listOrdered = 0;
        byte listUnordered = 0;
        ArrayList<Short> addedAges = new ArrayList<>();
        ArrayList<Short> removedAges = new ArrayList<>();
        ArrayList<Short> editAges = new ArrayList<>();

        // Criando idades até que o tamanho do Array seja de 120
        while (ages.size() < 120) {
            short randomNum;
            // Se o tamanho do Array for menor que 115, sorteia uma idade entre 0 e 81 e depois adiciona
            // Aqui vai adicionar 115 idades
            if (ages.size() < 115) {
                randomNum = (short) (1 + (Math.random() * 80));
            } else if (ages.size() < 118){
                // Senão, se o tamanho do Array for menor que 118, sorteia uma idade entre 80 e 111 e depois adiciona
                // Aqui vai adicionar 3 idades
                randomNum = (short) (81 + (short) (Math.random() * (110 - 81 + 1)));
            } else {
                // Senão, sorteia uma idade entre 110 e 116
                // Aqui vai adicionar 2 idades
                randomNum = (short) (81 + (short) (Math.random() * (115 - 111 + 1)));
            }
            ages.add(randomNum);
        }

        ArrayList<Short> copyOfAges = new ArrayList<>(ages);
        ArrayList<Short> firstOfAges = new ArrayList<>(ages);

        do {
            System.out.println("Lista de idades: " + ages);
            Options.mainOption();
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
                    System.out.println(isListOrganizedAscending || isListOrganizedDescending ?
                            "Quantidade de idades na lista: " + copyOfAges.size() :
                            "Quantidade de idades na lista: " +  ages.size());
                    Dividir.dividirTerminal();
                    break;
                case 2:
                    Options.case2();
                    byte choiceCase2 = scan.nextByte();
                    Dividir.dividirTerminal();
                    switch (choiceCase2) {
                        case 0:
                            break;
                        case 1:
                            short addAge;
                            Options.case2Opt1();
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
                            if (Search.checkArrayListIsEmpty
                               (ages, "Não é possível editar a lista porque ela está vazia!")) {
                                break;
                            }

                            System.out.println("0. Cancelar");
                            System.out.print("Selecionar idade: ");
                            short editAge = scan.nextShort();
                            Dividir.dividirTerminal();
                            if (editAge == 0) {
                                break;
                            }
                            int editedIndex = Search.findIndex(
                                    ages,
                                    editAge,
                                    isListOrganizedAscending,
                                    isListOrganizedDescending);
                            if (editedIndex != -1) {
                                editAges.add(editAge);
                                System.out.print("Nova idade: ");
                                editAge = scan.nextShort();
                                Dividir.dividirTerminal();

                                if (editAge < 0 || editAge > 115) {
                                    System.out.println(editAge < 0 ?
                                            "A idade não pode ser negativa!" :
                                            "É pouco provável que exista alguém com essa idade!");
                                    Dividir.dividirTerminal();
                                    break;
                                }
                                ages.set(editedIndex, editAge);
                                System.out.println("Idade editada!");
                            } else {
                                System.out.println("Idade não encontrada!");
                            }
                            Dividir.dividirTerminal();
                            break;
                        case 3:
                            if (Search.checkArrayListIsEmpty(ages, "A lista já está vazia!")) {
                                break;
                            }

                            Options.case2Opt3();
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
                                            copyOfAges.remove(num);
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
                                            copyOfAges.remove(num);
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
                                            copyOfAges.remove(num);
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
                                                System.out.println(index);
                                                removedAges.add(rmvAge);
                                                copyOfAges.remove(Short.valueOf(rmvAge));
                                                ages.remove(Short.valueOf(rmvAge));
                                                System.out.println("Idade removida!");
                                            } else {
                                                System.out.println("Idade não encontrada!");
                                            }
                                        } else if (isListOrganizedDescending) {
                                            int index = Search.bynarySearchDescending(ages, rmvAge);
                                            if (index != -1) {
                                                removedAges.add(rmvAge);
                                                copyOfAges.remove(Short.valueOf(rmvAge));
                                                ages.remove(Short.valueOf(rmvAge));
                                                System.out.println("Idade removida!");
                                            } else {
                                                System.out.println("Idade não encontrada!");
                                            }
                                        } else {
                                            // Se não tiver organizada, faz a busca linear padrão
                                            boolean removedOpt4 = ages.remove(Short.valueOf(rmvAge));
                                            if (removedOpt4) {
                                                removedAges.add(rmvAge);
                                                copyOfAges.remove(Short.valueOf(rmvAge));
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
                    if (Search.checkArrayListHasAtLeast1Element(ages)) {
                        break;
                    }

                    System.out.println("Ordenar em ordem: ");
                    System.out.println("0. Voltar");
                    System.out.println("1. " + (isListOrganizedAscending ? "Desfazer ordem crescente" : "Crescente"));
                    System.out.println("2. " + (isListOrganizedDescending ? "Desfazer ordem decrescente" : "Decrescente"));
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
                                listUnordered++;
                                System.out.println("Ordem desfeita!");
                            } else {
                                Collections.sort(ages);
                                isListOrganizedAscending = true;
                                listOrdered++;
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
                                listUnordered++;
                                System.out.println("Ordem desfeita!");
                            } else {
                                ages.sort(Collections.reverseOrder());
                                isListOrganizedDescending = true;
                                listOrdered++;
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
                    boolean isEnableToBeHere =
                            addedAges.isEmpty() &&
                            editAges.isEmpty() &&
                            removedAges.isEmpty() &&
                            listOrdered == 0 &&
                            listUnordered == 0;

                    Options.case4();
                    byte choiceCase4 = scan.nextByte();
                    Dividir.dividirTerminal();
                    switch (choiceCase4) {
                        case 0:
                            break;
                        case 1:
                            if (Search.checkArrayListHasAtLeast1Element(ages)) {
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
                            if (Search.checkArrayListHasAtLeast1Element(ages)) {
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
                            if (Search.checkArrayListIsEmpty
                               (ages, "Não é possível realizar essa ação se a lista está vazia!")) {
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

                            Search.printNumbers(even, "pares");
                            Search.printNumbers(odd, "ímpares");

                            Dividir.dividirTerminal();
                            even.clear();
                            odd.clear();
                            break;
                        case 4:
                            if (Search.checkArrayListIsEmpty
                               (ages, "Não é possível realizar essa ação se a lista está vazia!")) {
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
                            // Mostra a quantidade das respectivas faixas de idade
                            Search.printAgeGroup(minorsAge, "menores de idade");
                            Search.printAgeGroup(adultAge, "adultos");
                            Search.printAgeGroup(elderlyAge, "idosos");

                            Dividir.dividirTerminal();

                            minorsAge.clear();
                            adultAge.clear();
                            elderlyAge.clear();
                            break;
                        case 5:
                            Options.confirmCase4Opt5();
                            String respCase4Opt5 = scan.next().toUpperCase();
                            Dividir.dividirTerminal();
                            if (respCase4Opt5.equals("S")) {
                                ages.addAll(removedAges);
                                System.out.println("Todas as idades removidas foram restauradas!");
                                Dividir.dividirTerminal();
                            }
                            break;
                        case 6:
                            if (!isEnableToBeHere) {
                                // Mostra a quantidade de suas respectivas alterações de suas respectivas ações
                                Search.processAgeList("adicionada", addedAges);
                                Search.processAgeList("editada", editAges);
                                Search.processAgeList("removida", removedAges);

                                // Mostra se a lista foi ordenada ou desordenada e quantas vezes
                                Search.processListOrdered("ordenada", listOrdered);
                                Search.processListOrdered("desordenada", listUnordered);

                                Dividir.dividirTerminal();
                                break;
                            }

                            System.out.println("Não houve alterações na lista!");
                            Dividir.dividirTerminal();
                            break;
                        case 7:
                            if (Search.checkArrayListIsEmpty
                               (ages, "Não é possível realizar essa ação se a lista está vazia!")) {
                                continue;
                            }

                            System.out.print("Idade buscada: ");
                            short target = scan.nextShort();
                            Dividir.dividirTerminal();
                            short count = Search.frequencyAge(ages, target);

                            if (count == 0) {
                                System.out.println("Essa idade não existe!");
                            } else if (count == 1) {
                                System.out.println("A idade " + target + " aparece somente " + count + " vez!");
                            } else {
                                System.out.println("A idade " + target + " aparece " + count + " vezes!");
                            }
                            Dividir.dividirTerminal();
                            break;
                        case 8:
                            if (!isEnableToBeHere) {
                                Options.confirmCase4Opt8();
                                String respCase4Opt8 = scan.next().toUpperCase();
                                Dividir.dividirTerminal();
                                if (respCase4Opt8.equals("S")) {
                                    removedAges.clear();
                                    addedAges.clear();
                                    editAges.clear();
                                    listOrdered = 0;
                                    listUnordered = 0;
                                    ages.clear();
                                    ages.addAll(firstOfAges);
                                }
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