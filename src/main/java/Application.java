import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        customArrayList.add("m");
        customArrayList.add("c");
        customArrayList.add("z");

        System.out.println(customArrayList.get(1));

        customArrayList.removeAll();

        //CustomArrays.quickSort(customArrayList, (String, t1) -> t1 + String);


    }
}
