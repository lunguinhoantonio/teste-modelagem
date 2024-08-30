import java.util.ArrayList;

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

}
