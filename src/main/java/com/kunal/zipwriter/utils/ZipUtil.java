package com.kunal.zipwriter.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import org.apache.commons.io.IOUtils;

import com.kunal.zipwriter.model.Asset;

public class ZipUtil {

	public static void zipFiles(List<File> filesToZip) throws ZipException {
		ZipFile zipFile = new ZipFile("C:\\LunaWorkspace\\ZipWriter\\Asset.zip");
		
		ZipParameters parameters = new ZipParameters();
		parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); 
		zipFile.addFiles((ArrayList<File>) filesToZip, parameters);
		
	}

	public static void writeToZip(List<Asset> list1, String filename) throws FileNotFoundException, ZipException {
		try {
			ZipParameters parameters = new ZipParameters();
			ZipFile zipFile = new ZipFile("C:\\LunaWorkspace\\ZipWriter\\AssetZip2.zip");
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
			parameters.setFileNameInZip(filename);
			parameters.setSourceExternalStream(true);
			String fileString = getListAsString(list1);
			InputStream inputStream =  IOUtils.toInputStream(fileString, "UTF-8");
			zipFile.addStream(inputStream , parameters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		
	}

	private static String getListAsString(List<Asset> list1) {
		StringBuffer sb = new StringBuffer();
		for (Asset asset : list1) {
			sb.append(asset.getAssetId());
			sb.append(",");
			sb.append(asset.getAssetName());
			sb.append(",");
			sb.append(asset.getAssetPrice());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	

}
