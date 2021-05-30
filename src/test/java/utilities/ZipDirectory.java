package utilities;

import org.zeroturnaround.zip.ZipUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDirectory {
    /**
     *
     * zipDirectories Method used to zip reports directory using absolute path
     *
     */
    public static void zipDirectories() throws IOException {
        File directoryToZip = new File(ConfigurationReader.getProperty("reportPath"));
        List<File> fileList = new ArrayList<File>();
        System.out.println("---Getting references to all files in: " + directoryToZip.getCanonicalPath());
        getAllFiles(directoryToZip, fileList);
        System.out.println("---Creating zip file");
        writeZipFile(directoryToZip, fileList);
        System.out.println("---Done");
        System.out.println("After suite will always execute at last when all the annotations or test in the suite have run.");
    }
    /**
     *
     * getAllFiles method collects all File objects with all the subdirectories from the main directory
     *
     */
    public static void getAllFiles(File dir, List<File> fileList) {
        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                fileList.add(file);
                if (file.isDirectory()) {
                    System.out.println("directory:" + file.getCanonicalPath());
                    getAllFiles(file, fileList);
                } else {
                    System.out.println("     file:" + file.getCanonicalPath());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * writeZipFile will create a zip file of the directory and will append .zip to the end of the directory
     *
     */
    public static void writeZipFile(File directoryToZip, List<File> fileList) {
        try {
            FileOutputStream fos = new FileOutputStream(directoryToZip.getName() + ".zip");
            ZipOutputStream zos = new ZipOutputStream(fos);
            for (File file : fileList) {
                if (!file.isDirectory()) {
                    addToZip(directoryToZip, file, zos);
                }
            }
            zos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * addToZip method reads the contents inside the File object and writes its content to the zip file
     *
     */
    public static void addToZip(File directoryToZip, File file, ZipOutputStream zos) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(file);
        String zipFilePath = file.getCanonicalPath().substring(directoryToZip.getCanonicalPath().length() + 1,
                file.getCanonicalPath().length());
        System.out.println("Writing '" + zipFilePath + "' to zip file");
        ZipEntry zipEntry = new ZipEntry(zipFilePath);
        zos.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zos.write(bytes, 0, length);
        }
        zos.closeEntry();
        fis.close();
    }
    /**
     *
     * This method will zip a directory and save it to any path you select uses zt-zip dependency
     *
     */
    public static void zipFile() {
        ZipUtil.pack(new File("{path to your cucumber-report directory}"),
                new File("{path where you want to save this directory}"));
    }
}

