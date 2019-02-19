package com.gamer.test;

import java.io.File;
import java.util.*;

public class ReadAllFiles {

	public static ArrayList<String> getFiles(String path) {
	    ArrayList<String> files = new ArrayList<String>();
	    File file = new File(path);
	    File[] tempList = file.listFiles();

	    for (int i = 0; i < tempList.length; i++) {
	        if (tempList[i].isFile()) {
//	              System.out.println("文     件：" + tempList[i]);
	            files.add("picture/" + tempList[i].getName().toString());
	        }
	        if (tempList[i].isDirectory()) {
//	              System.out.println("文件夹：" + tempList[i]);
	        }
	    }
	    return files;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (String s:getFiles("C:\\Users\\Raindrop\\Desktop\\20160506\\20160506尺寸未修改原版尺寸")) {
			System.out.println("File Name:" + s);
		}
	}

}
