package service;

/** 合法性检查服务，用于检查输入的合法性 */
public class ValidityService {
	/**
	* 查看一个字符串是否可以转换为范围在[lower,upper]整数
	* @param str: 字符串
	* @param lower: 下限
	* @param uppper: 上限
	* @return true 可以; false 不可以
	*/
	public static boolean isValidNum(String str,int lower,int upper) { 
		try {
			int num=Integer.parseInt(str);
			if(num>=lower && num<=upper) {
				return true;
			}else {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/** 判断str是否为合法的figures位小数
	 * @param str: 字符串
	 * @param figures: 小数的位数 
	 * @return true:合法，false:非法 */
	public static boolean isValidFraction(String str,int figures) {
		if(isValidNum(str.substring(0,figures), 0, 99)){
			if(str.length()>2) { 
				if(isValidNum(str.substring(figures), 0, 0)) {
					return true;
				}else {
					return false;
				}
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	
	/** 验证是否是合法的时长数据,合法时长的数据范围：[0,10000]
	 * @param str:输入字符串
	 * @return true:合法，false:非法 */
	public static boolean isValidDuration(String str) {
		return isValidNum(str, 0, 10000);
	}

	/** 验证是否是合法的价格数据,合法价格的数据范围：[0.00,10000.00]
	 * @param str:输入字符串
	 * @return true:合法，false:非法 */
	public static boolean isValidPrice(String str) {
		int index=str.indexOf(".");
		if(index==-1) {
			return isValidNum(str, 0, 10000);
		}else if(index !=0 && index !=str.length()-1){
			if(isValidNum(str.substring(0,index), 0, 9999)
					&& isValidFraction(str.substring(index+1),2)) {	// 防止11.011，允许0.01000000
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}
