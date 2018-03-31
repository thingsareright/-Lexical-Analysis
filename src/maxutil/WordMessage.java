package maxutil;

/**
 * ����������ǶԵ��ʵ��ܵĳ���
 * @author Erwin Smith
 *
 */
public abstract class WordMessage {
	
	//���ʵ��ַ�����ʽ�ı��
	private String word;
	
	public WordMessage(String word) {
		this.word = word;
	}
	
	/**
	 * ����������ڰ���Ҫ�󷵻�չʾһ�����ʵ��ֱ����Լ���ֵ���ַ���
	 * @return �������Ҫ����ַ���
	 */
	public abstract String showMessage();
	
	/**
	 * ���ص��ʵ��ֱ���
	 * @return ���ʵ��ֱ���
	 */
	public abstract int getSyn();

	/**
	 * ���ص��������Ĵ���ֱ���
	 * @return ����ֱ���
	 */
	public abstract int getCodeType();
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	
	
}
