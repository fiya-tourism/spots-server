package com.fy.spotsserver.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class String_String {
	
	private static Pattern humpPattern = Pattern.compile("[A-Z]");
	
		/**
		 * 下划线转驼峰
		 * @param str
		 * @return
		 */
		public static StringBuffer camel(StringBuffer str) {
			//利用正则删除下划线，把下划线后一位改成大写
			Pattern pattern = Pattern.compile("_(\\w)");
			Matcher matcher = pattern.matcher(str);
			StringBuffer sb = new StringBuffer(str);
			if(matcher.find()) {
				sb = new StringBuffer();
				//将当前匹配子串替换为指定字符串，并且将替换后的子串以及其之前到上次匹配子串之后的字符串段添加到一个StringBuffer对象里。
				//正则之前的字符和被替换的字符
				matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
				//把之后的也添加到StringBuffer对象里
				matcher.appendTail(sb);			
			}else {
				return sb;
			}	
			return camel(sb);
		}
		
		
		/**
		 * 驼峰转下划线
		 * @param string
		 * @return
		 */
        public static String humpToLine(String str){
        	
        	if(str == null || str.length() == 0) { 
        		return null;
        	}
        	
            Matcher matcher = humpPattern.matcher(str);
            StringBuffer sb = new StringBuffer();
            while(matcher.find()){
                matcher.appendReplacement(sb, "_"+matcher.group(0).toLowerCase());
            }
            matcher.appendTail(sb);
            return sb.toString();
        }
      


}
