

public class ChecklistMain {
	public static void main(String args[]) {
		
		Checklist CL = new Checklist();
		CL.addFile("AtomSetup-x64.exe", "AtomSetup-x64.msi");
		CL.addFile("Firefox Setup 14.0.1.exe", "Firefox Setup 14.0.1.msi");
		CL.addFile("Dev-Cpp 5.11 TDM-GCC 4.9.2 Setup.exe", "Dev-Cpp 5.11 TDM-GCC 4.9.2 Setup.msi");
		CL.run();
		
	}
}
