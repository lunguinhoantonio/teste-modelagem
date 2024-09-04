import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean go = true;
        boolean isListOrganizedAscending = false;
        boolean isListOrganizedDescending = false;
        // Mensagem padrão para quando digitar um código errado
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
            // Exibição da lista de idades
            System.out.println("Lista de idades: " + ages);
            // Exibição das opções válidas
            Options.mainOption();
            // Captura da escolha do usuário
            byte choice = scan.nextByte();
            // Método para melhorar a legibilidade no terminal
            Dividir.dividirTerminal();

            switch (choice) {
                // Encerra o programa
                case 0:
                    // Interrompe a captura de entradas do usuário
                    scan.close();
                    // Limpa a lista de idades, removendo todos os elementos
                    ages.clear();
                    // Exibe uma mensagem de despedida
                    System.out.println("Espero ter gostado do programa! :D");
                    // Organiza o terminal
                    Dividir.dividirTerminal();
                    // Muda o valor de go para false, encerrando o loop principal
                    go = false;
                    break;
                // Mostra a quantidade de elementos na lista
                case 1:
                    /* Verifica se a lista tá ordenada, se estiver, mostra a cópia da lista ages.
                     * se não, mostra o tamanho da lista original, mais para frente eu explico o porquê
                     * de eu ter feito assim
                     */
                    System.out.println(isListOrganizedAscending || isListOrganizedDescending ?
                            "Quantidade de idades na lista: " + copyOfAges.size() :
                            "Quantidade de idades na lista: " +  ages.size());
                    Dividir.dividirTerminal();
                    break;
                // Toda a manipulação dentro da lista faz aqui
                case 2:
                    // Exibição do submenu
                    Options.case2();
                    // Captura a escolha do usuário
                    byte choiceCase2 = scan.nextByte();
                    Dividir.dividirTerminal();
                    switch (choiceCase2) {
                        // Encerra o submenu
                        case 0:
                            break;
                        // Exibe um submenu com opções para adicionar idades com jeitos diferentes
                        case 1:
                            // Criação da variável para adicionar o número
                            short addAge;
                            // Exibição das opções
                            Options.case2Opt1();
                            // Captura da escolha do usuário
                            byte subChoice1 = scan.nextByte();
                            Dividir.dividirTerminal();
                            switch (subChoice1) {
                                // Encerra o submenu
                                case 0:
                                    break;
                                // Solicita previamente quantas idades o usuário pretende adicionar
                                case 1:
                                    // Exibição
                                    System.out.print("Quantas idades deseja adicionar? ");
                                    // Coleta do valor do usuário
                                    short numberAges = scan.nextShort();
                                    // Entra num loop for que se encerra quando chega no valor que o usuário colocou anteriormente
                                    for (int c = 0; c < numberAges; c++) {
                                        System.out.print("Adicionar idade: ");
                                        addAge = scan.nextShort();
                                        // Faz a validação da idade que o usuário digitou
                                        if (addAge < 0) {
                                            System.out.println("A idade não pode ser negativa!");
                                            Dividir.dividirTerminal();
                                        } else if (addAge > 115) {
                                            System.out.println("É pouco provável que exista alguém com essa idade!");
                                            Dividir.dividirTerminal();
                                            // Se passar pela validação, o número é adicionado
                                        } else {
                                            // Adiciona a idade na lista de idades
                                            ages.add(addAge);
                                            /* Adiciona a idade que foi adicionada à lista de idades que foram adicionadas
                                             * que é usado posteriormente nas alterações da lista
                                             */
                                            addedAges.add(addAge);
                                            // Exibe a mensagem de confirmação
                                            System.out.println("Idade adicionada!");
                                            Dividir.dividirTerminal();
                                        }
                                    }
                                    // Exibe a mensagem da ação concluída
                                    System.out.println("Lista atualizada!");
                                    Dividir.dividirTerminal();
                                    break;
                                // Permite ao usuário adicionar idades de forma contínua, até que ele decida parar
                                case 2:
                                    String continueCase2Opt2 = "";
                                    // Estrutura que continua até que o usuário digite qualquer valor exceto o "S"
                                    do {
                                        System.out.print("Adicionar idade: ");
                                        addAge = scan.nextShort();
                                        // A mesma validação no bloco anterior acontece aqui
                                        if (addAge < 0) {
                                            System.out.println("A idade não pode ser negativa!");
                                            continue;
                                        } else if (addAge > 115) {
                                            System.out.println("É pouco provável que exista alguém com essa idade!");
                                            continue;
                                        } else {
                                            // A idade é adicionada na lista de idades
                                            ages.add(addAge);
                                            /* A idade que foi adicionada na lista de idades,
                                             * também é adicionada na lista de
                                             * idades que foram adicionadas pelo usuário
                                             */
                                            addedAges.add(addAge);
                                        }
                                        // Pergunta para verificar se o usuário deseja adicionar mais idades
                                        System.out.print("Continuar adicionando? [S/N]: ");
                                        // Coleta do valor
                                        /* o .toUpperCase() serve para que o usuário não necessite digitar exatamente a
                                         * letra em maiúscula para validar sua opção
                                         */
                                        continueCase2Opt2 = scan.next().toUpperCase();
                                        Dividir.dividirTerminal();
                                        // Se o valor for "S", repete a estrutura
                                    } while (continueCase2Opt2.equals("S"));
                                    // Confirmação da ação
                                    System.out.println("Idades adicionadas!");
                                    Dividir.dividirTerminal();
                                    break;
                                // Exibe a mensagem de erro caso o usuário insira um valor inválido
                                default:
                                    System.out.println(msgInvalidOpt);
                                    Dividir.dividirTerminal();
                            }
                            break;
                        case 2:
                            // Faz a checagem se a lista está vazia
                            // Se estiver, mostra uma mensagem de erro e sai do loop
                            if (Search.checkArrayListIsEmpty
                               (ages, "Não é possível editar a lista porque ela está vazia!")) {
                                break;
                            }

                            System.out.println("0. Cancelar");
                            // Solicita a idade que vai ser editada
                            System.out.print("Selecionar idade: ");
                            short editAge = scan.nextShort();
                            // Método para melhorar a legibilidade no terminal
                            Dividir.dividirTerminal();
                            // Se o valor que o usuário digitar for 0, sai do loop
                            if (editAge == 0) {
                                break;
                            }
                            // Fazendo a busca do índice da idade para editar
                            int editedIndex = Search.findIndex(
                                    ages,
                                    editAge,
                                    isListOrganizedAscending,
                                    isListOrganizedDescending);
                            // Verificando se a idade foi encontrada
                            if (editedIndex != -1) {
                                // A idade que foi encontrada é adicionada na lista de idades editadas
                                editAges.add(editAge);
                                // Solicitação da nova idade
                                System.out.print("Nova idade: ");
                                editAge = scan.nextShort();
                                Dividir.dividirTerminal();

                                // Validando a nova idade que foi inserida
                                if (editAge < 0 || editAge > 115) {
                                    System.out.println(editAge < 0 ?
                                            "A idade não pode ser negativa!" :
                                            "É pouco provável que exista alguém com essa idade!");
                                    Dividir.dividirTerminal();
                                    break;
                                }
                                // Atualizando a idade na lista
                                ages.set(editedIndex, editAge);
                                System.out.println("Idade editada!");
                            } else {
                                // Caso a idade não for encontrada, exibe essa mensagem
                                System.out.println("Idade não encontrada!");
                            }
                            Dividir.dividirTerminal();
                            break;
                        case 3:
                            // Verifica se a lista está vazia, se estiver, mostra uma mensagem e sai do loop
                            if (Search.checkArrayListIsEmpty(ages, "A lista já está vazia!")) {
                                break;
                            }
                            // Exibe o submenu
                            Options.case2Opt3();
                            // Coleta a escolha do usuário
                            byte subChoice3 = scan.nextByte();
                            Dividir.dividirTerminal();
                            switch (subChoice3) {
                                // A operação é cancelada
                                case 0:
                                    break;
                                // Remove todas as idades menores que 18
                                case 1:
                                    /* Uma variável do tipo booleana que percorre toda a lista ages
                                     * e remove os elementos que atendem a uma condição específica
                                     * (por isso usei o removeIf).
                                     * A condição é fornecida como uma expressão lambda, que é esse (num -> {...})
                                     * onde (num) representa cada elemento da lista ages, como se fosse um forEach
                                     */
                                    boolean feedbackCase3Opt1 = ages.removeIf(num -> {
                                        // Verifica se o valor da lista é menor que 18
                                        if (num < 18) {
                                            // Adiciona o número que vai ser removido na lista de idades que foram removidas
                                            removedAges.add(num);
                                            // Remove o número também na lista de cópia para não ocorrer o erro do número voltar
                                            copyOfAges.remove(num);
                                            // Retorna true para indicar que o valor foi encontrado e removido
                                            return true;
                                        }
                                        // Se nenhuma idade for encontrada, retorna false
                                        return false;
                                    });
                                    /* Variável String que recebe o valor do boolean anterior,
                                     * utilizei a operação ternária por ser mais simples que o if/else e
                                     * não consumir tantas linhas de código.
                                     * Se o valor da booleana for true, o valor da String passa a ser
                                     * "Idade(s) removida(s)!". Se o valor for false, o valor da String passa a ser
                                     * "Faixa de idade não encontrada!"
                                     */
                                    String msgCase3Opt1 = (feedbackCase3Opt1)
                                            ? "Idade(s) removida(s)!" : "Faixa de idade não encontrada!";
                                    // Exibe o valor da String na tela
                                    System.out.println(msgCase3Opt1);
                                    Dividir.dividirTerminal();
                                    break;
                                /* Remove todas as idades iguais ou maiores que 18 e menores que 60 que utiliza a mesma
                                 * lógica do bloco anterior
                                 */
                                case 2:
                                    boolean feedbackCase3Opt2 = ages.removeIf(num -> {
                                        if (num >= 18 && num < 60) {
                                            // Adiciona o valor na lista de idades que foram removidas pelo usuário
                                            removedAges.add(num);
                                            // Remove o valor na lista de cópia também para evitar erros
                                            copyOfAges.remove(num);
                                            // Retorna true
                                            return true;
                                        }
                                        // Se nenhum valor for encontrado, retorna false
                                        return false;
                                    });
                                    /* Se o valor do boolean for true, o valor de String passa a ser "Idades removidas",
                                     * Se não, o valor da String passa a ser "Faixa de idade não encontrada"
                                     */
                                    String msgCase3Opt2 = (feedbackCase3Opt2)
                                            ? "Idades removidas!" : "Faixa de idade não encontrada!";
                                    // Exibe a mensagem dependendo do valor da String
                                    System.out.println(msgCase3Opt2);
                                    Dividir.dividirTerminal();
                                    break;
                                // Remove todos os valores iguais ou acima de 60
                                case 3:
                                    // Segue a mesma lógica dos outros blocos que sinceramente tô cansado de explicar
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
                                // Remoção específica de idades, uma por vez
                                case 4:
                                    // Criação da variável que vai controlar o controle do fluxo do loop
                                    String continueCase4;
                                    do {
                                        // Solicitação da idade que deseja remover
                                        System.out.print("Remover idade: ");
                                        // Leitura da idade inserida
                                        short rmvAge = scan.nextShort();
                                        /* Faz verificação se a lista tá organizada de forma crescente, se estiver, faz
                                         * a busca binária da forma crescente */
                                        if (isListOrganizedAscending) {
                                            // Faz a busca binária que vai retornar o índice do valor encontrado
                                            int index = Search.bynarySearchAscending(ages, rmvAge);
                                            // Se o índice for diferente de -1, quer dizer que a idade foi encontrada
                                            if (index != -1) {
                                                // Adiciona a idade removida à lista de idades removidas pelo usuário
                                                removedAges.add(rmvAge);
                                                // Remove a idade na lista de cópia para evitar erros
                                                copyOfAges.remove(Short.valueOf(rmvAge));
                                                // E por último, remove a idade da lista de idades original
                                                ages.remove(Short.valueOf(rmvAge));
                                                // Exibe a mensagem confirmando a remoção
                                                System.out.println("Idade removida!");
                                            } else {
                                                /* Se a idade não for encontrada,
                                                 * exibe a mensagem que a idade não foi encontrada
                                                 */
                                                System.out.println("Idade não encontrada!");
                                            }
                                            /* Verifica se a lista tá organizada de forma decrescente e faz a mesma
                                             * coisa que o bloco anterior
                                             */
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
                                            // Se não tiver organizada, faz a busca linear padrão
                                        } else {
                                            /* Usa quase o mesmo conceito do removeIf de alguns blocos atrás,
                                             * só que remove o número que foi encontrado de primeira.
                                             * Se o valor do boolean retornar true, é porque o número foi encontrado e
                                             * apagada, se não é porque não foi encontrada.
                                             * O Short.valueOf() vai apagar o primeiro valor específico que for
                                             * encontrado, sem a necessidade de buscar o índice do valor */
                                            boolean removedOpt4 = ages.remove(Short.valueOf(rmvAge));
                                            // Se o valor retornar true, cai nesse bloco
                                            if (removedOpt4) {
                                                // Adiciona à lista de idades que foram removidas pelo usuário
                                                removedAges.add(rmvAge);
                                                // Remove o valor da lista de cópias
                                                copyOfAges.remove(Short.valueOf(rmvAge));
                                                // Exibe a confirmação da idade removida
                                                System.out.println("Idade removida!");
                                            // Se o valor retornar false, cai nesse bloco
                                            } else {
                                                System.out.println("Idade não encontrada!");
                                            }
                                        }
                                        // Pergunta se deseja continuar removendo outras idades
                                        System.out.print("Continuar removendo? [S/N]: ");
                                        // Lê a resposta do usuário
                                        continueCase4 = scan.next().toUpperCase();
                                        Dividir.dividirTerminal();
                                        // O código executará enquanto o usuário digitar "S"
                                    } while (continueCase4.equals("S"));
                                    break;
                                // Remove todas as idades da lista
                                case 5:
                                    /* Exibe uma mensagem informando que todas as idades serão
                                     * removidas se o usuário confirmar a ação
                                     */
                                    System.out.println("Todas as idades serão removidas após o confirmamento dessa ação.");
                                    System.out.print("Tem certeza dessa ação? [S/N]: ");
                                    // Leitura da resposta do usuário
                                    String respCase5 = scan.next().toUpperCase();
                                    Dividir.dividirTerminal();

                                    // Se a resposta do usuário for "S", cai nesse bloco
                                    if (respCase5.equals("S")) {
                                        // Adiciona todas as idades à lista de idades que foram removidas pelo usuário
                                        removedAges.addAll(ages);
                                        // Limpa a lista de idades
                                        ages.clear();
                                        // Exibe a mensagem confirmando que a lista foi limpa com êxito
                                        System.out.println("Lista limpa!");
                                        Dividir.dividirTerminal();
                                    }
                                    break;
                                // Exibe a mensagem de erro caso o usuário insira um valor inválido
                                default:
                                    System.out.println(msgInvalidOpt);
                                    Dividir.dividirTerminal();
                            }
                            break; // Break do case 3
                    }
                    break; // Break do case 2
                // Faz a ordem da lista
                case 3:
                    // Verifica se a lista contém pelo menos 1 elemento
                    if (Search.checkArrayListHasAtLeast1Element(ages)) {
                        break;
                    }
                    // Exibe o menu de opções
                    System.out.println("Ordenar em ordem: ");
                    System.out.println("0. Voltar");
                    /* Aqui as opções mudam dependendo se a lista tá organizada ou não,
                     * se a lista crescente tá organizada, exibe o valor antes dos dois pontos (:), se não, mostra o
                     * valor depois dos dois pontos (:). Isso se chama operação ternária */
                    System.out.println("1. " + (isListOrganizedAscending ? "Desfazer ordem crescente" : "Crescente"));
                    /* A mesma lógica vale para esse, se a lista tá organizada em ordem decrescente,
                    exibe o valor de antes dos dois pontos, se não, exibe o valor depois dos dois pontos */
                    System.out.println("2. " + (isListOrganizedDescending ? "Desfazer ordem decrescente" : "Decrescente"));
                    System.out.print("Resposta: ");
                    // Leitura do valor do usuário
                    byte choiceCase5 = scan.nextByte();
                    Dividir.dividirTerminal();
                    switch (choiceCase5) {
                        // Retorna ao menu principal sem fazer alterações
                        case 0:
                            break;
                        // Ordena em ordem crescente ou desfaz a ordem crescente
                        case 1:
                            /* Verifica se a lista já tá organizada em ordem decrescente, se estiver, muda o valor
                             * da lista decrescente para false
                             */
                            if (isListOrganizedDescending) {
                                isListOrganizedDescending = false;
                            }
                            /* Verifica se a lista já tá organizada em ordem crescente,
                             * se estiver, vai executar esse bloco
                             */
                            if (isListOrganizedAscending) {
                                // A lista de idades original é limpa
                                ages.clear();
                                // Todos os elementos da lista de cópia das idades são adicionadas na lista de idades originais
                                ages.addAll(copyOfAges);
                                // Troca o valor da lista organizada em ordem crescente para false
                                isListOrganizedAscending = false;
                                // Incrementa o valor da quantidade de vezes que a lista foi desfeita
                                listUnordered++;
                                // Exibe a mensagem que a ordem foi desfeita
                                System.out.println("Ordem desfeita!");
                            // Se a lista não tá organizada, executa esse bloco
                            } else {
                                // Organiza a lista de idades original em ordem crescente
                                Collections.sort(ages);
                                // Muda o valor boolean se a lista tá organizada em ordem crescente para true
                                isListOrganizedAscending = true;
                                // Incrementa o valor da quantidade de vezes que a lista foi ordenada
                                listOrdered++;
                                // Exibe a mensagem que a lista foi ordenada
                                System.out.println("Lista ordenada!");
                            }

                            Dividir.dividirTerminal();
                            break;
                        // Ordena em ordem decrescente ou desfaz a ordem decrescente
                        case 2:
                            /* Verifica se a lista já tá organizada em ordem crescente, se estiver, muda o valor
                             * da lista crescente para false
                             */
                            if (isListOrganizedAscending) {
                                isListOrganizedAscending = false;
                            }
                            /* Verifica se a lista já tá organizada em ordem decrescente,
                             * se estiver, vai executar esse bloco
                             */
                            if (isListOrganizedDescending) {
                                ages.clear();
                                ages.addAll(copyOfAges);
                                isListOrganizedDescending = false;
                                listUnordered++;
                                System.out.println("Ordem desfeita!");
                            } else {
                                // Realiza a ordem decrescente
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
                            // Verifica se nenhuma idade foi adicionada
                            addedAges.isEmpty() &&
                            // Verifica se nenhuma idade foi editada
                            editAges.isEmpty() &&
                            // Verifica se nenhuma idade foi removida
                            removedAges.isEmpty() &&
                            // Verifica se a lista não foi ordenada nenhuma vez
                            listOrdered == 0 &&
                            // Verifica se a lista não foi desfeita nenhuma vez
                            listUnordered == 0;
                    // Exibe as opções
                    Options.case4();
                    byte choiceCase4 = scan.nextByte();
                    Dividir.dividirTerminal();
                    switch (choiceCase4) {
                        // Cancela as operações
                        case 0:
                            break;
                        // Soma todas as idades
                        case 1:
                            // Verifica se a lista tem pelo menos 1 elemento
                            if (Search.checkArrayListHasAtLeast1Element(ages)) {
                                continue;
                            }
                            // Essa variável armazenará a soma de todas as idades
                            short sumCase4Opt1 = 0;
                            // Um loop forEach que a cada iteração, o valor de numbers é adicionado à soma
                            for (short numbers : ages) {
                                sumCase4Opt1 += numbers;
                            }
                            // Exibe a soma
                            System.out.println("A soma de todas as idades é: " + sumCase4Opt1);
                            Dividir.dividirTerminal();
                            break;
                        // Ver média e mediana
                        case 2:
                            if (Search.checkArrayListHasAtLeast1Element(ages)) {
                                continue;
                            }
                            short sumCase4Opt2 = 0;
                            float mediaArith;
                            for (int num : ages) {
                                sumCase4Opt2 += (short) num;
                            }
                            // Fazendo o cálculo da média aritmética e exibindo na tela
                            mediaArith = (float) sumCase4Opt2 / ages.size();
                            System.out.printf("A média aritmética de todas as idades é %.2f!", mediaArith);

                            // Fazendo a clonagem dos elementos do ArrayList idades para toCalcMedian
                            ArrayList<Short> toCalcMedian = new ArrayList<>(ages);
                            float median;
                            short t = (short) toCalcMedian.size();
                            // Ordenando em ordem crescente
                            Collections.sort(toCalcMedian);
                            // Se o tamanho do array for par, executa esse bloco
                            if (t % 2 == 0) {
                                median = (float) ((toCalcMedian.get(t / 2 - 1)
                                        + toCalcMedian.get(t / 2)) / 2.0);
                            // Se não, executa esse
                            } else {
                                median = toCalcMedian.get(t / 2);
                            }
                            // Exibe o resultado na tela
                            System.out.printf("\nA mediana das idades é %.2f!\n", median);
                            Dividir.dividirTerminal();
                            // Limpando a lista para economizar memória
                            toCalcMedian.clear();
                            break;
                        // Pares e Ímpares
                        case 3:
                            if (Search.checkArrayListIsEmpty
                               (ages, "Não é possível realizar essa ação se a lista está vazia!")) {
                                continue;
                            }
                            // Criando 2 arraylists para cada
                            ArrayList<Byte> even = new ArrayList<>();
                            ArrayList<Byte> odd = new ArrayList<>();
                            // um forEach que verifica se um número é par ou ímpar
                            for (int num : ages) {
                                if (num % 2 == 0) {
                                    even.add((byte) num);
                                } else {
                                    odd.add((byte) num);
                                }
                            }
                            // Um método que criei para ocupar menos espaço mas que mostra os números
                            Search.printNumbers(even, "pares");
                            Search.printNumbers(odd, "ímpares");

                            Dividir.dividirTerminal();
                            // Limpando as listas para economizar memória
                            even.clear();
                            odd.clear();
                            break;
                        // Mostra lista de menores de idade, adultos e idosos
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
                        // Restaurar idades removidas
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
                        // Ver alterações na lista
                        case 6:
                            /* O ponto de exclamação antes de uma variável booleana inverte o valor dela, exemplo:
                             * boolean logica = true;
                             * System.out.println(!logica); vai imprimir false. Então, se aquela variável der true, aqui
                             * vou assumir que é false */
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
                            // Se isEnableToBeHere for true, executa essa parte do código
                            System.out.println("Não houve alterações na lista!");
                            Dividir.dividirTerminal();
                            break;
                        // Buscar idade
                        case 7:
                            // Verifica se a lista de idades está vazia
                            if (Search.checkArrayListIsEmpty
                               (ages, "Não é possível realizar essa ação se a lista está vazia!")) {
                                continue;
                            }
                            // Entrada do usuário
                            System.out.print("Idade buscada: ");
                            short target = scan.nextShort();
                            Dividir.dividirTerminal();
                            // Faz a contagem da frequência da idade buscada
                            short count = Search.frequencyAge(ages, target);
                            // Verificação e exibição dos resultados
                            if (count == 0) {
                                System.out.println("Essa idade não existe!");
                            } else if (count == 1) {
                                System.out.println("A idade " + target + " aparece somente " + count + " vez!");
                            } else {
                                System.out.println("A idade " + target + " aparece " + count + " vezes!");
                            }
                            Dividir.dividirTerminal();
                            break;
                        // Restaurar todas as alterações
                        case 8:
                            if (!isEnableToBeHere) {
                                // Exibe a mensagem pedindo confirmação
                                Options.confirmCase4Opt8();
                                String respCase4Opt8 = scan.next().toUpperCase();
                                Dividir.dividirTerminal();
                                if (respCase4Opt8.equals("S")) {
                                    // Limpa a lista de idades que foram removidas pelo usuário
                                    removedAges.clear();
                                    // Limpa a lista de idades que foram adicionadas pelo usuário
                                    addedAges.clear();
                                    // Limpa a lista de idades que foram editadas pelo usuário
                                    editAges.clear();
                                    // Reseta os contadores de ordenação da lista
                                    listOrdered = 0;
                                    listUnordered = 0;
                                    // Limpa a lista de idades original
                                    ages.clear();
                                    // Restaura a lista ao seu estado original
                                    ages.addAll(firstOfAges);
                                    // Exibe a mensagem de confirmação da ação
                                    System.out.println("Todas as alterações foram restauradas!");
                                }
                            } else {
                                System.out.println("Não houve alterações na lista!");
                            }

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