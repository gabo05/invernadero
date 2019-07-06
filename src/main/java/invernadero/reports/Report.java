package invernadero.reports;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.ArrayList;

import invernadero.models.*;

public class Report {
    private Config configuration;
    public Report(Config config) {
        configuration = config;
    }
    private List<String[]> data;
    private void downloadData() {
        data = new ArrayList<String[]>();
        try {
            Config config = new Config().load();

            String sUrl = "ftp://"+config.getFtpUser()+":"+config.getFtpPassword()+"@"+config.getFtpServer()+":"+config.getFtpPort()+"/"+config.getFtpDirectory()+"/jb180811.prn";
            URL url = new URL(sUrl);
            URLConnection con = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                                        con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null){
                String[] fields = inputLine.split("\t");
                if(fields.length > 2) {
                    data.add(fields);
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private List<Orden64> orden64Report;
    public List<Orden64> getOrden64Report() {
        return orden64Report;
    }
    private List<Orden60> orden60Report;
    public List<Orden60> getOrden60Report() {
        return orden60Report;
    }

    private void readReports() {
        orden60Report = new ArrayList<Orden60>();
        orden64Report = new ArrayList<Orden64>();
        Orden orden;
        for (String[] line : data) {
            String ordenNum = line[2].split(":")[0].replaceAll("[\\D]", "");
            if(ordenNum.equals("060")){
                orden = new Orden60();
                orden.readLine(line);
                orden60Report.add((Orden60)orden);
            } else if(ordenNum.equals("064")){
                orden = new Orden64();
                orden.readLine(line);
                orden64Report.add((Orden64)orden);
            }
        }
    }
    public void generateReports() {
        this.downloadData();
        this.readReports();
        ReportGenerator generator = new ReportGenerator();
        generator.generateOrden60Report(this.getOrden60Report());
        generator.generateOrden64Report(this.getOrden64Report());
    }
}