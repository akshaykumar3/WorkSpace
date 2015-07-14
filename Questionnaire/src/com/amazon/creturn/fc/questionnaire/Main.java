package com.amazon.creturn.fc.questionnaire;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;

import com.google.gson.Gson;

public class Main {
	public static void main(String args[]) throws IOException {
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
		Gson gson = new Gson();
		Questionnaire questionnaire = gson.fromJson(json, Questionnaire.class);
		BufferedWriter writer = new BufferedWriter(new FileWriter("graph.gv"));
		write(writer,"digraph G {");
		for(Entry<String, QuestionSet> entry : questionnaire.getQuestionSetMap().entrySet()) {
			QuestionSet questionSet = entry.getValue();
			if(!questionSet.isDependent()) {
				write(writer, "start -> " + getFirstQuestionIdFromSet(questionSet) +";" );
			}
			write(writer,"subgraph "+ entry.getKey()+"{ ");
			write(writer,"label = \""+ questionSet.getTitleStringId()+"\";");
			write(writer,"style=filled;\ncolor=lightgrey;");
			for(Entry<String, Question> questionEntry : questionSet.getQuestionMap().entrySet()) {
				for(Entry<String, Answer> answerEntry : questionEntry.getValue().getAnswerMap().entrySet()) {
					write(writer, questionEntry.getKey() + " -> " + answerEntry.getKey() + ";");
				}
			}
			write(writer, "}");
		}
		for(Entry<String, QuestionSet> entry : questionnaire.getQuestionSetMap().entrySet()) {
			QuestionSet questionSet = entry.getValue();
			for(Entry<String, Question> questionEntry : questionSet.getQuestionMap().entrySet()) {
				write(writer,questionEntry.getKey() +" [label=\""+questionEntry.getValue().getStringId()+"\",shape=ellipse,fillcolor=\"burlywood\",style=\"filled\"];");
				for(Entry<String, Answer> answerEntry : questionEntry.getValue().getAnswerMap().entrySet()) {
					write(writer, answerEntry.getKey()+"[label=\""+answerEntry.getValue().getStringId()+"\"];");
					if(answerEntry.getValue().getDependentQuestionSetId()!=null) {
						write(writer, answerEntry.getKey() + " -> " + getFirstQuestionIdFromSet(
								questionnaire.getQuestionSetMap().
								get(answerEntry.getValue().getDependentQuestionSetId()))+";");
					}
				}
			}
		}
		write(writer,"}");
		writer.close();
	}
	
	private static String getFirstQuestionIdFromSet(QuestionSet questionSet) {
		for(Entry<String, Question> entry : questionSet.getQuestionMap().entrySet()) {
			return entry.getKey();
		}
		return null;
	}

	private static void write(BufferedWriter bufferedWriter, String string) throws IOException {
		bufferedWriter.write(string+"\n");
	}
}
