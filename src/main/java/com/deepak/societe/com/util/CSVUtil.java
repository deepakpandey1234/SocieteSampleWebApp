package com.deepak.societe.com.util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import com.deepak.societe.com.Model.UserData;

public class CSVUtil {

  public static void main(String[] args) {
CSVUtil csvutil=new CSVUtil();
	csvutil.parseCsv();

  }

  public HashMap<String,UserData> parseCsv() {
	InputStream csvFile = this.getClass().getResourceAsStream("/member_detail.csv");
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
	String[] data={};
	HashMap<String, UserData> hashmap=new HashMap<String, UserData>();

	try {

		br = new BufferedReader(new InputStreamReader(csvFile));
		while ((line = br.readLine()) != null) {

		    // use comma as separator
			data = line.split(cvsSplitBy);
			UserData userData=new UserData();
			userData.setId(data[0].replace("\"", ""));//.replaceAll("\"", "\\\\\")); //replaceAll("\"", "\\\\\"")
			userData.setStatus(data[1].replace("\"", ""));
			userData.setRace(data[2].replace("\"", ""));
			userData.setWeight(data[3].replace("\"", ""));
			userData.setHeight(data[4].replace("\"", ""));
			userData.setIs_veg(data[5].replace("\"", ""));
			
			hashmap.put(data[0].replace("\"", ""), userData);

			System.out.println(data[0]+" "+data[1]+" "+data[2]+" "+data[3]+" "+data[4]+" "+data[5]);
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	return hashmap;
  }

}