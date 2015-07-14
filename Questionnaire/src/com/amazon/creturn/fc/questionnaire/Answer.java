package com.amazon.creturn.fc.questionnaire;

import java.util.HashMap;
import java.util.List;

public class Answer {
	String stringId;
	String dependentQuestionSetId;
	HashMap<String, Defect> defectMap;
	boolean isSuperOption;
	int displayOrder;
	
	public boolean isSuperOption() {
		return isSuperOption;
	}
	public void setSuperOption(boolean isSuperOption) {
		this.isSuperOption = isSuperOption;
	}
	public int getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
	public String getStringId() {
		return stringId;
	}
	public void setStringId(String stringId) {
		this.stringId = stringId;
	}
	public String getDependentQuestionSetId() {
		return dependentQuestionSetId;
	}
	public void setDependentQuestionSetId(String dependentQuestionSetId) {
		this.dependentQuestionSetId = dependentQuestionSetId;
	}
	public HashMap<String, Defect> getDefectMap() {
		return defectMap;
	}
	public void setDefectMap(HashMap<String, Defect> defectMap) {
		this.defectMap = defectMap;
	}
	
}
