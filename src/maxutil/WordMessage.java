package maxutil;

/**
 * This is the interface dor words. This class has a few methods to handle with need for word.
 * @author Erwin Smith
 *
 */
public interface WordMessage {
	
	/**
	 * This method is used to show the species code for a word such as   "(1, main)" or "(26,12)".
	 * @return the string which would be printed to the console 
	 */
	String showMessage();
	
	/**
	 * This method is used to return the species code for a word.
	 * @return the species code for the word which had implemented this interface
	 */
	int getSyn();

	/**
	 * This method is used to return the type code for a word, which has an exact definition in the Constant Class;
	 * @return the species code for the word which had implemented this interface
	 */
	int getCodeType();
	
}
