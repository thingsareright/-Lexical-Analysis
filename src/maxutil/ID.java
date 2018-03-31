package maxutil;

/**
 * ���ڶ�ID���г���
 * @author Erwin Smith
 *
 */
public class ID extends WordMessage{

	public ID(String word) {
		super(word);
	}

	@Override
	public String showMessage() {
		return "(" + Constant.ID + "," + getWord() + ")";
	}

	@Override
	public int getSyn() {
		return Constant.ID;
	}

	@Override
	public int getCodeType() {
		return Constant.ID;
	}

}
