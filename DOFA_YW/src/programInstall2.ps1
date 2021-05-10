cd D:/RohYounwoo/javaCode/Basic/src/

Start-Process -FilePath "msiexec" -Wait -ArgumentList '/quiet /i "Firefox Setup 14.0.1.msi" WRAPPED_ARGUMENTS="/S"'

Start-Process -FilePath "msiexec" -Wait -ArgumentList '/quiet /i "AtomSetup-x64.msi" WRAPPED_ARGUMENTS="/S"'

