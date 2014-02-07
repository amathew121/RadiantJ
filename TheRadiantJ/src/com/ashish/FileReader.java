package com.ashish;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringTokenizer;

public class FileReader {
	
	public static void main(String args[]) throws IOException {
		URL url = FileReader.class.getResource("input.txt");
		File file = new File(url.getPath());
		InputStream input = FileReader.class.getResourceAsStream("input.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		String s;
		s = br.readLine();
		System.out.println(s.charAt(4));
		StringTokenizer st = new StringTokenizer(s);
		while(st.hasMoreTokens())
		System.out.println(st.nextToken());
		//s = file.toString();
		
	}
	

}