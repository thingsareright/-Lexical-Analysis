package Service;

import java.io.IOException;
import java.util.List;

import FileUtil.myFileUtil;
import lexicalanalysisutil.Lexical;

/**
 * ��������
 * @author Erwin Smith  �����ҵ�Ӣ����
 *
 */
public class test1 {
	
	public static void main(String[] args)  {
		//��һ�������ļ���ȡԴ���򣬽�������Ϊ��λ����һ�������б���
		List<String> readFromFile = null;
		try {
			readFromFile = myFileUtil.readFromFile("G://test.txt");
		} catch (IOException e) {
			System.out.println("�ļ���ȡ���󣬳����쳣�����飡");
		}
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
