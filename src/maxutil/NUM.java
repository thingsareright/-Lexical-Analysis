package maxutil;

/**
 * 这个类用于抽象数字串
 * @author dell
 *
 */
public class NUM extends WordMessage{

	public NUM(String word) {
		super(word);
	}

	@Override
	public String showMessage() {
		return "(" + Constant.NUM + "," + getWord() + ")";
	}

	@Override
	public int getSyn() {
		return Constant.NUM;
	}

	@Override
	public int getCodeType() {
		return Constant.NUM;
	}

}
