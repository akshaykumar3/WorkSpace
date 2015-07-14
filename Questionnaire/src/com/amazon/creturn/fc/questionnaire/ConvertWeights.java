package com.amazon.creturn.fc.questionnaire;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.bind.DatatypeConverter;

import com.google.gson.Gson;

public class ConvertWeights {
	public static void main(String args[]) throws Exception {
		String json="";
		BufferedReader bufferedReader = new BufferedReader(new FileReader("json"));
		String x = null;
		x = bufferedReader.readLine();
		while(x!=null){
			json = json+x;
			x = bufferedReader.readLine();
		}
		bufferedReader.close();
		json.replace("\t", "");
		System.out.println(json);
		String encodedJson = getEncodedjson(json,"");
		System.out.println(encodedJson);
	}

	public static String getEncodedjson(String json,String questionnaireId){
		Gson gson = new Gson();
		boolean isIndenpendentQuestionSet = false;
		Set<String> defectOwnerList = new HashSet<String>();
		defectOwnerList.add("Customer");
		defectOwnerList.add("Vendor");
		defectOwnerList.add("Carrier");
		defectOwnerList.add("Fulfiller");
		List<String> independentQSets = new ArrayList<String>();
		Questionnaire questionnaire = gson.fromJson(json, Questionnaire.class);
		for(Entry<String, QuestionSet> entry : questionnaire.getQuestionSetMap().entrySet()) {
			isIndenpendentQuestionSet = !entry.getValue().isDependent();
			if(isIndenpendentQuestionSet){
				independentQSets.add(entry.getKey());
			}
			String questionSetId = entry.getKey();
			String questionSetTitleStringId = entry.getValue().getTitleStringId();
			for(Entry<String, Question> questionEntry : entry.getValue().getQuestionMap().entrySet()) {
				String key = questionEntry.getKey();
				Question value = questionEntry.getValue();
				String type = value.getQuestionType();
				//System.out.println(value.stringId);
				for(Entry<String, Answer> answerEntry : questionEntry.getValue().getAnswerMap().entrySet()) {
					Answer answer = answerEntry.getValue();
					//System.out.println(answer.stringId);
					if(answer.getDependentQuestionSetId()!=null && !questionnaire.getQuestionSetMap().containsKey(answer.getDependentQuestionSetId()))
						throw new RuntimeException(answer.getDependentQuestionSetId()+ " is not defined in questionnSetMap");
					if(answer.getDefectMap()!=null && answer.getDefectMap().size() == 1 ) {
						for(Entry<String,Defect> defectEntry : answer.getDefectMap().entrySet()) {
							System.out.println("questionnaireId: "+questionnaireId);
							System.out.println("defect key: "+defectEntry.getKey());
							System.out.println("defect value: "+defectEntry.getValue().getStringId());
							System.out.println(questionnaireId+"\t"+defectEntry.getKey()+"\t"+defectEntry.getValue().getStringId());
							String def = defectEntry.getValue().getDefectOwnerList().get(0).getOwner();
							System.out.println(def);
							if(!defectOwnerList.contains(def)) {
								System.out.println("\n\n\n\n\n\n\n\n\n\n\nDude "+def+" is not a valid defectOwner.\nSee the valid list in defectOwnerList.\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								return null;
							}
							//System.out.println(defectEntry.getValue().getStringId());
							if(defectEntry.getValue().getDefectOwnerList().size() == 1);
								//updateWeights(defectEntry.getValue().getDefectOwnerList().get(0),10);
						}
					}
				}
			}
		}
		if(independentQSets.size() == 0)
			throw new RuntimeException("There is no independent questionn set in the json");
		String newJson = gson.toJson(questionnaire);
		if(independentQSets.size() != 1) {
			System.out.println("\nDude, you fucked up :P\nYou have more than 1 independent QSets, are you sure?\nIndependent QSets are:");
			for(String QSetName : independentQSets) {
				System.out.println(QSetName);
			}
		}
		//System.out.println(newJson);
		String encodedJson = DatatypeConverter.printBase64Binary(newJson.getBytes());
		return encodedJson;
	}

	private static void updateWeights(DefectOwner defect, int multiple) {
		defect.setWeight(defect.getWeight()*multiple);
	}
}
