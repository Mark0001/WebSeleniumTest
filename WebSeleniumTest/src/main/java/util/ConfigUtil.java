package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum ConfigUtil {

    I;

    private Properties properties;

    ConfigUtil() {
        final InputStream is = this.getClass().getResourceAsStream("/config/setting.properties");

        this.properties = new Properties();

        try {
            this.properties.load(is);
            is.close();

        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public String getCodeFromKey(final String key) {
        return this.properties.getProperty(key);
    }
}
