import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadCSV {
    //ArrayList to store each of the parsed row from the csv file
    List<Person> result = new ArrayList<Person>();
    public void readPersonInfo() throws IOException {
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
                // Break line into entries using comma
                String[] items = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                try {
                    if (items.length>12)
                        throw new ArrayIndexOutOfBoundsException();
                    // Convert data to person record
                    Person person = new Person();
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
                } catch (ArrayIndexOutOfBoundsException|NumberFormatException|NullPointerException e) {
                    // Caught errors indicate a problem with data format -> Print warning and continue
                    //System.out.println(e.printStackTrace());
                    System.out.println("Invalid line: "+ line);
                }
            }
//            int count = 1;
//            for(int i=0;i<result.size();i++) {
//                System.out.println(count);
//                System.out.print(result.get(i).getFirst_name() + ",");
//                System.out.print(result.get(i).getLast_name() + ",");
//                System.out.print(result.get(i).getCompany() + ",");
//                System.out.print(result.get(i).getEmail() + ",");
//                System.out.print(result.get(i).getAddress1() + ",");
//                System.out.print(result.get(i).getAddress2() + ",");
//                System.out.print(result.get(i).getZip() + ",");
//                System.out.print(result.get(i).getCity() + ",");
//                System.out.print(result.get(i).getState_long() + ",");
//                System.out.print(result.get(i).getState() + ",");
//                System.out.print(result.get(i).getPhone() + ",");
//                count++;
//                System.out.println();
//            }
        } finally {
            br.close();
        }


    }


}
