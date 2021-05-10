package javaChecklist;

public class InstFile {
	private String msiFilename = "";
	private String exeFilename = "";
	String select = "unchecked";
	
	public InstFile() {}
	
	public InstFile(String msi, String exe) {
		this.msiFilename = msi;
		this.exeFilename = exe;
	}
	
	public String getMsiFilename() {
		return msiFilename;
	}
	public String getExeFilename() {
		return exeFilename;
	}
	
	public void setMsiFilename(String msi) {
		this.msiFilename = msi;
	}
	public void setExeFilename(String exe) {
		this.exeFilename = exe;
	}
	public void select(String select) {
		this.select = select;
	}
	
}
