package maxutil;

import java.util.HashMap;
import java.util.Scanner;

/**
 * �����涨����ೣ��������ID��NUM���ֱ��룬���йؼ��֡����ִ����������ͽ���Ĵ������
 * @author Erwin Smith
 *
 */
public class Constant {

	/**
	 * ����һ�¸������Ĵ������
	 */
	public static final int KEY_WORD_TYPE = 1;
	public static final int OPERATOR_OR_BOUNDARY_IDENTIFIER_TYPE = 2;
	public static final int ID = 25;
	public static final int NUM = 26;	//�����������ǰ����ֱ����趨��
	public static final int SPACE_TYPE = 5;
	public static final int WRONG = 0;
	
	//�ؼ��ּ�������
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
	
	//�������ͽ���ļ�������
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
	 * ���ص��ʵĴ���
	 * @param �����ַ�����ʽ�ĵ���
	 * @return Constant�����趨�ĵ��ʴ���
	 */
	public static int getWordType(String word) {
		if(null == word){
			return WRONG;
		}
		/**
		 * �ؼ��ֺ������������жϵ����ȼ�һ��Ҫ��
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
	 * �����жϵ����Ƿ���һ��ID
	 * @param ����
	 * @return ������������ID����ʶ����������true�����򷵻�false
	 */
	public static boolean isWordID(String word){
		char[] wordChars = word.toCharArray();
		if(0 == wordChars.length)
			return false;
		//Ϊ��ģ������״̬��������û��ѡ��������ʽ������Ҫע�⣬���������ܻ�����쳣
		//�ж�����ĸ�Ƿ�����ĸ
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
	 * �����ж���������Ƿ���һ�����ִ�
	 * @param ����
	 * @return  ����������������ִ���ô����true�����򷵻�false
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
	 * ����������ڲ��ԣ�������������Ҫ��
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
