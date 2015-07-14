package com.amazon.creturn.fc.questionnaire;

import java.util.HashMap;

public class QuestionSet {
	String titleStringId;
	boolean isDependent;
	HashMap<String, Question> questionMap;
	public String getTitleStringId() {
		return titleStringId;
	}
	public void setTitleStringId(String titleStringId) {
		this.titleStringId = titleStringId;
	}
	public boolean isDependent() {
		return isDependent;
	}
	public void setDependent(boolean isDependent) {
		this.isDependent = isDependent;
	}
	public HashMap<String, Question> getQuestionMap() {
		return questionMap;
	}
	public void setQuestionMap(HashMap<String, Question> questionMap) {
		this.questionMap = questionMap;
	}
}
