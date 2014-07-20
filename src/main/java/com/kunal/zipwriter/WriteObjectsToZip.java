package com.kunal.zipwriter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import net.lingala.zip4j.exception.ZipException;

import com.google.common.base.Stopwatch;
import com.kunal.zipwriter.model.Asset;
import com.kunal.zipwriter.utils.ZipUtil;

public class WriteObjectsToZip {
	
	public static List<Asset> list1 = new ArrayList<Asset>();
	public static List<Asset> list2 = new ArrayList<Asset>();
	
	public static void main(String[] args) throws ZipException, FileNotFoundException {
		buildList();
		writeDirectlyToZip();
		
	}

	private static void writeDirectlyToZip() throws FileNotFoundException, ZipException {
		Stopwatch stopwatch = Stopwatch.createStarted();
		ZipUtil.writeToZip(list1,"file1");
		ZipUtil.writeToZip(list2,"file2");
		System.out.println(stopwatch.stop());
	}

	private static void buildList() {
		for (int i = 0; i < 5000000; i=i+2) {
			list1.add(new Asset(i, "Vodaphone", 12.3));
			list1.add(new Asset(i+1, "Verizon", 2.35));
		}

		for (int i = 0; i < 5000000; i=i+2) {
			list2.add(new Asset(i, "Google", 363.2));
			list2.add(new Asset(i+1, "Microsoft", 522.3));
		}

	}

}
