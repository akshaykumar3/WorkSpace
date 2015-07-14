package com.amazon.creturn.fc.questionnaire;

import java.util.List;

public class Defect {
	private String defectId;
	private String stringId;
	private List<DefectOwner> defectOwnerList;
	public String getDefectId() {
		return defectId;
	}
	public void setDefectId(String defectId) {
		this.defectId = defectId;
	}
	public String getStringId() {
		return stringId;
	}
	public void setStringId(String stringId) {
		this.stringId = stringId;
	}
	public List<DefectOwner> getDefectOwnerList() {
		return defectOwnerList;
	}
	public void setDefectOwnerList(List<DefectOwner> defectOwnerList) {
		this.defectOwnerList = defectOwnerList;
	}
	
}
