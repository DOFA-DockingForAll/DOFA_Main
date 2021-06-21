

public class ChecklistMain {
	public static void main(String args[]) {
		
		// 프로그램 목록 addFile 필요 - 프로그램 리스트 불러오기 구현해야댐 + 유저아이디 입력 구현 - GUI구현
		
		// 어떤거 업데이트할지 선택하게 하는 창 주기. 현재는 텍스트로 입력 받음.
		//프로그램 시작. 공유 받는 중일 시 자동업데이트
		ProgramUpdate PU = new ProgramUpdate();
		PU.startUpdate(); // 최신으로 업데이트
		
		
		/*
		// 새로운 사람의 설치 환경 공유받기
		ProgramUpdate PU = new ProgramUpdate();
		PU.changeTargetUSR("chavi55"); // chavi55 설치환경 공유받기
		//PU.changeTargetUSR("twofox00");
		PU.startUpdate(); // 최신으로 업데이트
		*/
		
		
		//체크리스트로 다운 - 이 방식으로 된 다운로드를 다른 사람이 공유받을 수 있음
		Checklist CL = new Checklist();
		CL.setUsrID("twofox00"); // 사용중인 유저 아이디 셋팅
		CL.addFile("AtomSetup-x64.exe", "AtomSetup-x64.msi");
		CL.addFile("Firefox Setup 14.0.1.exe", "Firefox Setup 14.0.1.msi");
		CL.addFile("Dev-Cpp 5.11 TDM-GCC 4.9.2 Setup.exe", "Dev-Cpp 5.11 TDM-GCC 4.9.2 Setup.msi");
		CL.run();
		
	}
}
