package com.kunal.zipwriter.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import com.kunal.zipwriter.model.Asset;

public class FileUtil {

	public static void writeToFile(List<Asset> list1, File asstFile) {
		Writer writer = null;
		FileOutputStream is = null;
		try {
			is = new FileOutputStream(asstFile);
			OutputStreamWriter osw = new OutputStreamWriter(is);
			writer = new BufferedWriter(osw);
			for (Asset asset : list1) {
				writer.write(String.valueOf(asset.getAssetId()));
				writer.write(",");
				writer.write(asset.getAssetName());
				writer.write(",");
				writer.write(String.valueOf(asset.getAssetPrice()));
				writer.write("\n");
			}
			writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		finally{
			try {
				is.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
