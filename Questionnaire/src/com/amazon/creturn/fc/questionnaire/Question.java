package com.amazon.creturn.fc.questionnaire;

import java.util.HashMap;

public class Question {
	String stringId;
	String questionType;
	HashMap<String, Answer> answerMap;
	public String getStringId() {
		return stringId;
	}
	public void setStringId(String stringId) {
		this.stringId = stringId;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public HashMap<String, Answer> getAnswerMap() {
		return answerMap;
	}
	public void setAnswerMap(HashMap<String, Answer> answerMap) {
		this.answerMap = answerMap;
	}
}
