package maxutil;

/**
 * This class provide the way to show the operator identifier.
 * @author Erwin Smith
 *
 */
public class MaxOperatorIdentifier implements WordMessage{
	
	private String operator;
	
	public MaxOperatorIdentifier(String operator) {
		this.operator = operator;
	}
	
	public String getOperator() {
		return operator;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String showMessage() {
		return 	"(" + Constant.getMyOperatorIdentifier().get(operator) + "," + operator + ")";
	}

	public int getSyn() {
		return Constant.getMyOperatorIdentifier().get(operator);
	}

	public int getCodeType() {
		return Constant.OPERATOR_OR_BOUNDARY_IDENTIFIER_TYPE;
	}
	
	

}
