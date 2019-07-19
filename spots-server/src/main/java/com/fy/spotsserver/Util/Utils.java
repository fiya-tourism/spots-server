package com.fy.spotsserver.Util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Utils {
	
	
	
	
	/**   
	 * @Title: getMD5String   
	 * @Description: TODO(MD5加密)   
	 * @param: @param str
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */ 
		 
	public static String getMD5String(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }
	
	/**   
	 * @Title: getCheckboxBoo   
	 * @Description: TODO(根据当前值判断数据库中所存数据是否存在      存在返回true)   
	 * @param: @param num
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws   1, 2, 4
	 */ 
	public boolean getCheckboxBoo(int num,String str){
		if (str!=null && !str.isEmpty()) {//判断str是否有数据
			str = str.replaceAll(" ", "");
			String[] split = str.split(",");
			for (int i = 0; i < split.length; i++) {
				if (num == Integer.valueOf(split[i]))
					return true;
			}
		}
		return false;
	}

}
