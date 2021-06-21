#!/src/programInstall.ps1

cd D:\RohYounwoo\javaClient\Client\files\

#filenum0:  Firefox Setup 14.0.1.msi
echo 'installling Firefox Setup 14.0.1.msi......'
echo 'installling process (1 / 2)......'
echo 'in Process....¡á¡á¡á¡à¡à¡à50%..'
$p=Start-Process -FilePath "msiexec" -Wait -PassThru -ArgumentList '/quiet /i "Firefox Setup 14.0.1.msi" WRAPPED_ARGUMENTS="/S"'
echo 'installation complete'

echo errorcode: $p.ExitCode
./errorHandle/ecodeToText.ps1
#filenum1:  Dev-Cpp 5.11 TDM-GCC 4.9.2 Setup.msi
echo 'installling Dev-Cpp 5.11 TDM-GCC 4.9.2 Setup.msi......'
echo 'installling process (2 / 2)......'
echo 'in Process....¡á¡á¡á¡á¡á¡á100%..'
$p=Start-Process -FilePath "msiexec" -Wait -PassThru -ArgumentList '/quiet /i "Dev-Cpp 5.11 TDM-GCC 4.9.2 Setup.msi" WRAPPED_ARGUMENTS="/S"'
echo 'installation complete'

echo errorcode: $p.ExitCode
./errorHandle/ecodeToText.ps1

sleep 60
