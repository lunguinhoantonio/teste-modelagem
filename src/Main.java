import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean go = true;
        String msgInvalidOpt = "Selecione uma opção válida!";
        ArrayList<Short> idades = new ArrayList<>();
        ArrayList<Short> idadesAdicionadas = new ArrayList<>();
        ArrayList<Short> idadesRemovidas = new ArrayList<>();
        ArrayList<Short> idadesEditadas = new ArrayList<>();

        // Criando números aleatórios entre 1 e 80 até que o tamanho do array seja de 100

        while (idades.size() < 100) {
            short randomNum = (short) (1 + (Math.random() * 80));
            idades.add(randomNum);
        }

        /* Criando números aleatórios entre 1 e 110 até que o tamanho da array seja de 120. Fiz
        separado para que a probabilidade de uma idade ser maior que 80 seja menor */

        while (idades.size() < 120) {
            short randomNum = (short) (1 + (Math.random() * 110));
            idades.add(randomNum);
        }

        do {
            System.out.println("Lista de idades: " + idades);
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
                    idades.clear();
                    System.out.println("Espero ter gostado do programa! :D");
                    Dividir.dividirTerminal();
                    go = false;
                    break;
                case 1:
                    System.out.println("Quantidade de idades na lista: " + idades.size());
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
                                    short quantIdades = scan.nextShort();
                                    for (int c = 0; c < quantIdades; c++) {
                                        System.out.print("Adicionar idade: ");
                                        addAge = scan.nextShort();
                                        if (addAge < 0) {
                                            System.out.println("A idade não pode ser negativa!");
                                            Dividir.dividirTerminal();
                                        } else if (addAge > 120) {
                                            System.out.println("É pouco provável que exista alguém com essa idade!");
                                            Dividir.dividirTerminal();
                                        } else {
                                            idades.add(addAge);
                                            idadesAdicionadas.add(addAge);
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
                                            idades.add(addAge);
                                            idadesAdicionadas.add(addAge);
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
                            if (idades.isEmpty()) {
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

                            boolean idadeEncontrada = idades.contains(editAge);

                            if (idadeEncontrada) {
                                int indexEditada = idades.indexOf(editAge);
                                idadesEditadas.add(editAge);
                                System.out.println("Idade selecionada: [" + editAge + "]");
                                System.out.println("Índice: [" + indexEditada + "]");
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

                                idades.set(indexEditada, editAge);
                                System.out.println("Idade editada!");
                                Dividir.dividirTerminal();
                            } else {
                                System.out.println("Idade não encontrada!");
                                Dividir.dividirTerminal();
                                break;
                            }
                            break;
                        case 3:
                            if (idades.isEmpty()) {
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
                                    boolean feedbackCase3Opt1 = idades.removeIf(num -> {
                                        if (num < 18) {
                                            idadesRemovidas.add(num);
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
                                    boolean feedbackCase3Opt2 = idades.removeIf(num -> {
                                        if (num >= 18 && num < 60) {
                                            idadesRemovidas.add(num);
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
                                    boolean feedbackCase3Opt3 = idades.removeIf(num -> {
                                        if (num >= 60) {
                                            idadesRemovidas.add(num);
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
                                        boolean removedOpt4 = idades.remove(Short.valueOf(rmvAge));
                                        if (removedOpt4) {
                                            idadesRemovidas.add(rmvAge);
                                            System.out.println("Idade removida!");
                                        } else {
                                            System.out.println("Idade não encontrada!");
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
                                        idadesRemovidas.addAll(idades);
                                        idades.clear();
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
                    if (idades.size() <= 1) {
                        System.out.println("Não é possível ordenar a lista com 1 elemento ou menos!");
                        Dividir.dividirTerminal();
                        break;
                    }

                    System.out.println("Ordenar em ordem: ");
                    System.out.println("0. Voltar");
                    System.out.println("1. Crescente");
                    System.out.println("2. Decrescente");
                    System.out.print("Resposta: ");
                    byte choiceCase5 = scan.nextByte();
                    Dividir.dividirTerminal();
                    switch (choiceCase5) {
                        case 0:
                            break;
                        case 1:
                            Collections.sort(idades);
                            System.out.println("Lista ordenada!");
                            Dividir.dividirTerminal();
                            break;
                        case 2:
                            idades.sort(Collections.reverseOrder());
                            System.out.println("Lista ordenada!");
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
                            if (idades.size() <= 1) {
                                System.out.println("Não é possível realizar essa ação " +
                                        "com a lista tendo 1 elemento ou menos!");
                                Dividir.dividirTerminal();
                                continue;
                            }
                            short somaCase4Opt1 = 0;
                            for (short numbers : idades) {
                                somaCase4Opt1 += numbers;
                            }

                            System.out.println("A soma de todas as idades é: " + somaCase4Opt1);
                            Dividir.dividirTerminal();
                            break;
                        case 2:
                            if (idades.size() <= 1) {
                                System.out.println("Não é possível realizar essa ação " +
                                        "com a lista tendo 1 elemento ou menos!");
                                Dividir.dividirTerminal();
                                continue;
                            }
                            short somaCase4Opt2 = 0;
                            float mediaArith;
                            for (int num : idades) {
                                somaCase4Opt2 += (short) num;
                            }

                            mediaArith = (float) somaCase4Opt2 / idades.size();
                            System.out.printf("A média aritmética de todas as idades é %.2f!", mediaArith);

                            // Fazendo a clonagem dos elementos do ArrayList idades para toCalcMediana
                            ArrayList<Short> toCalcMediana = new ArrayList<>(idades);
                            float mediana;
                            short t = (short) toCalcMediana.size();
                            Collections.sort(toCalcMediana);
                            if (t % 2 == 0) {
                                mediana = (float) ((toCalcMediana.get(t / 2 - 1)
                                        + toCalcMediana.get(t / 2)) / 2.0);
                            } else {
                                mediana = toCalcMediana.get(t / 2);
                            }
                            System.out.printf("\nA mediana das idades é %.2f!\n", mediana);
                            Dividir.dividirTerminal();
                            toCalcMediana.clear();
                            break;
                        case 3:
                            if (idades.isEmpty()) {
                                System.out.println("Não é possível realizar essa ação se a lista está vazia!");
                                Dividir.dividirTerminal();
                                continue;
                            }
                            ArrayList<Byte> pares = new ArrayList<>();
                            ArrayList<Byte> impares = new ArrayList<>();

                            for (int num : idades) {
                                if (num % 2 == 0) {
                                    pares.add((byte) num);
                                } else {
                                    impares.add((byte) num);
                                }
                            }
                            if (pares.isEmpty()) {
                                System.out.println("Não existem números pares!");
                            } else {
                                Collections.sort(pares);
                                System.out.println("Pares: " + pares.size() + ", e são eles: " + pares);
                            }

                            if (impares.isEmpty()) {
                                System.out.println("Não existem números ímpares!");
                            } else {
                                Collections.sort(impares);
                                System.out.println("Ímpares: " + impares.size() + ", e são eles: " + impares);
                            }

                            Dividir.dividirTerminal();
                            pares.clear();
                            impares.clear();
                            break;
                        case 4:
                            if (idades.isEmpty()) {
                                System.out.println("Não é possível realizar essa ação se a lista está vazia!");
                                Dividir.dividirTerminal();
                                continue;
                            }
                            ArrayList<Byte> menoresIdade = new ArrayList<>();
                            ArrayList<Byte> adultosIdade = new ArrayList<>();
                            ArrayList<Byte> idososIdade = new ArrayList<>();

                            for (int num : idades) {
                                if (num < 18) {
                                    menoresIdade.add((byte) num);
                                } else if (num < 60) {
                                    adultosIdade.add((byte) num);
                                } else {
                                    idososIdade.add((byte) num);
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

                            Dividir.dividirTerminal();

                            menoresIdade.clear();
                            adultosIdade.clear();
                            idososIdade.clear();
                            break;
                        case 5:
                            System.out.println("Todas as idades que você removeu voltarão após essa ação.");
                            System.out.print("Tem certeza dessa ação? [S/N]: ");
                            String respCase5 = scan.next().toUpperCase();
                            Dividir.dividirTerminal();
                            if (respCase5.equals("S")) {
                                idades.addAll(idadesRemovidas);
                                System.out.println("Todas as idades removidas foram restauradas!");
                                Dividir.dividirTerminal();
                            }
                            break;
                        case 6:
                            boolean isEnableToBeHere =
                                    idadesAdicionadas.isEmpty() &&
                                    idadesEditadas.isEmpty() &&
                                    idadesRemovidas.isEmpty();

                            if (!isEnableToBeHere) {
                                System.out.println("Quantidades de idades adicionadas: " + idadesAdicionadas.size());
                                System.out.println("Idades adicionadas: " + idadesAdicionadas);
                                System.out.println("Quantidades de idades editadas: " + idadesEditadas.size());
                                System.out.println("Idades editadas: " + idadesEditadas);
                                System.out.println("Quantidades de idades removidas: " + idadesRemovidas.size());
                                System.out.println("Idades removidas: " + idadesRemovidas);
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