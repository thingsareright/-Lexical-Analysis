package maxutil;

/**
 * 这个抽象类是对单词的总的抽象
 * @author Erwin Smith
 *
 */
public abstract class WordMessage {
	
	//单词的字符串形式的表达
	private String word;
	
	public WordMessage(String word) {
		this.word = word;
	}
	
	/**
	 * 这个方法用于按照要求返回展示一个单词的种别码以及其值的字符串
	 * @return 符合输出要求的字符串
	 */
	public abstract String showMessage();
	
	/**
	 * 返回单词的种别码
	 * @return 单词的种别码
	 */
	public abstract int getSyn();

	/**
	 * 返回单词所属的大类分别码
	 * @return 大类分别码
	 */
	public abstract int getCodeType();
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	
	
}
