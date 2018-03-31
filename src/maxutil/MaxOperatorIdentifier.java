package maxutil;

/**
 * ��������Գ���������ͽ��
 * @author Erwin Smith
 *
 */
public class MaxOperatorIdentifier extends WordMessage{
	
	public MaxOperatorIdentifier(String word) {
		super(word);
	}


	public String showMessage() {
		return 	"(" + Constant.getMyOperatorIdentifier().get(getWord()) + "," + getWord() + ")";
	}

	public int getSyn() {
		return Constant.getMyOperatorIdentifier().get(getWord());
	}

	public int getCodeType() {
		return Constant.OPERATOR_OR_BOUNDARY_IDENTIFIER_TYPE;
	}
	
	

}
