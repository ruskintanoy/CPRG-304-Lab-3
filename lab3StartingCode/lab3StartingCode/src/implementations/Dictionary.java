package implementations;

import java.util.ArrayList;

import exceptions.DuplicateKeyException;
import utilities.DictionaryADT;

public class Dictionary<K,V> implements DictionaryADT<K,V>
{
	// constant
	private static final int DEFAULT_SIZE = 10;
	
	// index indicates pairing, e.g. keys[1] is stored at values[1]
	private ArrayList<K> keys;
	private ArrayList<V> values;



	public Dictionary() {
        this(DEFAULT_SIZE);
    }
	

	public Dictionary(int size) {
		create(size);
	}


	@Override
	public void create(int size) 
	{
		keys = new ArrayList<>(size);
        values = new ArrayList<>(size);
		
	}
	@Override
	public boolean insert(K key, V value) throws DuplicateKeyException 
	{
		if (keys.contains(key)) {
            throw new DuplicateKeyException(key + " already exists.");
        }
        keys.add(key);
        values.add(value);
        return true;
	}
	@Override
	public V remove(K key) 
	{
		int keyIndex = keys.indexOf(key);
        if (keyIndex != -1) {
            keys.remove(keyIndex);
            return values.remove(keyIndex);
        }
        return null;
	}
	@Override
	public boolean update(K key, V value) 
	{
		int keyIndex = keys.indexOf(key);
        if (keyIndex != -1) {
            values.set(keyIndex, value);
            return true;
        }
        return false;
	}
	@Override
	public V lookup(K key) 
	{
		int keyIndex = keys.indexOf(key);
        return keyIndex != -1 ? values.get(keyIndex) : null;
	}

}
