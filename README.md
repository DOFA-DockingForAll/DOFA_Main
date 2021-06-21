# DOFA_Main
DOFA main repository
Docking for all-project

# instruction
### put msi files in DOFA_YW/Server/files directory
### start server
### put list of files you want to auto-install in client(via gui)
### start client

# server
### set port to official ip https://4sii.tistory.com/3

# client 
### 실행확인 팝업창 확인 https://nhj12311.tistory.com/342
### ps1파일 파워쉘로 실행되게 https://www.youtube.com/watch?v=AT_t2jiGuy8 
### 에러 코드를 얻고싶은 경우 java클라이언트 관리자 권한으로 실행


# How to get error code
$p=Start-Process -FilePath "msiexec" -Wait -PassThru -ArgumentList '/quiet /i "Dev-Cpp 5.11 TDM-GCC 4.9.2 Setup.msi" WRAPPED_ARGUMENTS="/S"'; $p.ExitCode
./errorHandle/ecodeToText.ps1