package implementations;

import java.util.ArrayList;

import utilities.DictionaryADTPart1;

public class Dictionary<K,V> implements DictionaryADTPart1<K,V>
{
	// constant
	private static final int DEFAULT_SIZE = 10;
	
	// index indicates pairing, e.g. keys[1] is stored at values[1]
	private ArrayList<K> keys;
	private ArrayList<V> values;

}
