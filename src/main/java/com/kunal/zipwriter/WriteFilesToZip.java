package com.kunal.zipwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import net.lingala.zip4j.exception.ZipException;

import com.google.common.base.Stopwatch;
import com.kunal.zipwriter.model.Asset;
import com.kunal.zipwriter.utils.FileUtil;
import com.kunal.zipwriter.utils.ZipUtil;

public class WriteFilesToZip {

	public static List<Asset> list1 = new ArrayList<Asset>();
	public static List<Asset> list2 = new ArrayList<Asset>();

	public static void main(String[] args) throws ZipException,
			FileNotFoundException {
		buildList();
		writeTraditional();
	}

	private static void writeTraditional() throws ZipException {
		File file1 = new File("C:\\LunaWorkspace\\ZipWriter\\File1");
		File file2 = new File("C:\\LunaWorkspace\\ZipWriter\\File2");
		Stopwatch stopwatch = Stopwatch.createStarted();
		FileUtil.writeToFile(list1, file1);
		FileUtil.writeToFile(list2, file2);
		List<File> filesToZip = new ArrayList<File>();
		filesToZip.add(file1);
		filesToZip.add(file2);
		ZipUtil.zipFiles(filesToZip);
		System.out.println(stopwatch.stop());

	}

	private static void buildList() {
		for (int i = 0; i < 5000000; i=i+2) {
			list1.add(new Asset(i, "Vodaphone", 12.3));
			list1.add(new Asset(i+1, "Verizon", 2.35));
		}

		for (int i = 0; i < 5000000; i=i+2) {
			list2.add(new Asset(555, "Google", 363.2));
			list2.add(new Asset(666, "Microsoft", 522.3));
		}

	}

}
