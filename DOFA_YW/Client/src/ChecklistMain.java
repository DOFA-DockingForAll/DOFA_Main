

public class ChecklistMain {
	public static void main(String args[]) {
		
		// ���α׷� ��� addFile �ʿ� - ���α׷� ����Ʈ �ҷ����� �����ؾߴ� + �������̵� �Է� ���� - GUI����
		
		// ��� ������Ʈ���� �����ϰ� �ϴ� â �ֱ�. ����� �ؽ�Ʈ�� �Է� ����.
		//���α׷� ����. ���� �޴� ���� �� �ڵ�������Ʈ
		ProgramUpdate PU = new ProgramUpdate();
		PU.startUpdate(); // �ֽ����� ������Ʈ
		
		
		/*
		// ���ο� ����� ��ġ ȯ�� �����ޱ�
		ProgramUpdate PU = new ProgramUpdate();
		PU.changeTargetUSR("chavi55"); // chavi55 ��ġȯ�� �����ޱ�
		//PU.changeTargetUSR("twofox00");
		PU.startUpdate(); // �ֽ����� ������Ʈ
		*/
		
		
		//üũ����Ʈ�� �ٿ� - �� ������� �� �ٿ�ε带 �ٸ� ����� �������� �� ����
		Checklist CL = new Checklist();
		CL.setUsrID("twofox00"); // ������� ���� ���̵� ����
		CL.addFile("AtomSetup-x64.exe", "AtomSetup-x64.msi");
		CL.addFile("Firefox Setup 14.0.1.exe", "Firefox Setup 14.0.1.msi");
		CL.addFile("Dev-Cpp 5.11 TDM-GCC 4.9.2 Setup.exe", "Dev-Cpp 5.11 TDM-GCC 4.9.2 Setup.msi");
		CL.run();
		
	}
}
