package invernadero.models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private String ftpServer;
    private String ftpPort;
    private String ftpUser;
    private String ftpPassword;
    private String ftpDirectory;

    public String getFtpServer() {
        return ftpServer;
    }

    public String getFtpDirectory() {
        return ftpDirectory;
    }

    public void setFtpDirectory(String ftpDirectory) {
        this.ftpDirectory = ftpDirectory;
    }

    public String getFtpPassword() {
        return ftpPassword;
    }

    public void setFtpPassword(String ftpPassword) {
        this.ftpPassword = ftpPassword;
    }

    public String getFtpUser() {
        return ftpUser;
    }

    public void setFtpUser(String ftpUser) {
        this.ftpUser = ftpUser;
    }

    public String getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(String ftpPort) {
        this.ftpPort = ftpPort;
    }

    public void setFtpServer(String ftpServer) {
        this.ftpServer = ftpServer;
    }

    public Config load() throws IOException {
        InputStream inputStream = null;
        Config result = null;
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			// get the property value and print it out
			String ftp_server = prop.getProperty("ftp_server");
			String ftp_port = prop.getProperty("ftp_port");
			String ftp_user = prop.getProperty("ftp_user");
			String ftp_password = prop.getProperty("ftp_password");
            String ftp_directory = prop.getProperty("ftp_directory");

            result = new Config();
            result.setFtpServer(ftp_server);
            result.setFtpPort(ftp_port);
            result.setFtpUser(ftp_user);
            result.setFtpPassword(ftp_password);
            result.setFtpDirectory(ftp_directory);

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
            if(inputStream != null)
			    inputStream.close();
		}
		return result;
	}
}