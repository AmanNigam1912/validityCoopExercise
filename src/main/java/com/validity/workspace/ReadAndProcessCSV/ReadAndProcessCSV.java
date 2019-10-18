package com.validity.workspace.ReadAndProcessCSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.validity.workspace.pojo.Person;

public class ReadAndProcessCSV {
	//ArrayList to store each of the parsed row from the csv file
    List<Person> result = new ArrayList<Person>();
    public void readPersonInfo() throws IOException {
        //Read the csv file from the specified path
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\\\normal.csv")));
        try {
            // Read first line
            String line = br.readLine();
            // Make sure file has correct headers
            if (line==null) {
                throw new IllegalArgumentException("File is empty");
            }
            // Run through following lines
            while ((line = br.readLine()) != null) {
                // Break line into entries using comma and special cases taken care here through regex
                String[] items = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                try {
                    if (items.length>12)
                        throw new ArrayIndexOutOfBoundsException();
                    // Convert data to person record
                    Person person = new Person();
                    person.setId(Integer.parseInt(items[0]));
                    person.setFirst_name(items[1] );
                    person.setLast_name(items[2] );
                    person.setCompany(items[3].replace("\"",""));
                    person.setEmail(items[4]);
                    person.setAddress1(items[5]);
                    person.setAddress2(items[6]);
                    person.setZip(items[7]);
                    person.setCity(items[8]);
                    person.setState_long(items[9]);
                    person.setState(items[10]);
                    person.setPhone(items[11]);
                    result.add(person);
                } catch (ArrayIndexOutOfBoundsException ea) {
                    // Caught errors indicate a problem with data format -> Print warning and continue
                    //System.out.println(e.printStackTrace());
                    System.out.println("Invalid line: "+ line);
                }
                catch (NumberFormatException en) {
                	System.out.println("Invalid line: "+ line);
                }
                catch (NullPointerException e) {
                	System.out.println("Invalid line: "+ line);
                }
            }
//            int count = 1;
//            for(int i=0;i<result.size();i++) {
//                System.out.println(count);
//                System.out.print(result.get(i).getFirst_name() + ",");
//                count++;
//                System.out.println();
//            }
        } finally {
            br.close();
        }

    }

    
}
