
import java.util.Objects;

public class CustomArrayList<T> {

    private int size = 0;

    private Object[] elementData;

    private static final int installSize = 10;

    public CustomArrayList() {
        this.elementData = new Object[installSize];
    }

    public void add(T obj) {
        grow();
        elementData[size] = obj;
        size++;
    }

    public T set(int index, T element) {
        Objects.checkIndex(index, size);
        T oldElem = (T) this.elementData[index];
        this.elementData[index] = element;
        return oldElem;
    }

    public boolean remove(Object obj) {
        int startSize = this.size;
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
        return this.size != startSize;
    }

    private void grow() {
        if (size == elementData.length) {
            Object[] elementDataNew = new Object[size + 10]; // Правило определяет себя
            System.arraycopy(elementData, 0, elementDataNew, 0, size);
            elementData = elementDataNew;
        }
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) this.elementData[index];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0 ? true : false;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < this.size; i++) {
            Object obj = this.elementData[i];
            if (Objects.nonNull(obj) && obj.equals(o)) {
                return true;
            }
        }
        return false;
    }

    public Object[] toArray() {
        Object[] newArray = new Object[this.size];
        System.arraycopy(newArray, 0, this.elementData, 0, this.size);
        return newArray;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomArrayList{");
        sb.append("size=").append(this.size);
        sb.append(", elementData=[");
        if (this.size > 0) {
            int i = 0;
            while (true) {
                sb.append(this.elementData[i]);
                ++i;
                if (i == this.size) {
                    sb.append(']');
                    break;
                }
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

}