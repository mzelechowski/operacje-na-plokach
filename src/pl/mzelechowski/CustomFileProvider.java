package pl.mzelechowski;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class CustomFileProvider {
    private final String path;

    public CustomFileProvider(String path) {
        this.path = path;
    }

    /**
     * czytanie pliku linia po linii za pomocą klasy BufferedReader
     */
    public void readFileBasic(String fileName) {
        /** BufferedReader to klada czytająca znak po zanku (char) z uwzględniem znaku końca linii (\n)*/
        BufferedReader bufferedReader; //TWorze referencję do obiektu
        try {
            FileReader fileReader = new FileReader(path + fileName);
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * tworzenie pustego pliku
     */
    public void createFileUsingFileClass(String filename) {
        File file = new File(path + filename);
        try {
            if (file.createNewFile()) {
                System.out.println("file created: " + file.getAbsolutePath());
            } else {
                System.out.println("File already exists or another error");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * zapisywanie pliku z podanem wartości w fomie List<String>
     */
    public void createFileFromCollection(String filename, List<String> input, OpenOption option) {
        /** klasa Paths to klasa pomocnicza do operacji na ścieżkach dostęu do pliku*/
        Path path = Paths.get(this.path + filename);
        try {
/**klasa Files od Javy8 to klasa pomocnicza dla klasy File. Pomaga w operacjach na plikach*/
            if (Files.notExists(path)) {
                Files.createFile(path);
            }/** Metoda  statycznafile write przyjmuje  takie parametry: ścieżke do pliku typu path
             liste danych w formie kolekcji String list<String>
             format zapisu danych, wybralem UTF_9
             opcjonalnie: opcje zapisu pliku: dodatnie danych do pliku istn. albo zastąpienie plku*/
            String text = "!!! Koniec zapisau z listy " + System.lineSeparator() + System.lineSeparator();
            Files.write(path, input, StandardCharsets.UTF_8, option);
            Files.write(path, text.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            //Files.writeString(path,"Jakis string "+"\n", StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> createDataFromFile(String fileName) {
        BufferedReader bufferedReader;  //Tworze referencję do obiektu
        List<String> output = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(path + fileName));
            String line = bufferedReader.readLine(); // czytam pierwszą linię  w pliku
            while(line != null) {
                output.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); //drukuje stack błędu
        }
        return output;
    }
    public List<Computer> readStorage(String fileName){
        BufferedReader bufferedReader;
        List<Computer> output=new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(path + fileName));
            String line = bufferedReader.readLine();
            while(line!=null){
                String[] values =line.split(",");
                Computer computer=new Computer();
                computer.setMainBoard(values[0].trim());
                computer.setCpu(values[1].trim());
                computer.setGpu(values[2].trim());
                computer.setHardDisk(values[3].trim());
                computer.setCost(values[4].trim());
                output.add(computer);
                line=bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); //drukuje stack błędu
        }
        return output;
    }
    //metoda która, zlicza ile razy podany wyraz wystąpił w pliku tekstowym.
    public void getWorldFromFile(String fileName, String pattern){
        BufferedReader bufferedReader;
        int wordCounter=0, lineCounter=0;
        try {
            bufferedReader = new BufferedReader(new FileReader(path + fileName));
            String line = bufferedReader.readLine();
            while(line!=null){
                lineCounter++;
                String[] words =line.split(" ");
                for(String w:words){
                    if(w.contains(pattern)){
                        wordCounter++;
                        System.out.println("Znalazłem szukane słowo w linijece: "+lineCounter +", słowo: " + w);
                    }
                }
                line=bufferedReader.readLine();
            }
            System.out.println("Znalazłem "+ wordCounter + " szukanych słow.");
        } catch (IOException e) {
            e.printStackTrace(); //drukuje stack błędu
        }
    }
    ////////////////////////////////////////////
    public void getDataFromUrl(String page, String pattern){
        URL url= null;
        try {
            int wordCounter=0, lineCounter=0;
            url = new URL(page);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            while(line!=null){

                lineCounter++;
                String[] words =line.split(" ");
                for(String w:words){
                    if(w.contains(pattern)){
                        wordCounter++;
                        System.out.println("Znalazłem szukane słowo w linijece: "+lineCounter +", słowo: " + w);
                       // System.out.println("Czytam linię: "+line);
                    }
                }
                line = reader.readLine();
            }
            System.out.println("Znalazłem "+ wordCounter + " szukanych słow.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
