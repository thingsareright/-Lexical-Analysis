package Service;

import java.io.IOException;
import java.util.List;

import FileUtil.myFileUtil;
import lexicalanalysisutil.Lexical;

/**
 * 程序的入口
 * @author Erwin Smith  这是我的英文名
 *
 */
public class test1 {
	
	public static void main(String[] args)  {
		//第一步，从文件读取源程序，将其以行为单位存于一个数组列表中
		List<String> readFromFile = null;
		try {
			readFromFile = myFileUtil.readFromFile("G://test.txt");
		} catch (IOException e) {
			System.out.println("文件读取错误，出现异常，请检查！");
		}
		//第二步，把一个字符串数组列表变成一行，并且去掉注释
		String stringRemoveNotes = myFileUtil.myPretreatmentRmNotes(readFromFile);
		//第三步，合并多个空格为一个
		String stringTrim = myFileUtil.myPretreatmentTrim(stringRemoveNotes);
		
		//预处理结束
		
		//第四步，分词,与下一步合并
		//第五步，输出结果
		Lexical.ledicalAnalyize(stringTrim);
	}
}
