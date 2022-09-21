
import java.util.Objects;

public class CustomArrayList<T> {

    private int size = 0;

    private Object[] elementData;

    private static final int installSize = 10;

    /**
     * Конструктор - создание нового объекта
     */
    public CustomArrayList() {

        this.elementData = new Object[installSize];
    }

    /**
     * Метод добавление элемента в коллекцию
     */
    public void add(T obj) {
        grow();
        elementData[size] = obj;
        size++;
    }

    /**
     * Метод удаление элемента из коллекции
     */
    public void remove(Object obj) {
        for (int i = 0; i < this.size; i++) {
            if (elementData[i].equals(obj)) {
                int numMoved = size - i - 1;
                if (numMoved > 0) {
                    System.arraycopy(elementData, i + 1, elementData, i,
                            numMoved);
                    i--;
                }
                this.size--;
                elementData[size] = null;
            }
        }
    }


    /**
     * Метод очистки коллекции
     */
    public void removeAll(){
        Object[] es = elementData;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }

    private void grow() {
        if (size == elementData.length) {
            Object[] elementDataNew = new Object[size + 10];
            System.arraycopy(elementData, 0, elementDataNew, 0, size);
            elementData = elementDataNew;
        }
    }
    /**
     * Метод получение элемента из коллекции
     * @return возвращает элемент по индексу
     */
    public Object get(int index) {
        Objects.checkIndex(index, size);
        return this.elementData[index];
    }
}