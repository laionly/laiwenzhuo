package com.ep.ep.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FileAccepterUtil {
	public String FileUpload(MultipartFile mf, String path) {
		String oldFileName = mf.getOriginalFilename();
		// 将路径和文件名包装到File对象生成文件对象
		File file = new File(path + File.separator + oldFileName);
		// 将当前文件数据to给谁，这里to给tomcat目录下生成图片
		try {
			mf.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	public boolean FileDelete(String path, String fileName) {
		File file = new File(path + File.separator + fileName);
		return file.delete();
	}
}
