package com.amazon.creturn.fc.questionnaire;

import java.util.HashMap;

public class Questionnaire {
	String titleStringId;
	HashMap<String, QuestionSet> questionSetMap;
	public String getTitleStringId() {
		return titleStringId;
	}
	public void setTitleStringId(String titleStringId) {
		this.titleStringId = titleStringId;
	}
	public HashMap<String, QuestionSet> getQuestionSetMap() {
		return questionSetMap;
	}
	public void setQuestionSetMap(HashMap<String, QuestionSet> questionSetMap) {
		this.questionSetMap = questionSetMap;
	}
}
