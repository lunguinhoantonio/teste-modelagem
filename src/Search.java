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

}
