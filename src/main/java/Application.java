
public class Application {

    public static void main(String[] args) {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();

        System.out.println("List empty : " + customArrayList.isEmpty());

        customArrayList.add("Boris");
        customArrayList.add("Armen");
        customArrayList.add("Dororo");
        customArrayList.add("Abramah");
        customArrayList.add("Armen");
        customArrayList.add("Armen5");

        System.out.println("Init : " + customArrayList);
        System.out.println("List empty : " + customArrayList.isEmpty());

        CustomArrays.quickSort(customArrayList, (s1, s2) -> s2.compareTo(s1));
        System.out.println("After quick sort : " + customArrayList);

        customArrayList.remove("Armen");
        System.out.println("After remove \"Armen\" : " + customArrayList);

        System.out.println("List contains \"Armen\" : " + customArrayList.contains("Armen"));
        System.out.println("List contains \"Armen5\" : " + customArrayList.contains("Armen5"));

    }
}
