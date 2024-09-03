import java.util.ArrayList;
import java.util.Collections;

public class Search {
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

    public static short frequencyAge(ArrayList<Short> list, short element) {
        short cont = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == element) {
                cont++;
            }
        }
        return cont;
    }

    public static short findIndex(ArrayList<Short> ages, short age, boolean isAscending, boolean isDescending) {
        if (isAscending) {
            return Search.bynarySearchAscending(ages, age);
        } else if (isDescending) {
            return Search.bynarySearchDescending(ages, age);
        } else {
            return (short) ages.indexOf(age);
        }
    }

    public static void processAgeList(String action, ArrayList<Short> manipulatedAges) {
        if (manipulatedAges.isEmpty()) {
            System.out.println("Nenhuma idade foi " + action + "!");
        } else {
            System.out.println("Quantidades de idades " + action + "s: " + manipulatedAges.size());
            System.out.println("Idades " + action + "s: " + manipulatedAges);
        }
    }

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

    public static void processListOrdered(String action, byte listOrderedOrNot) {
        System.out.println("Quantidade de vezes que a lista foi " + action + ": " + listOrderedOrNot);
    }

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

}
