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

    public HashMap<Person, ArrayList<Person>> duplicateORNot() {
        //Sort the ArrayList by First_Name
        Collections.sort(result, new SortByColumn());
        
        //HashMap to store person as key and its potential duplicates as value
        HashMap<Person, ArrayList<Person>> map = new HashMap<Person, ArrayList<Person>>();
        
        //Run through each person object in array list 
        for(Person p: result){
            //check if they are already present in the array list, if so put them in the value of that key(person)
            if(map.containsKey(p)){
                ArrayList<Person> list= map.get(p);
                list.add(p);
                map.put(p,list);
            }
            //if they are not present, put them in the map with an empty array list as value
            else{
                //System.out.println("here");
                map.put(p,new ArrayList<Person>());
            }
        }        
        
    //        System.out.println("Potential Duplicates");
    //        for (Map.Entry<Person,ArrayList<Person>> entry : map.entrySet()){
    //            if(entry.getValue().size() > 0 ) {
    //                System.out.println(entry.getKey().getFirst_name());
    //            }            
    //        }
                
        return map;
    }

    static int min(int x,int y,int z)
    {
        if (x<=y && x<=z) return x;
        if (y<=x && y<=z) return y;
        else return z;
    }

    //Leveraged Levenshtein distance
    public static int editDist(String str1 , String str2 , int m ,int n)
    {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0) return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0) return m;

        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if (str1.charAt(m-1) == str2.charAt(n-1))
            return editDist(str1, str2, m-1, n-1);

        // If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        return 1 + min ( editDist(str1,  str2, m, n-1),    // Insert
                editDist(str1,  str2, m-1, n),   // Remove
                editDist(str1,  str2, m-1, n-1) // Replace
        );
    }
}
