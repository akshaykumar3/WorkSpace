package com.amazon.creturn.fc.questionnaire;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.xml.bind.DatatypeConverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GetQuestionnaires {
	public static void main(String args[]) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("questionnaire.ion"));
		File dir = new File("Questionnaires");
		dir.mkdir();
		String x = null;
		x = bufferedReader.readLine();
		HashMap<String, String> questionnaireMap = new HashMap<String, String>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		while (x!=null) {
			x = x.substring(1);
			x = x.substring(0, x.length()-1);
			String [] mapSplit = x.split(",");
			HashMap<String, String> splitMap = new HashMap<String, String>();
			for(int i= 0; i< mapSplit.length; i++) {
				String[] newSplit = mapSplit[i].split(":");
				splitMap.put(newSplit[0], newSplit[1]);
			}
			questionnaireMap.put(splitMap.get("cretfc_questionnaire_id"), splitMap.get("cretfc_questionnaire_definition"));
			x = bufferedReader.readLine();
			
		}
		for(Entry<String, String> entry : questionnaireMap.entrySet()) {
			String fileName = entry.getKey().substring(1);
			fileName = fileName.substring(0,fileName.length()-1);
			File newFile = new File("Questionnaires/"+fileName+".txt");
			newFile.createNewFile();
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));
			String encodedJson = entry.getValue().substring(2);
			encodedJson = encodedJson.substring(0,encodedJson.length()-2);
			byte[] jsonbytes = DatatypeConverter.parseBase64Binary(encodedJson);
			String json = new String(jsonbytes);
			System.out.println(fileName);
			Questionnaire obj = gson.fromJson(json, Questionnaire.class);
			json = gson.toJson(obj);
			bufferedWriter.write(json);
			bufferedWriter.close();
		}
		bufferedReader.close();
	}

}
