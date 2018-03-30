package maxutil;

import java.util.HashMap;
import java.util.Scanner;

/**
 * This class gives a few definitions for type of words.
 * @author Erwin Smith
 *
 */
public class Constant {

	public static final int KEY_WORD_TYPE = 1;
	public static final int OPERATOR_OR_BOUNDARY_IDENTIFIER_TYPE = 2;
	public static final int ID = 3;
	public static final int NUM = 4;
	public static final int SPACE_TYPE = 5;
	public static final int WRONG = 0;
	
	
	private static HashMap<String, Integer> myKeyWords = new HashMap<String, Integer>();
	
	static {
		myKeyWords.put("main",1);
		myKeyWords.put("if",2);
		myKeyWords.put("then",3);
		myKeyWords.put("while",4);
		myKeyWords.put("do",5);
		myKeyWords.put("static",6);
		myKeyWords.put("int",7);
		myKeyWords.put("double",8);
		myKeyWords.put("struct",9);
		myKeyWords.put("break",10);
		myKeyWords.put("else",11);
		myKeyWords.put("long",12);
		myKeyWords.put("switch",13);
		myKeyWords.put("case",14);
		myKeyWords.put("typedef",15);
		myKeyWords.put("char",16);
		myKeyWords.put("return",17);
		myKeyWords.put("const",18);
		myKeyWords.put("float",19);
		myKeyWords.put("short",20);
		myKeyWords.put("continue",21);
		myKeyWords.put("for",22);
		myKeyWords.put("void",23);
		myKeyWords.put("sizeof",24);
		myKeyWords.put("default",39);
	}
	
	
	private static HashMap<String, Integer> myOperatorIdentifier = new HashMap<String, Integer>();
	
	static {
		myOperatorIdentifier.put(";",41);
		myOperatorIdentifier.put("(",42);
		myOperatorIdentifier.put(")",43);
		myOperatorIdentifier.put("+",27);
		myOperatorIdentifier.put("-",28);
		myOperatorIdentifier.put("*",29);
		myOperatorIdentifier.put("/",30);
		myOperatorIdentifier.put(":",31);
		myOperatorIdentifier.put(":=",32);
		myOperatorIdentifier.put("<",33);
		myOperatorIdentifier.put("<>",34);
		myOperatorIdentifier.put("<=",35);
		myOperatorIdentifier.put(">",36);
		myOperatorIdentifier.put(">=",37);
		myOperatorIdentifier.put("=",38);
		myOperatorIdentifier.put("char",16);
		myOperatorIdentifier.put("#",0);
	}
	
	public static HashMap<String, Integer> getMyKeyWords() {
		return myKeyWords;
	}
	
	public static HashMap<String, Integer> getMyOperatorIdentifier() {
		return myOperatorIdentifier;
	}
	/**
	 * This method is to return the word type!
	 * @param word
	 * @return the code type for the word.
	 */
	public static int getWordType(String word) {
		if(null == word){
			return WRONG;
		}
		/**
		 * 关键字和运算符、界符判断的优先级一定要高
		 */
		if(myKeyWords.containsKey(word)){
			return KEY_WORD_TYPE;
		}
		if(myOperatorIdentifier.containsKey(word)){
			return OPERATOR_OR_BOUNDARY_IDENTIFIER_TYPE;
		}
		if(isWordID(word)){
			return ID;
		} 
		if(isWordNUM(word)){
			return NUM;
		}
		return WRONG;
	}
	
	/**
	 * This method is used to judge is the word a ID
	 * @param word
	 * @return
	 */
	public static boolean isWordID(String word){
		char[] wordChars = word.toCharArray();
		if(0 == wordChars.length)
			return false;
		//为了模拟有穷状态机，我们没有选择正则表达式，但是要注意，这个里面可能会出现异常
		//判断首字母是否是字母
		if(!Character.isLetter(wordChars[0])){
			return false;
		}
		for(int i=1; i<wordChars.length; i++){
			if(!(Character.isLetter(wordChars[i]) || Character.isDigit(wordChars[i]))){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * This method is used to judge is the word a NUM
	 * @param word
	 * @return
	 */
	public static boolean isWordNUM(String word){
		char[] wordChars = word.toCharArray();
		if(0 == wordChars.length)
			return false;
		for(int i=0; i<wordChars.length; i++){
			if(!Character.isDigit(wordChars[i]))
				return false;
		}
		return true;
	}
	
	/**
	 * 这个方法用于测试，经过测试满足要求
	 * @param args
	 */
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("test begin!");
		String word;
		while(true){
			word = scanner.nextLine();
			System.out.println(getWordType(word));
		}
	}
}
