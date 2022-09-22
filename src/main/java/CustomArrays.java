
import java.util.Comparator;

public class CustomArrays {

    public static <T> void quickSort(CustomArrayList<T> customArrayList, Comparator<T> comparator) {
        quickSort(customArrayList, 0, customArrayList.size() - 1, comparator);
    }

    private static <T> void quickSort(CustomArrayList<T> arrayList, int begin, int end,
                                      Comparator<T> comparator) {
        if (begin < end) {
            int partitionIndex = partition(arrayList, begin, end, comparator);

            quickSort(arrayList, begin, partitionIndex-1, comparator);
            quickSort(arrayList, partitionIndex+1, end, comparator);
        }
    }

    private static <T> int partition(CustomArrayList<T> customArrayList, int begin, int end,
                                     Comparator<T> comparator) {
        T pivot = customArrayList.get(end);
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (comparator.compare(customArrayList.get(j), pivot) > 0) {
                i++;
                customArrayList.set(j, customArrayList.set(i, customArrayList.get(j)));
            }
        }

        customArrayList.set(end, customArrayList.set(i+1, customArrayList.get(end)));

        return i+1;
    }
}
