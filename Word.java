public class Word {
	String text;
	int key;
	private int count;
	
	public Word(String text) {
		count = 1;
		this.text = text;
		hash();
	}
	
	public void increment() {
		count++;
	}
	
	public int getCount() {
		return count;
	}
	
	private void hash() {
		key = Math.abs((text.hashCode() * 19) * (text.hashCode() + 19));
	}
}
