package fr.evogames.evowatchercontroller.utils;

import java.io.*;

public class FileUtils {

    public static void save(File file, String data) {
        FileWriter fw;

        try {
            fw = new FileWriter(file);
            if (!file.exists()) {
                if (!file.getParentFile().exists())file.getParentFile().mkdir();
                file.mkdir();
                file.createNewFile();
            }
            fw.write(data);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String load(File file) {
        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }


    public static void copy(File source, File dest) {
        if (source.isDirectory()) {
            copyDir(source, dest);
        } else {
            copyFile(source, dest);
        }
    }

    private static void copyFile(File source, File dest) {
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];
            int lenght;

            while ((lenght = is.read(buffer)) > 0) {
                os.write(buffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void copyDir(File source, File target) {
        if (!target.exists()) {
            target.mkdir();
        }

        for (String f : source.list()) {
            copyFile(new File(source, f), new File(target, f));
        }
    }

}
