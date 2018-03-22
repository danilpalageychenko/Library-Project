package ua.org.oa._dani4_.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by _dani on 31.03.2016.
 */
public class ReadCsv {
    public static List<String[]> read(String csvFile) {
        List<String[]> arrayCsv = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                arrayCsv.add(line.split(";"));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayCsv;
    }

}
