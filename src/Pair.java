import java.util.UUID;

/**
 *
 * @author crohde
 *
 * A simple pair class for poor Java 8 users 
 * who don't want to use javafx.util or AbstractMap.SimpleEntry.
 *
 * @param <T1>
 * @param <T2>
 */
public class Pair<T1, T2> {

    public T1 key;
    public T2 value;

    public Pair() {
        // Nothing
    }

    public Pair(T1 key, T2 value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(T1 key) {
        this.key = key;
    }

    public void setValue(T2 value) {
        this.value = value;
    }


}