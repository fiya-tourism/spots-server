package com.fy.spotsserver.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public class Upfile {
	

	//上传至服务器方法
	public static String upFile(MultipartFile upfile, HttpServletRequest request) {
	//获取文件名
	String url = upfile.getOriginalFilename();
	//文件名拼接UUID获取新的文件名（防止因为文件名冲突出现图片被覆盖的情况）
	String  newFileName= UUID.randomUUID()+"_"+url;
	//获取项目的相对路径 web服务器（tomcat）中
	String realPath = request.getServletContext().getRealPath("/upfile/");
	//创建一个文件将文件放在指定的文件下
	File file = new File(realPath+""+newFileName);
	//如果不存在该路径 需要创建
	if(!file.exists()) {
		file.mkdirs();
	}
	try {
		//将文件写入磁盘中
		upfile.transferTo(file);
	} catch (IllegalStateException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	//将访问路径返回
	String fileUrl = "/upfile/"+newFileName;
	System.out.println(fileUrl);
	return fileUrl;
	}
	
	//下载
	public static void imgRead(String path,HttpServletResponse resp) {
		File filePic = new File(path);
		if(filePic.exists()){
		    FileInputStream is = null;
		    OutputStream toClient =null;
			try {
				is = new FileInputStream(filePic);
				int i = is.available(); // 得到文件大小  
				byte data[] = new byte[i];  
				is.read(data); // 读数据  
				is.close();  
				resp.setContentType("image/*"); // 设置返回的文件类型  
				toClient = resp.getOutputStream(); // 得到向客户端输出二进制数据的对象  
				toClient.write(data); // 输出数据  
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
					try {
						if(null!=is) {
							is.close();
						}
						if(null!= toClient) {
							toClient.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
	}
}