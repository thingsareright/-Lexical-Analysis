package FileUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lexicalanalysisutil.Lexical;

/**
 * 这个类用于实现文件的读取，包括注释的去除种种操作，相当于预处理。
 * @author Erwin Smith
 *
 */
public class myFileUtil {
	
	/**
	 * 用于预处理，功能是把参数字符串中的多个空白符合成一个
	 * @param myInput   需要进行预处理的字符串
	 * @return  返回的是预处理的结果，是一个字符串的引用
	 */
	public static String myPretreatmentTrim(String myInput){
		if(null == myInput)	//常量写左边更规范一些
			return null;
		StringBuffer myInputBuffer = new StringBuffer(); 
		boolean flag = false; 	//为true代表前面出现了空格
		//下面开始去除空格和注释
		for(int i=0; i<myInput.length()-1; i++){
			//空格转成int型代表数字是32
			if(32 == myInput.charAt(i) && true == flag){
				continue;
			} else if(32 == myInput.charAt(i) && false == flag) {
				flag = true;
			} else {
				flag = false;
			}
			myInputBuffer.append(myInput.charAt(i));
		}
		
		//还有myInput中的最后一个字符
		if(32 != myInput.charAt(myInput.length() - 1)){
			myInputBuffer.append(myInput.charAt(myInput.length() - 1));
		}
		return myInputBuffer.toString();
	}
	
	/**
	 * 用于从指定路径读取多行文件到一个List<String>中
	 * @param filePath 文件的绝对路径
	 * @return	List形式的String集合
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
	 * 用于去除注释，包括单行注释和多行注释
	 * @param myInput
	 * @return
	 */
	public static String myPretreatmentRmNotes(List<String> myInput){
		boolean inNoteMulti = false;	//位于多行注释中的话为true，否则为false
		boolean inNoteSingle = false;	//位于单行注释中的话为true，否则为false
		StringBuffer stringBuffer = new StringBuffer();
		
		//实现单行注释的对称化
		for(int i=0; i<=myInput.size()-1; i++){
			String singleLine = myInput.get(i);
			//先判断有没有"//"
			if(singleLine.contains("//")){
				//有单行注释符的话就把改行内容最后加个单行注释，实现对称化
				stringBuffer.append(singleLine).append('/').append('/');
			} else {
				stringBuffer.append(singleLine);
			}
		}
		String middle = stringBuffer.toString();
		StringBuffer middleBuffer = new StringBuffer();
		//下面去除注释
		for(int i=0; i<middle.length()-1; i++){
			//先判断有没有多行注释，再判断有没有单行注释，实现了多行注释对单行注释的屏蔽
			if('/' == middle.charAt(i) && '*' == middle.charAt(i+1)){
				i ++;
				inNoteMulti = true;
				continue;
			}
			if('*' == middle.charAt(i) && '/' == middle.charAt(i+1)){
				inNoteMulti = false;
				//注意要把“指针”的位置提前，然后必须进入下一轮
				i ++;
				continue;
			}
			
			if('/' == middle.charAt(i) && '/' == middle.charAt(i+1)){
				inNoteSingle = !inNoteSingle;
				i ++;
				continue;
			}
			//只要目前字符处在单行注释或多行注释中的一种或者皆是，那么程序就处在注释中
			if(true == (inNoteMulti || inNoteSingle))
				continue;
			middleBuffer.append(middle.charAt(i));
		}
		
		//接着判断最后一个字符
		if('/' != middle.charAt(middle.length()-1)){
			middleBuffer.append(middle.charAt(middle.length()-1));
		}
		return middleBuffer.toString();
	}
	
	/**
	 * 这个方法用于测试
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		//测试读取文件并去除注释
		System.out.println(Lexical.separate(myPretreatmentRmNotes(readFromFile("G://test.txt"))));
	}
}
