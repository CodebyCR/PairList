import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * You can use this class in a similar way like an EntrySet, but duplicates are allowed.
 * You can handle duplicated entrys with contains() and containsPairLike().
 * @author crohde
 *
 * @param <T1>
 * @param <T2>
 */
public class PairList<T1, T2> extends ArrayList<Pair<T1, T2>> {


    /**
     * @param value
     * @return a PairList with the indexes of the pairs in the current list and his keys.
     */
    public PairList<Integer, T1> getKeysByValue(T2 value){
        PairList<Integer, T1> keys = new PairList<Integer, T1> ();

        for (int index = 0; index < this.size(); index ++) {
            if (value.equals(this.get(index).value)) {
                keys.add(index, this.get(index).key);
            }
        }
        return keys;
    }

    public List<T1> getKeys(){
        List<T1> list = new ArrayList<T1>();
        for(Pair<T1, T2> currentPair : this) {
            list.add(currentPair.key);
        }
        return list;
    }

    /**
     * @param key
     * @return a PairList with the indexes of the pairs in the current list and his values.
     */
    public PairList<Integer, T2> getValuesByKey(T1 key){
        PairList<Integer, T2> values = new PairList<Integer, T2> ();

        for (int index = 0; index < this.size(); index ++) {
            if (key.equals(this.get(index).key)) {
                values.add(index, this.get(index).value);
            }
        }
        return values;
    }

    public List<T2> getValues(){

        List<T2> list = new ArrayList<T2>();
        for(Pair<T1, T2> currentPair : this) {
            list.add(currentPair.value);
        }
        return list;
    }

    /**
     * This methode is related to the attributes of the given pair. <br/>
     * If you want to relate to the pair as an Object use contains.
     *
     * @param pair
     * @return true if this list contins a pair with duplicated attributes (key & value) like the given pair.
     */
    public boolean containsPairLike(Pair<T1, T2> pair) {
        for(Pair<T1, T2> currentPair : this) {
            if(currentPair.key.equals(pair.key) && currentPair.value.equals(pair.value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This methode is related to the attributes of the given pair. <br/>
     * If you want to relate to the pair as an Object use contains.
     *
     * @param key
     * @param value
     * @return true if this list contins a pair with duplicated attributes (key & value) like the given pair.
     */
    public boolean containsPairLike(T1 key, T2 value) {
        for(Pair<T1, T2> currentPair : this) {
            if(currentPair.key.equals(key) && currentPair.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsKey(T1 key) {
        for(Pair<T1, T2> currentPair : this) {
            if(currentPair.key.equals(key) ) {
                return true;
            }
        }
        return false;
    }

    public int containsKeyCount(T1 key) {
        int keyCount = 0;

        for(Pair<T1, T2> currentPair : this) {
            if(currentPair.key.equals(key) ) {
                keyCount += 1;
            }
        }
        return keyCount;
    }

    public boolean containsValue(T2 value) {
        for(Pair<T1, T2> currentPair : this) {
            if(currentPair.value.equals(value) ) {
                return true;
            }
        }
        return false;
    }

    public Integer getIndexByPair(Pair<T1, T2> pair) {

        for(int index = 0; index < this.size(); index ++) {
            if (pair.equals(this.get(index))) {
                return index;
            }
        }
        return null;
    }
    public boolean add(T1 key, T2 value) {
        return this.add(new Pair<T1, T2>(key, value));
    }

    /**
     * This methode is similar to <b>if(list.contains(pair_1) && list.contains(pair_2) && ...) </b>,
     * but it's more performant and easier to read.
     * @param pairs
     * @return if this list contains all the given pairs it's true, else it's false.
     */
    public boolean containsAllOf(Pair<T1, T2>... pairs) {
        for(Pair<T1, T2> currentPair : pairs) {
            if(!this.contains(currentPair)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This methode is similar to <b>if(list.contains(pair_1) || list.contains(pair_2) || ...) </b>,
     * but it's more performant and easier to read.
     * @param pairs
     * @return if this list contains at least one of the given pairs it's true, else it's false.
     */
    public boolean containsOneOf(Pair<T1, T2>... pairs) {
        for(Pair<T1, T2> currentPair : pairs) {
            if(this.contains(currentPair)) {
                return true;
            }
        }
        return false;
    }




    /**
     * Merge all pairs with the same key and separates the values by "<b>,</b>".
     * If they the same, only one pair leaves in the list.
     * @param key
     * @return true if pairs merged at least one time.
     */
    public boolean mergeDuplicatedKey(T1 key) {
        //TODO: Make it more efficient and runnable.
        Iterator<Pair<Integer, T2>> valueIterator = this.getValuesByKey(key).iterator();
        boolean hasMerged = false;
        T2 currentValue = null;

        while(valueIterator.hasNext()) {
            Pair<Integer, T2> currentPair = valueIterator.next();
            currentValue = currentPair.value;

            if(currentValue.equals(currentPair.value)) {
                hasMerged = true;
                this.remove(currentPair.key);
            }
        }
        return hasMerged;
    }

}