package utilities;

/**
 * An abstract data type (ADT) for a Dictionary that stores key-value pairs.
 * This interface defines the contract for dictionary operations without specifying the implementation.
 * 
 * @param <K> the type of keys maintained by this dictionary (keys must be unique)
 * @param <V> the type of values stored in the dictionary
 * 
 * @author Ruskin
 * @author Laila
 */
public interface DictionaryADT<K, V> {

    /**
     * Inserts a new key-value pair into the dictionary.
     * 
     * @param key   The key to be added (must be unique).
     * @param value The value associated with the key.
     * @throws IllegalArgumentException if the key already exists in the dictionary.
     * @pre The key does not exist in the dictionary.
     * @post The key-value pair is added to the dictionary.
     */
    void insert(K key, V value) throws IllegalArgumentException;

    /**
     * Removes a key-value pair from the dictionary using the key.
     * 
     * @param key The key to be removed.
     * @return The value associated with the removed key.
     * @throws IllegalArgumentException if the key does not exist.
     * @pre The key exists in the dictionary.
     * @post The key-value pair is removed from the dictionary.
     */
    V remove(K key) throws IllegalArgumentException;

    /**
     * Updates the value associated with an existing key in the dictionary.
     * 
     * @param key   The key whose value needs to be updated.
     * @param value The new value to be assigned to the key.
     * @throws IllegalArgumentException if the key does not exist.
     * @pre The key exists in the dictionary.
     * @post The value associated with the key is updated.
     */
    void update(K key, V value) throws IllegalArgumentException;

    /**
     * Retrieves the value associated with a given key.
     * 
     * @param key The key whose value is to be retrieved.
     * @return The value associated with the key.
     * @throws IllegalArgumentException if the key does not exist.
     * @pre The key exists in the dictionary.
     * @post The dictionary remains unchanged.
     */
    V lookup(K key) throws IllegalArgumentException;

    /**
     * Returns the number of key-value pairs in the dictionary.
     * 
     * @return The size of the dictionary.
     * @pre None.
     * @post The dictionary remains unchanged.
     */
    int size();
}
