package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public enum FileUtil {

    I;

    public void safeFile(final String fileName, final File srcFile) {
        try {
            final OutputStream oos = new FileOutputStream(fileName);
            final byte[] buf = new byte[8192];
            final InputStream is = new FileInputStream(srcFile);
            int c = 0;
            while ((c = is.read(buf, 0, buf.length)) > 0) {
                oos.write(buf, 0, c);
                oos.flush();
            }

            oos.close();
            System.out.println("stop");
            is.close();
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
