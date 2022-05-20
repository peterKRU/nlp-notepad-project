package local_server.module;

import java.io.Serializable;

public class Concept implements Serializable{
	
	private int conceptId;
	private int parentId;
	private String conceptTag;
	
	public Concept() {
		
	}

	public int getConceptId() {
		return conceptId;
	}

	public void setConceptId(int conceptId) {
		this.conceptId = conceptId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getConceptTag() {
		return conceptTag;
	}

	public void setConceptTag(String conceptTag) {
		this.conceptTag = conceptTag;
	}
	
}
