package local_server.module;

public class Note {

	private int noteId;
	private int parentId;
	private String noteTag;
	private String payload;
	
	public Note() {
		
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getNoteTag() {
		return noteTag;
	}

	public void setNoteTag(String noteTag) {
		this.noteTag = noteTag;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}	
	
	
}
