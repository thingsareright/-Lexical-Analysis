package lexicalanalysisutil;

import java.util.ArrayList;
import java.util.List;
import maxutil.*;
/**
 * ���ڴʷ�������һ��������
 * @author Erwin Smith
 *
 */
public class Lexical {
	
	/**
	 * ���дʷ�����������ʷ������Ľ��
	 * @param input
	 * @return
	 */
	public static void ledicalAnalyize(String input){
		List<String> seperatedString = separate(input);	//��ȡ���еĵ���������ɵ������б�
		WordMessage message = null;	//׼����ת�Ͷ���
		//�����ÿ���ַ��������з���Ͱ�����ĿҪ������ֱ������������
		for(int i=0; i<seperatedString.size(); i++) {
			String single = seperatedString.get(i);
			int flag = Constant.getWordType(single);
			switch (flag) {
				case Constant.ID:
					System.out.println("(25," + single + ")");
					break;
				case Constant.KEY_WORD_TYPE:
					message = new MaxKeyWord(single);
					System.out.println(message.showMessage());
					break;
				case Constant.OPERATOR_OR_BOUNDARY_IDENTIFIER_TYPE:
					message = new MaxOperatorIdentifier(single);
					System.out.println(message.showMessage());
					break;
				case Constant.NUM:
					System.out.println("(26," + single + ")");
					break;
				
				default:
					break;
			}
		}
		return ;
	}
	
	/**
	 * ���ڽ��Ѿ�Ԥ��������ַ���ת��Ϊһ�������ַ�������Щ�ַ������ֽ����������ָ����ķֽ��ָ����ģ��������������ֽ���͵����ո�
	 * @param input
	 * @return
	 */
	public static List<String> separate(String input){
		if(null == input)
			return null;
		ArrayList<String> separateString = new ArrayList<String>();
		StringBuffer sbOB = new StringBuffer();	//�ָ����ж����ַ�������
		StringBuffer sbCommmon = new StringBuffer();		//����������
		//�����ķָ����ͽ������������ַ����,Ҫ��ǰ�ж���λ
		for(int i=0; i<input.length(); i++){
			sbOB.setLength(0);
			if((i<input.length()-1)){
				sbOB.append(input.charAt(i)).append(input.charAt(i + 1));
			}
			//�����ǰ�ַ�����һ���ַ�����������λ�ֽ�����߲������Ļ���������������������գ����һ�Ҫ��ӵ����ص�list��
			if((i<input.length()-1) && Constant.getWordType(sbOB.toString()) == Constant.OPERATOR_OR_BOUNDARY_IDENTIFIER_TYPE){
				if(!("").equals(sbCommmon.toString())){
					separateString.add(sbCommmon.toString());
				}
				separateString.add(sbOB.toString());
				sbCommmon.setLength(0);
				i ++;	//��Ϊ�г�ǰ�жϣ�����ָ��Ҫ��һ
				continue;	//ǧ�����������£�������������ִ��
			}
			//��������ֽ����ʷ�������ͬ
			if(Constant.getWordType(input.charAt(i) + "") == Constant.OPERATOR_OR_BOUNDARY_IDENTIFIER_TYPE){
				if(!("").equals(sbCommmon.toString())){
					separateString.add(sbCommmon.toString());
				}
				separateString.add(input.charAt(i) + "");
				sbCommmon.setLength(0);
				//��Ϊ����û�г�ǰ�жϣ�����ָ�벻��1
				continue;	//ǧ�����������£�������������ִ��
			}
			
			//�ո�
			if(' ' == input.charAt(i)){
				if(!("").equals(sbCommmon.toString().trim())){
					separateString.add(sbCommmon.toString());
				}
				sbCommmon.setLength(0);
			}
			sbCommmon.append(input.charAt(i));
		}
		if(0 != sbCommmon.length()){
			//������Ĳ��Ƿֽ������ô�������һ���ַ���
			separateString.add(sbCommmon.toString());	
		}
		return separateString;
	}
}
