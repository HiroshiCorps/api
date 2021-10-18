package fr.redxil.api.common.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

public class FileUtils {

    public static boolean downloadFile(File destFile, URL url, FilePercentageReceiver fpr) {

        boolean result = false;

        BufferedInputStream in = null;
        FileOutputStream out = null;

        try {
            URLConnection conn = url.openConnection();
            int size = conn.getContentLength();

            if (size < 0) {
                if (fpr != null)
                    fpr.noPercentage();
            } else {
                if (fpr != null)
                    fpr.fileSize(size);
            }

            in = new BufferedInputStream(url.openStream());
            out = new FileOutputStream(destFile);

            byte[] data = new byte[1024];
            int count;
            double sumCount = 0.0;

            while ((count = in.read(data, 0, 1024)) != -1) {
                out.write(data, 0, count);
                sumCount += count;
                if (size > 0) {
                    double percent = (sumCount / size * 100.0);
                    if (fpr != null)
                        fpr.changePercentage(percent);
                }
            }

            result = true;

        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
        return result;
    }

    public static boolean copyFolder(File src, File dest) throws IOException {

        if (!src.exists())
            return false;

        if (src.isDirectory()) {

            String[] files = src.list();
            assert files != null;
            for (String file : files) {
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                if (!copyFolder(srcFile, destFile)) return false;
            }

        } else {

            if (dest.exists())
                if (!deleteFolder(dest)) return false;

            Files.copy(src.toPath(), dest.toPath());

        }

        return true;
    }

    public static boolean deleteFolder(File src) {
        if (src.exists()) return src.delete();
        return false;
    }

}
