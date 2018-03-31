package FileUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lexicalanalysisutil.Lexical;

/**
 * ���������ʵ���ļ��Ķ�ȡ������ע�͵�ȥ�����ֲ������൱��Ԥ����
 * @author Erwin Smith
 *
 */
public class myFileUtil {
	
	/**
	 * ����Ԥ���������ǰѲ����ַ����еĶ���հ׷��ϳ�һ��
	 * @param myInput   ��Ҫ����Ԥ������ַ���
	 * @return  ���ص���Ԥ����Ľ������һ���ַ���������
	 */
	public static String myPretreatmentTrim(String myInput){
		if(null == myInput)	//����д��߸��淶һЩ
			return null;
		StringBuffer myInputBuffer = new StringBuffer(); 
		boolean flag = false; 	//Ϊtrue����ǰ������˿ո�
		//���濪ʼȥ���ո��ע��
		for(int i=0; i<myInput.length()-1; i++){
			//�ո�ת��int�ʹ���������32
			if(32 == myInput.charAt(i) && true == flag){
				continue;
			} else if(32 == myInput.charAt(i) && false == flag) {
				flag = true;
			} else {
				flag = false;
			}
			myInputBuffer.append(myInput.charAt(i));
		}
		
		//����myInput�е����һ���ַ�
		if(32 != myInput.charAt(myInput.length() - 1)){
			myInputBuffer.append(myInput.charAt(myInput.length() - 1));
		}
		return myInputBuffer.toString();
	}
	
	/**
	 * ���ڴ�ָ��·����ȡ�����ļ���һ��List<String>��
	 * @param filePath �ļ��ľ���·��
	 * @return	List��ʽ��String����
	 * @throws IOException 
	 */
	public static List<String> readFromFile(String filePath) throws IOException{
		FileReader fr = null;
		try {
			fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			String readLineString = null;
			ArrayList<String> read = new ArrayList<String>();
			
			while(null != (readLineString = br.readLine())){
				read.add(readLineString);
			}
			return read;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != fr){
				fr.close();
				
			}
		}
		return null;
	
	}
	
	/**
	 * ����ȥ��ע�ͣ���������ע�ͺͶ���ע��
	 * @param myInput
	 * @return
	 */
	public static String myPretreatmentRmNotes(List<String> myInput){
		boolean inNoteMulti = false;	//λ�ڶ���ע���еĻ�Ϊtrue������Ϊfalse
		boolean inNoteSingle = false;	//λ�ڵ���ע���еĻ�Ϊtrue������Ϊfalse
		StringBuffer stringBuffer = new StringBuffer();
		
		//ʵ�ֵ���ע�͵ĶԳƻ�
		for(int i=0; i<=myInput.size()-1; i++){
			String singleLine = myInput.get(i);
			//���ж���û��"//"
			if(singleLine.contains("//")){
				//�е���ע�ͷ��Ļ��ͰѸ����������Ӹ�����ע�ͣ�ʵ�ֶԳƻ�
				stringBuffer.append(singleLine).append('/').append('/');
			} else {
				stringBuffer.append(singleLine);
			}
		}
		String middle = stringBuffer.toString();
		StringBuffer middleBuffer = new StringBuffer();
		//����ȥ��ע��
		for(int i=0; i<middle.length()-1; i++){
			//���ж���û�ж���ע�ͣ����ж���û�е���ע�ͣ�ʵ���˶���ע�ͶԵ���ע�͵�����
			if('/' == middle.charAt(i) && '*' == middle.charAt(i+1)){
				i ++;
				inNoteMulti = true;
				continue;
			}
			if('*' == middle.charAt(i) && '/' == middle.charAt(i+1)){
				inNoteMulti = false;
				//ע��Ҫ�ѡ�ָ�롱��λ����ǰ��Ȼ����������һ��
				i ++;
				continue;
			}
			
			if('/' == middle.charAt(i) && '/' == middle.charAt(i+1)){
				inNoteSingle = !inNoteSingle;
				i ++;
				continue;
			}
			//ֻҪĿǰ�ַ����ڵ���ע�ͻ����ע���е�һ�ֻ��߽��ǣ���ô����ʹ���ע����
			if(true == (inNoteMulti || inNoteSingle))
				continue;
			middleBuffer.append(middle.charAt(i));
		}
		
		//�����ж����һ���ַ�
		if('/' != middle.charAt(middle.length()-1)){
			middleBuffer.append(middle.charAt(middle.length()-1));
		}
		return middleBuffer.toString();
	}
	
	/**
	 * ����������ڲ���
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		//���Զ�ȡ�ļ���ȥ��ע��
		System.out.println(Lexical.separate(myPretreatmentRmNotes(readFromFile("G://test.txt"))));
	}
}
