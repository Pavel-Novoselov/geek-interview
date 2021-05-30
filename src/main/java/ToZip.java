import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class ToZip {
    private static final int BUFFER = 80000;

    public static void main(String[] args) throws IOException {
        String[] files = new String[]{"1.pdf", "2.pdf", "3.pdf", "5.pdf"};
        List<String> fileList = Arrays.asList(files);
        String zipFileName = "zip1.zip";
        zip(fileList, zipFileName);
    }

    public static void zip(List<String> files, String zipFileName) throws IOException {
        try(ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFileName)))) {
            byte data[] = new byte[BUFFER];
            files.forEach(file -> {
                try(BufferedInputStream origin = new BufferedInputStream(new FileInputStream(file), BUFFER)){
                    ZipEntry entry = new ZipEntry(file.substring(file.lastIndexOf("/") + 1));
                    out.putNextEntry(entry);
                    int count;
                    while ((count = origin.read(data, 0, BUFFER)) != -1) {
                        out.write(data, 0, count);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
