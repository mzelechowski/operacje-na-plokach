package pl.mzelechowski;

public class Main {

    public static void main(String[] args) {
        String path="C:\\Mike\\operacje-na-plokach\\src\\storage\\";
        String fileName="jakisplik.txt";
	CustomFileProvider customFileProvider = new CustomFileProvider(path);
	customFileProvider.readFileBasic(fileName);
	customFileProvider.createFileUsingFileClass("maciek.txt");

    }
}
