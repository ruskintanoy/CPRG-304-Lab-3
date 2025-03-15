package implementations;

import java.util.ArrayList;
import utilities.DictionaryADT;
import exceptions.DuplicateKeyException;

/**
 * Implementation of the DictionaryADT interface using ArrayLists.
 *
 * @param <K> The type of keys maintained by this dictionary.
 * @param <V> The type of mapped values.
 *
 * @author Ruskin
 * @author Laila
 */
public class Dictionary<K, V> implements DictionaryADT<K, V> {

    private static final int DEFAULT_SIZE = 10; // Default initial size
    private ArrayList<K> keys;
    private ArrayList<V> values;

    /**
     * Default constructor - Initializes dictionary with default size.
     */
    public Dictionary() {
        create(DEFAULT_SIZE);
    }

    /**
     * Constructor - Initializes dictionary with a specified size.
     *
     * @param size The initial size of the dictionary.
     */
    public Dictionary(int size) {
        create(size);
    }

    /**
     * Creates a new dictionary with a given size.
     * 
     * @param size The initial size of the dictionary.
     */
    @Override
    public void create(int size) {
        keys = new ArrayList<>(size);
        values = new ArrayList<>(size);
    }

    /**
     * Inserts a key-value pair into the dictionary.
     *
     * @param key   The key to be inserted.
     * @param value The value associated with the key.
     * @return true if successfully inserted.
     * @throws DuplicateKeyException If the key already exists.
     */
    @Override
    public boolean insert(K key, V value) throws DuplicateKeyException {
        if (keys.contains(key)) {
            throw new DuplicateKeyException("Key already exists: " + key);
        }
        keys.add(key);
        values.add(value);
        return true;
    }

    /**
     * Removes a key-value pair from the dictionary.
     *
     * @param key The key to remove.
     * @return The removed value, or null if the key does not exist.
     */
    @Override
    public V remove(K key) {
        int index = keys.indexOf(key);
        if (index == -1) {
            return null; // Key not found
        }
        keys.remove(index);
        return values.remove(index);
    }

    /**
     * Updates the value associated with an existing key.
     *
     * @param key   The key whose value is to be updated.
     * @param value The new value to associate with the key.
     * @return true if the update was successful, false if the key does not exist.
     */
    @Override
    public boolean update(K key, V value) {
        int index = keys.indexOf(key);
        if (index == -1) {
            return false; // Key does not exist
        }
        values.set(index, value);
        return true;
    }

    /**
     * Retrieves the value associated with a given key.
     *
     * @param key The key to look up.
     * @return The value associated with the key, or null if the key does not exist.
     */
    @Override
    public V lookup(K key) {
        int index = keys.indexOf(key);
        if (index == -1) {
            return null; // Key not found
        }
        return values.get(index);
    }

    /**
     * Returns the number of key-value pairs in the dictionary.
     *
     * @return The size of the dictionary.
     */
    public int size() {
        return keys.size();
    }
}
