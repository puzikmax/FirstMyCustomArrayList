

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomArrays {

    /*public static <T> void quickSort(CustomArrayList<T> customArrayList, Comparator<T> comparator) {
        quickSort(customArrayList, 0, customArrayList.size() - 1, comparator);
    }*/

    public static <T> void quickSort(ArrayList<T> arrayList, Comparator<T> comparator) {
        quickSort(arrayList, 0, arrayList.size() - 1, comparator);
    }

    private static <T> void quickSort(List<T> arrayList, int begin, int end,
                                      Comparator<T> comparator) {
        if (begin < end) {
            int partitionIndex = partition(arrayList, begin, end, comparator);

            quickSort(arrayList, begin, partitionIndex-1, comparator);
            quickSort(arrayList, partitionIndex+1, end, comparator);
        }
    }

    private static <T> int partition(List<T> arrayList, int begin, int end,
                                     Comparator<T> comparator) {
        T pivot = arrayList.get(end);
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (comparator.compare(arrayList.get(j), pivot) > 0) {
                i++;
                arrayList.set(j,arrayList.set(i,arrayList.get(j)));
            }
        }

        arrayList.set(end,arrayList.set(i+1,arrayList.get(end)));

        return i+1;
    }
}
