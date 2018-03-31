package maxutil;

/**
 * 这个类用于抽象实验要求中规定的关键字
 * @author Erwin Smith
 * 
 */
public class MaxKeyWord extends WordMessage{
	
	
	

	public MaxKeyWord(String word) {
		super(word);
	}

	/**
	 * 按规定形式输出单词的信息
	 */
	public String showMessage() {
		return 	"(" + Constant.getMyKeyWords().get(getWord()) + "," + getWord() + ")";
	}

	/**
	 * 得到单词的大类码（定义在Constant中），包括关键字、标识符、数字三类
	 */
	public int getCodeType() {
		return Constant.KEY_WORD_TYPE;
	}

	/**
	 * 得到种别码
	 */
	public int getSyn() {
		return Constant.getMyKeyWords().get(getWord());
	}

	
	
}
