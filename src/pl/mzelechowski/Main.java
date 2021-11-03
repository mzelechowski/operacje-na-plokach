package pl.mzelechowski;

import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String path="C:\\Mike\\operacje-na-plokach\\src\\storage\\";
        String fileName="jakisplik.txt";
	CustomFileProvider customFileProvider = new CustomFileProvider(path);
	customFileProvider.readFileBasic(fileName);
	customFileProvider.createFileUsingFileClass("maciek.txt");
//        List<String> names = Arrays.asList("Maciek", "Anna", "Piotrek", "Danusia");
//	customFileProvider.createFileFromCollection("file3.txt", names, StandardOpenOption.APPEND);

	List<String> lista;
	lista = customFileProvider.createDataFromFile("file3.txt");
        for (String s:lista) {
            System.out.println(s);
        }

    }
}
