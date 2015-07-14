package com.amazon.creturn.fc.questionnaire;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class QuestionnaireUpload {
	public static void main(String args[]) throws IOException {
		File folder = new File("QuestionnaireUpload");
		File[] listOfFiles = folder.listFiles();
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
				"questionnaireUpload.txt"));
		for (File file : listOfFiles) {
			String fileName = file.getName();
			fileName = fileName.replaceAll(".txt", "");
			//System.out.println(fileName);
			String json = "";
			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					file));
			String x = null;
			x = bufferedReader.readLine();
			while (x != null) {
				json = json + x;
				x = bufferedReader.readLine();
			}
			bufferedReader.close();
			json.replace("\t", "");
			//System.out.println(json);
			String encodedJson = ConvertWeights.getEncodedjson(json,fileName);
			bufferedWriter.write("{cretfc_questionnaire_id:\"" + fileName
					+ "\",cretfc_questionnaire_definition:{{" + encodedJson
					+ "}},table_name:cretfc_questionnaire_definitions,stage_version:\"\"}\n");
		}
		bufferedWriter.close();
	}
}
