package Service;

import java.io.FileWriter;
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
		if(null != args || 1 <= args.length){
			//��һ�������ļ���ȡԴ���򣬽�������Ϊ��λ����һ�������б���
			List<String> readFromFile = null;
			try {
				readFromFile = myFileUtil.readFromFile(args[0]);
			} catch (IOException e) {
				System.out.println("�ļ���ȡ���󣬳����쳣�����飡");
			}
			//�ڶ�������һ���ַ��������б���һ�У�����ȥ��ע��
			String stringRemoveNotes = myFileUtil.myPretreatmentRmNotes(readFromFile);
			//���������ϲ�����ո�Ϊһ��
			String stringTrim = myFileUtil.myPretreatmentTrim(stringRemoveNotes);
			
			//Ԥ�������
			
			//���Ĳ����ִ�
			List<String> results = Lexical.ledicalAnalyize(stringTrim);
			//���岽��ʾ���
			//�����û�м����ļ�·������ô����̨����������ļ������ע��������ļ����ָ�����ؽ�һ���ļ���
			if(2 != args.length){
				for(String result : results){
					System.out.println(result);
				}
			} else {
				FileWriter fr = null;
				try {
					fr = new FileWriter(args[1]);
					for (String result : results) {
						fr.write(result + "\r\n");
					} 
				}catch(Exception e){
					System.out.println("�ļ���д����!!!");
				} finally {
					if(null != fr){
						try {
							fr.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
	}
}
