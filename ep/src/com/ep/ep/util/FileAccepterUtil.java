package com.ep.ep.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FileAccepterUtil {
	public String FileUpload(MultipartFile file, String path) {
		String fileName = file.getOriginalFilename();
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		if (fileName.toLowerCase().endsWith(".jpg") || fileName.toLowerCase().endsWith("png")) {
			String newName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) + "."
					+ fileName.substring(fileName.lastIndexOf(".") + 1);
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

	public boolean FileDelete(String path, String fileName) {
		File file = new File(path + "/" + fileName);
		return file.delete();
	}
}
