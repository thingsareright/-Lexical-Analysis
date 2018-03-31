package maxutil;

/**
 * ��������ڳ���ʵ��Ҫ���й涨�Ĺؼ���
 * @author Erwin Smith
 * 
 */
public class MaxKeyWord extends WordMessage{
	
	
	

	public MaxKeyWord(String word) {
		super(word);
	}

	/**
	 * ���涨��ʽ������ʵ���Ϣ
	 */
	public String showMessage() {
		return 	"(" + Constant.getMyKeyWords().get(getWord()) + "," + getWord() + ")";
	}

	/**
	 * �õ����ʵĴ����루������Constant�У��������ؼ��֡���ʶ������������
	 */
	public int getCodeType() {
		return Constant.KEY_WORD_TYPE;
	}

	/**
	 * �õ��ֱ���
	 */
	public int getSyn() {
		return Constant.getMyKeyWords().get(getWord());
	}

	
	
}
