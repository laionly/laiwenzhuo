package com.naive.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传方法
 * @author Naive
 * @date: 2019年12月25日 上午10:51:40
 */
public class FileAccepterUtil {
	/**
	 * 文件上传
	 * @param file 上传的文件
	 * @param path 上传的路径
	 * @return 上传文件名
	 */
	public String FileUpload(MultipartFile file, String path) {
		String fileName  = file.getOriginalFilename();
//        System.out.println(path);
//        System.out.println(fileName);//文件名称
//        System.out.println(file.getSize());//文件大小
//        System.out.println(file.getName());//表单名称
        File dir = new File(path);//1.新建一个文件夹对象
        if(!dir.exists()){              //2.检查路径下upload文件夹是否存在
            dir.mkdirs();
        }

        if (fileName.toLowerCase().endsWith(".jpg") || fileName.toLowerCase().endsWith(".png")) {
            //新名字：
            String newName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) +"."+ fileName.substring(fileName.lastIndexOf(".")+1);
            try {
				file.transferTo(new File(path + newName));
				return newName;
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return null;
			}
        } else {
        	return null;
        }
	}
	
	/**
	 * 文件删除
	 * @param path 文件的路径
	 * @param fileName 文件名
	 * @return
	 */
	public boolean FileDelete(String path, String fileName) {
		File file = new File(path+"/"+fileName);
		return file.delete();
	}
}
