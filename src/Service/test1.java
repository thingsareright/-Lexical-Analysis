package Service;

import java.io.FileWriter;
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
		if(null != args || 1 <= args.length){
			//第一步，从文件读取源程序，将其以行为单位存于一个数组列表中
			List<String> readFromFile = null;
			try {
				readFromFile = myFileUtil.readFromFile(args[0]);
			} catch (IOException e) {
				System.out.println("文件读取错误，出现异常，请检查！");
			}
			//第二步，把一个字符串数组列表变成一行，并且去掉注释
			String stringRemoveNotes = myFileUtil.myPretreatmentRmNotes(readFromFile);
			//第三步，合并多个空格为一个
			String stringTrim = myFileUtil.myPretreatmentTrim(stringRemoveNotes);
			
			//预处理结束
			
			//第四步，分词
			List<String> results = Lexical.ledicalAnalyize(stringTrim);
			//第五步显示结果
			//如果是没有键入文件路径，那么控制台输出，否则文件输出（注意这里的文件输出指的是重建一个文件）
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
					System.out.println("文件读写错误!!!");
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
