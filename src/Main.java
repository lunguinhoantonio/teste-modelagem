import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean go = true;
        String continueCase2Option2 = "";
        String continueCase3;
        short addAge;
        ArrayList<Short> idades = new ArrayList<>();
        ArrayList<Short> idadesAdicionadas = new ArrayList<>();
        ArrayList<Short> idadesForamEditadas = new ArrayList<>();
        // Criando números aleatórios entre 1 e 80 até que o tamanho do array seja de 100
        while (idades.size() < 100) {
            short randomNum = (short) (1 + (Math.random() * 80));
            idades.add(randomNum);
        }
        /* Criando números aleatórios entre 1 e 110 até que o tamanho da array seja de 120, fiz
        separado para que a probabilidade de uma idade ser maior que 80 seja menor */
        while (idades.size() < 120) {
            short randomNum = (short) (1 + (Math.random() * 110));
            idades.add(randomNum);
        }

        do {
            System.out.println("Lista de idades: " + idades);
            System.out.println("0. Fechar programa");
            System.out.println("1. Consultar quantidade de idades");
            System.out.println("2. Adicionar idade");
            System.out.println("3. Editar idade");
            System.out.println("4. Remover idade");
            System.out.println("5. Ordenar lista");
            System.out.println("6. Mais opções da lista");
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
                    short quantIdades;
                        System.out.println("0. Voltar");
                        System.out.println("1. Adicionar quantidades predefinidas");
                        System.out.println("2. Adicionar quantos quiser");
                        System.out.print("Resposta: ");
                        byte choiceCase2 = scan.nextByte();
                        Dividir.dividirTerminal();
                        switch (choiceCase2) {
                            case 0:
                                break;
                            case 1:
                                System.out.print("Quantas idades deseja adicionar? ");
                                quantIdades = scan.nextShort();
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
                                    continueCase2Option2 = scan.next().toUpperCase();
                                    Dividir.dividirTerminal();
                                } while (continueCase2Option2.equals("S"));
                                System.out.println("Idades adicionadas!");
                                Dividir.dividirTerminal();
                                break;
                        }
                    break;
                case 3:
                    if (idades.isEmpty()) {
                        System.out.println("Não é possível editar a lista porque ela já está vazia!");
                        Dividir.dividirTerminal();
                        break;
                    }

                    System.out.println("0. Cancelar");
                    System.out.print("Selecionar idade: ");
                    short idadeEditada = scan.nextShort();
                    Dividir.dividirTerminal();
                    if (idadeEditada == 0) {
                        break;
                    }

                    boolean idadeEncontrada = idades.contains(idadeEditada);

                    if (idadeEncontrada) {
                        int indexEditada = idades.indexOf(idadeEditada);
                        idadesForamEditadas.add(idadeEditada);
                        System.out.println("Idade selecionada: [" + idadeEditada + "]");
                        System.out.println("Índice: [" + indexEditada + "]");
                        System.out.print("Nova idade: ");
                        idadeEditada = scan.nextShort();
                        Dividir.dividirTerminal();

                        if (idadeEditada < 0) {
                            System.out.println("A idade não pode ser negativa!");
                            Dividir.dividirTerminal();
                            break;
                        } else if (idadeEditada > 120) {
                            System.out.println("É pouco provável que exista alguém com essa idade!");
                            Dividir.dividirTerminal();
                            break;
                        }

                        idades.set(indexEditada, idadeEditada);
                        System.out.println("Idade editada!");
                        Dividir.dividirTerminal();
                    } else {
                        System.out.println("Idade não encontrada!");
                        Dividir.dividirTerminal();
                        break;
                    }

                    break;
                case 4:
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
                    byte choiceCase3 = scan.nextByte();
                    Dividir.dividirTerminal();
                    switch (choiceCase3) {
                        case 0:
                            break;
                        case 1:
                            /* Esse `num -> num < 18` é chamada de Lambda Expression, tem a mesma função que um forEach:
                            * for (Integer num : idades) {
                            *   if (num < 18) {
                            *   idades.remove(num);
                            *   }
                            * }
                            * */
                            boolean removedOption1 = idades.removeIf(num -> num < 18);
                            String msgCase3Option1 = (removedOption1)
                                    ? "Idade(s) removida(s)!" : "Faixa de idade não encontradas!";
                            System.out.println(msgCase3Option1);
                            break;
                        case 2:
                            boolean removedOption2 = idades.removeIf(num -> num >= 18 && num < 60);
                            String msgCase3Option2 = (removedOption2)
                                    ? "Idades removidas!" : "Faixa de idade não encontradas!";
                            System.out.println(msgCase3Option2);
                            break;
                        case 3:
                            boolean removedOption3 = idades.removeIf(num -> num >= 60);
                            String msgCase3Option3 = (removedOption3)
                                    ? "Idade(s) removida(s)!" : "Faixa de idade não encontradas!";
                            System.out.println(msgCase3Option3);
                            break;
                        case 4:
                            do {
                                System.out.print("Remover idade: ");
                                short rmvAge = scan.nextShort();
                                boolean removedOption4 = idades.remove(Short.valueOf(rmvAge));
                                String msgCase3Option4 = (removedOption4)
                                        ? "Idade removida!" : "Idade não encontrada!";
                                System.out.println(msgCase3Option4);
                                System.out.print("Continuar removendo? [S/N]: ");
                                continueCase3 = scan.next().toUpperCase();
                                Dividir.dividirTerminal();
                            } while (continueCase3.equals("S"));
                            break;
                        case 5:
                            System.out.println("Não é possível a recuperação das idades após o confirmamento dessa ação.");
                            System.out.print("Tem certeza dessa ação? [S/N]: ");
                            String respCase5 = scan.next().toUpperCase();
                            Dividir.dividirTerminal();

                            if (respCase5.equals("S")) {
                                idades.clear();
                                System.out.println("Lista limpa!");
                                Dividir.dividirTerminal();
                            }
                            break;
                        default:
                            System.out.println("Selecione uma opção válida!");
                    }
                    break;
                case 5:
                    if (idades.size() <= 1) {
                        System.out.println("Não é possível ordenar a lista com 1 elemento ou menos!");
                        Dividir.dividirTerminal();
                        break;
                    }
                    boolean goCase4 = true;
                    while (goCase4) {
                        System.out.println("Ordenar em ordem: ");
                        System.out.println("0. Voltar");
                        System.out.println("1. Crescente");
                        System.out.println("2. Decrescente");
                        System.out.print("Resposta: ");
                        byte choiceCase4 = scan.nextByte();
                        Dividir.dividirTerminal();
                        switch (choiceCase4) {
                            case 0:
                                goCase4 = false;
                                break;
                            case 1:
                                Collections.sort(idades);
                                System.out.println("Lista ordenada!");
                                Dividir.dividirTerminal();
                                goCase4 = false;
                                break;
                            case 2:
                                idades.sort(Collections.reverseOrder());
                                System.out.println("Lista ordenada!");
                                Dividir.dividirTerminal();
                                goCase4 = false;
                                break;
                            default:
                                System.out.println("Selecione uma opção válida!");
                                goCase4 = false;
                        }
                    }
                    break;
                case 6:
                    boolean goCase5 = true;
                    while (goCase5) {
                        System.out.println("0. Voltar");
                        System.out.println("1. Ver a soma de todas as idades");
                        System.out.println("2. Ver a média e mediana das idades");
                        System.out.println("3. Ver idades pares e ímpares");
                        System.out.println("4. Ver quantidade de menores de idade/adultos/idosos");
                        System.out.println("5. Ver alterações na lista");
                        System.out.print("Resposta: ");
                        byte choiceCase5 = scan.nextByte();
                        Dividir.dividirTerminal();
                        switch (choiceCase5) {
                            case 0:
                                goCase5 = false;
                                break;
                            case 1:
                                if (idades.size() <= 1) {
                                    System.out.println("Não é possível realizar essa ação " +
                                            "com a lista tendo 1 elemento ou menos!");
                                    Dividir.dividirTerminal();
                                    continue;
                                }
                                short somaCase5Option1 = 0;
                                for (short numbers : idades) {
                                    somaCase5Option1 += numbers;
                                }

                                System.out.println("A soma de todas as idades é: " + somaCase5Option1);
                                Dividir.dividirTerminal();
                                goCase5 = false;
                                break;
                            case 2:
                                if (idades.size() <= 1) {
                                    System.out.println("Não é possível realizar essa ação " +
                                            "com a lista tendo 1 elemento ou menos!");
                                    Dividir.dividirTerminal();
                                    continue;
                                }
                                short somaCase5Option2 = 0;
                                double mediaArith;
                                for (int num : idades) {
                                    somaCase5Option2 += (short) num;
                                }

                                mediaArith = (double) somaCase5Option2 / idades.size();
                                System.out.println("A média aritmética de todas as idades é " + mediaArith);

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
                                System.out.printf("A mediana das idades é %.2f!\n", mediana);
                                Dividir.dividirTerminal();
                                toCalcMediana.clear();
                                goCase5 = false;
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
                                goCase5 = false;
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
                                goCase5 = false;
                                break;
                            case 5:
                                boolean isEnableToBeHere = idadesAdicionadas.isEmpty() && idadesForamEditadas.isEmpty();
                                if (isEnableToBeHere) {
                                    System.out.println("Não houve alterações na lista!");
                                    Dividir.dividirTerminal();
                                    break;
                                }

                                System.out.println("Quantidades de idades adicionadas: " + idadesAdicionadas.size());
                                System.out.println("Idades adicionadas: " + idadesAdicionadas);
                                System.out.println("Quantidades de idades editadas: " + idadesForamEditadas.size());
                                System.out.println("Idades editadas: " + idadesForamEditadas);
                                Dividir.dividirTerminal();
                                goCase5 = false;
                                break;
                            default:
                                System.out.println("Selecione uma opção válida!");
                                Dividir.dividirTerminal();
                                goCase5 = false;
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("Selecione uma opção válida!");
                    Dividir.dividirTerminal();
                    break;
            }
        } while (go);
    }
}