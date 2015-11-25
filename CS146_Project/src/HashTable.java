public class HashTable {
	
	public Word[] words = new Word[503];
	public int[] state = new int[words.length];
	
	public int uniqueWords = 0;
	
	public static final int NULL = 0;
	public static final int EMPTY = 1;
	public static final int OCCUPIED = 2;
	
	public HashTable() {
		
	}
	
	public void add(String text) {
		int key = hash(text) % words.length;
		for(int i = 1; i < words.length; i++) {
			if(state[key] == NULL) {
				state[key] = OCCUPIED;
				words[key] = new Word(text);
				uniqueWords++;
				break;
			} else if(state[key] == OCCUPIED) {
				if(words[key].text.equals(text)) {
					words[key].increment();
					break;
				} else {
					key = (key + (i * i)) % words.length;
				}
			}
		}
	}
	
	public String toString() {
		String toReturn = "";
		for(int i = 0; i < words.length; i++) {
			if(words[i] != null) {
				toReturn += words[i].text + ": " + words[i].getCount() + "\n";
			}
		}
		return toReturn;
	}
	
	private int hash(String text) {
		return Math.abs((text.hashCode() * 19) * (text.hashCode() + 19));
	}
}
