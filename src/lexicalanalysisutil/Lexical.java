package lexicalanalysisutil;

import java.util.ArrayList;
import java.util.List;
import maxutil.*;
/**
 * 用于词法分析的一个工具类
 * @author Erwin Smith
 *
 */
public class Lexical {
	
	/**
	 * 进行词法分析，输出词法分析的结果
	 * @param input
	 * @return
	 */
	public static void ledicalAnalyize(String input){
		List<String> seperatedString = separate(input);	//获取所有的单个单词组成的数组列表
		WordMessage message = null;	//准备上转型对象
		//下面对每个字符串，进行分类和按照题目要求输出种别码和其它内容
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
	 * 用于将已经预处理过的字符串转换为一个个的字符串，这些字符串被分界符和运算符分割，这里的分界符指广义的（包括操作符、分界符和单个空格）
	 * @param input
	 * @return
	 */
	public static List<String> separate(String input){
		if(null == input)
			return null;
		ArrayList<String> separateString = new ArrayList<String>();
		StringBuffer sbOB = new StringBuffer();	//分隔符判断用字符缓冲区
		StringBuffer sbCommmon = new StringBuffer();		//正常缓冲区
		//给出的分隔符和界符最多由两个字符组成,要提前判断两位
		for(int i=0; i<input.length(); i++){
			sbOB.setLength(0);
			if((i<input.length()-1)){
				sbOB.append(input.charAt(i)).append(input.charAt(i + 1));
			}
			//如果当前字符和下一个字符合起来是两位分界符或者操作符的话，对两个缓冲区进行清空，而且还要添加到返回的list中
			if((i<input.length()-1) && Constant.getWordType(sbOB.toString()) == Constant.OPERATOR_OR_BOUNDARY_IDENTIFIER_TYPE){
				if(!("").equals(sbCommmon.toString())){
					separateString.add(sbCommmon.toString());
				}
				separateString.add(sbOB.toString());
				sbCommmon.setLength(0);
				i ++;	//因为有超前判断，所以指针要加一
				continue;	//千万别忘了这个事，跳过下面的语句执行
			}
			//单个狭义分界性质符与上相同
			if(Constant.getWordType(input.charAt(i) + "") == Constant.OPERATOR_OR_BOUNDARY_IDENTIFIER_TYPE){
				if(!("").equals(sbCommmon.toString())){
					separateString.add(sbCommmon.toString());
				}
				separateString.add(input.charAt(i) + "");
				sbCommmon.setLength(0);
				//因为这里没有超前判断，所以指针不加1
				continue;	//千万别忘了这个事，跳过下面的语句执行
			}
			
			//空格
			if(' ' == input.charAt(i)){
				if(!("").equals(sbCommmon.toString().trim())){
					separateString.add(sbCommmon.toString());
				}
				sbCommmon.setLength(0);
			}
			sbCommmon.append(input.charAt(i));
		}
		if(0 != sbCommmon.length()){
			//如果最后的不是分界符，那么加上最后一个字符串
			separateString.add(sbCommmon.toString());	
		}
		return separateString;
	}
}
