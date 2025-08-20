package com.hhstechgroup.util.common;

import com.google.common.io.Files;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;


import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static java.lang.String.format;

public class FileUtils {

    private static Logger logger = Logger.getLogger(FileUtils.class);

    public static final String FILES_PATH = "src/main/resources/";

    public static String fileToString(String pathname) throws IOException {
        StringBuilder builder = new StringBuilder(readFileFromResources(pathname));
        return builder.toString();
    }

    public static String readFileFromResources(String resourcesFileName) throws IOException{
        String fileContent = org.apache.commons.io.FileUtils.readFileToString(fromFile(resourcesFileName), "UTF-8");
        return fileContent;
    }

    public static List<String> getFolderFiles(String folder) {
        File[] files = fromFile(folder).listFiles();
        return Arrays.stream(files).map(file -> file.getName()).collect(Collectors.toList());
    }

    public static File fromFile(String pathname) {
        return new File(FILES_PATH + pathname);
    }

    public static String getAbsolutePath(String path) {
        URL fileUrl = FileUtils.class.getClassLoader().getResource(path);
        if (fileUrl != null) {
            return getFileFromResourcesByFilePath(fileUrl).getAbsolutePath();
        }
        return new File(path).getAbsolutePath();
    }

    private static File getFileFromResourcesByFilePath(URL fileUrl) {
        String fileName = fileUrl.getFile();
        if (isFileInJar(fileName)) {
            return createTemporaryFile(fileName, fileUrl);
        }
        return new File(fileName);
    }

    private static boolean isFileInJar(String file) {
        return file.contains(".jar!/");
    }

    private static File createTemporaryFile(String fileName, URL fileUrl) {
        try {
            File tempFile = new File(Files.createTempDir(), FilenameUtils.getName(fileUrl.getFile()));
            IOUtils.copy(fileUrl.openStream(), org.apache.commons.io.FileUtils.openOutputStream(tempFile));
            return tempFile;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return new File(fileName);
        }
    }

    public static List<String> getZipFilesNames(final String inputFilePath) throws Exception {
        ZipFile zipFile = new ZipFile(inputFilePath);
        Enumeration<?> enu = zipFile.entries();
        List<String> files = new ArrayList<>();

        while(enu.hasMoreElements()) {
            files.add(((ZipEntry)enu.nextElement()).getName());
        }
        zipFile.close();
        return files;
    }

    public static void unZipFile(final String archivePath, String fileName, String destinationPath) {
        try {
            ZipFile zipFile = new ZipFile(archivePath);
            ZipEntry entry = zipFile.getEntry(fileName);
            File newFile = new File(destinationPath + entry.getName());
            InputStream is = zipFile.getInputStream(entry);
            java.nio.file.Files.copy(is, Paths.get(newFile.getAbsolutePath()));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public static void writeZIP(InputStream input, String destinationPath) throws IOException {
        String resourcesPath = FILES_PATH + destinationPath;
        File newFile = new File(resourcesPath);
        newFile.getParentFile().mkdirs();
        byte[] byteArray = IOUtils.toByteArray(input);
        FileOutputStream fos = new FileOutputStream(newFile);
        fos.write(byteArray);
        fos.flush();
        fos.close();
    }



    public static File createFileInDirectory(String dir, String fileName) {
        final File file = getFileFromDirectory(dir, fileName);
        org.apache.commons.io.FileUtils.deleteQuietly(file);
        try {
            file.createNewFile();
        } catch (final IOException e) {
            throw new IllegalStateException(format("Failed to create file [%s]", file.getAbsolutePath()), e);
        }
        return file;
    }

    public static File getFileFromDirectory(String dir, String fileName) {
        final File directory = new File(dir);
        directory.mkdirs();
        return org.apache.commons.io.FileUtils.getFile(directory, fileName);
    }
}
