import java.util.ArrayList;
import java.util.Collections;

public class Search {
    // Método que faz a busca binária de forma que os números estão ordenados de forma crescente
    public static short bynarySearchAscending(ArrayList<Short> list, short target) {
        short start = 0;
        short end = (short) (list.size() - 1);

        while (start <= end) {
            short mid = (short) ((start + end) / 2);

            if (list.get(mid) == target) {
                return mid;
            }
            if (list.get(mid) < target) {
                start = (short) (mid + 1);
            } else {
                end = (short) (mid - 1);
            }
        }
        return -1;
    }

    // Método que faz a busca binária de forma que os números estão ordenados de forma decrescente
    public static short bynarySearchDescending(ArrayList<Short> list, short target) {
        short start = 0;
        short end = (short) (list.size() - 1);

        while (start <= end) {
            short mid = (short) ((start + end) / 2);

            if (list.get(mid) == target) {
                return mid;
            }
            if (list.get(mid) > target) {
                start = (short) (mid + 1);
            } else {
                end = (short) (mid - 1);
            }
        }
        return -1;
    }
    // Método que faz a contagem da frequência da idade
    public static short frequencyAge(ArrayList<Short> list, short element) {
        short cont = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == element) {
                cont++;
            }
        }
        return cont;
    }
    // Faz a busca do índice e ainda escolhe de forma automática se vai fazer a busca binária ou linear
    public static short findIndex(ArrayList<Short> ages, short age, boolean isAscending, boolean isDescending) {
        if (isAscending) {
            return Search.bynarySearchAscending(ages, age);
        } else if (isDescending) {
            return Search.bynarySearchDescending(ages, age);
        } else {
            return (short) ages.indexOf(age);
        }
    }
    // Método que automatiza a exibição das mensagens de idades que foram manipuladas
    public static void processAgeList(String action, ArrayList<Short> manipulatedAges) {
        if (manipulatedAges.isEmpty()) {
            System.out.println("Nenhuma idade foi " + action + "!");
        } else {
            System.out.println("Quantidades de idades " + action + "s: " + manipulatedAges.size());
            System.out.println("Idades " + action + "s: " + manipulatedAges);
        }
    }

    // Método que automatiza a exibição das mensagens de idades pares e ímpares
    public static void printNumbers(ArrayList<Byte> numbers, String desc) {
        if (numbers.isEmpty()) {
            System.out.println("Não existem números " + desc + "!");
        } else {
            Collections.sort(numbers);
            System.out.println(desc.substring(0, 1).toUpperCase() +
                    desc.substring(1) + ": " + numbers.size() +
                    ", e são eles: " + numbers);
        }
    }

    // Método que automatiza a exibição da quantidade de vezes que a lista foi ordenada e desfeita
    public static void processListOrdered(String action, byte listOrderedOrNot) {
        System.out.println("Quantidade de vezes que a lista foi " + action + ": " + listOrderedOrNot);
    }

    // Método que automatiza a exibição das listas de menores de idade, adultos e idosos
    public static void printAgeGroup(ArrayList<Byte> ageGroup, String groupName) {
        if (ageGroup.isEmpty()) {
            System.out.println("Não tem " + groupName + "!");
        } else {
            Collections.sort(ageGroup);
            System.out.println(groupName.substring(0, 1).toUpperCase() +
                    groupName.substring(1) + ": " + ageGroup.size() +
                    ", e são eles: " + ageGroup);
        }
    }

    // Método que checa se o ArrayList tã vazio
    public static boolean checkArrayListIsEmpty(ArrayList<Short> ages, String message) {
        if (ages.isEmpty()) {
            System.out.println(message);
            Dividir.dividirTerminal();
            return true;
        }
        return false;
    }

    // Método que checa se o ArrayList tem pelo menos 1 elemento
    public static boolean checkArrayListHasAtLeast1Element(ArrayList<Short> ages) {
        if (ages.size() <= 1) {
            System.out.println("Não é possível ordenar a lista com 1 elemento ou menos!");
            Dividir.dividirTerminal();
            return true;
        }
        return false;
    }


}
