package com.niit.FileUpload;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.niit.controller.productController;

//For Multipart File Uploading
public class Fileupload {

	private static final String ABS_PATH = "F:\\clari java\\EcomFrontend\\src\\main\\webapp\\WEB-INF\\images";
	private static String REAL_PATH = "";

	private static final Logger logger = LoggerFactory.getLogger(Fileupload.class);

	public static void uploadFile(HttpServletRequest request, MultipartFile image, String code) {

		REAL_PATH = request.getSession().getServletContext().getRealPath("/images/");

		logger.info(REAL_PATH);

		// to make sure all the directory exists
		// create the directories
		if (!new File(ABS_PATH).exists()) {
			// create the directories
			new File(ABS_PATH).mkdirs();
		}

		if (!new File(REAL_PATH).exists()) {
			// create the directories
			new File(REAL_PATH).mkdirs();
		}

		try {
			// server upload
			image.transferTo(new File(REAL_PATH + code + ".jpg"));
			// project directory upload
			image.transferTo(new File(ABS_PATH + code + ".jpg"));
		} catch (IOException ex) {

		}

	}

}
