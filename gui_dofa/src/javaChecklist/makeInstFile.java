package javaChecklist;

public class makeInstFile {
	InstFile[] arr = new InstFile[100];
	int counter = InstFile.getCount();
	arr[counter] = new InstFile("atom", "atom");
	InstFile f2 = new InstFile("firefox", "firefox");
	arr[counter] = new InstFile("atom", "atom");
	InstFile f3 = new InstFile("Devcpp", "Devcpp");
	arr[counter] = new InstFile("atom", "atom");
}
