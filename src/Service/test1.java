package Service;

import java.util.List;

import FileUtil.myFileUtil;
import lexicalanalysisutil.Lexical;

/**
 * ��������
 * @author Erwin Smith
 *
 */
public class test1 {
	
	public static void main(String[] args) {
		//��һ�������ļ���ȡԴ���򣬽�������Ϊ��λ����һ�������б���
		List<String> readFromFile = myFileUtil.readFromFile("G://test.txt");
		//�ڶ�������һ���ַ��������б���һ�У�����ȥ��ע��
		String stringRemoveNotes = myFileUtil.myPretreatmentRmNotes(readFromFile);
		//���������ϲ�����ո�Ϊһ��
		String stringTrim = myFileUtil.myPretreatmentTrim(stringRemoveNotes);
		
		//Ԥ�������
		
		//���Ĳ����ִ�,����һ���ϲ�
		//���岽��������
		Lexical.ledicalAnalyize(stringTrim);
	}
}
