package com.example.cloudyserver.model.biz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.example.cloudyserver.model.bean.CloudyFileBean;

public class CloudyFileManager {
	private static CloudyFileManager mInstance;

	private CloudyFileManager() {
	}

	public static CloudyFileManager getInstance() {
		if (mInstance == null) {
			mInstance = new CloudyFileManager();
		}

		return mInstance;
	}

	public List<CloudyFileBean> getFilesName(int isAbs) {
		List<CloudyFileBean> result = new ArrayList<CloudyFileBean>();

		File rootFile = new File(System.getProperty("user.dir"));
		String photosDir = null;

		try {
			photosDir = rootFile.getParent() + File.separator + "webapps" + File.separator + "CloudyServer"
					+ File.separator + "photos";

			File[] files = new File(photosDir).listFiles();
			if (files != null) {
				for (File file : files) {
					if (isAbs == 0) {
						result.add(new CloudyFileBean(file.getName()));
					} else {
						result.add(new CloudyFileBean(file.getAbsolutePath()));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public String getMd5ByFile(File file) throws FileNotFoundException {
		String value = null;
		FileInputStream in = new FileInputStream(file);
		try {
			MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			
			md5.update(byteBuffer);
			
			BigInteger bi = new BigInteger(1, md5.digest());
			
			value = bi.toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}
}
