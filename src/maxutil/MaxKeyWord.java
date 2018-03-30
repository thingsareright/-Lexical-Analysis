package maxutil;

/**
 * This class is used to handle things with key words in 'C'
 * @author Erwin Smith
 * 
 */
public class MaxKeyWord implements WordMessage{
	
	private String keyWord;
	
	public MaxKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	

	public String showMessage() {
		return 	"(" + Constant.getMyKeyWords().get(keyWord) + "," + keyWord + ")";
	}

	public int getCodeType() {
		return Constant.KEY_WORD_TYPE;
	}

	/**
	 * 得到种别码
	 */
	public int getSyn() {
		return Constant.getMyKeyWords().get(keyWord);
	}

	public String getKeyWord() {
		return keyWord;
	}
	
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
}
