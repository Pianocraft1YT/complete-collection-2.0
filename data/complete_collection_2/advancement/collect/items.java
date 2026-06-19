import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class items {
    
    public static ArrayList<String> findItem(File s)  throws java.io.FileNotFoundException, java.util.NoSuchElementException{
        
        Scanner sc = new Scanner(s);
        String count = "";
        ArrayList<String> output = new ArrayList<>();
        while (sc.hasNextLine()){
            String item = sc.nextLine();
            int index = item.indexOf("\"items\": \"minecraft:");
            if (index >= 0){
                count = sc.nextLine();
            }
            if (index >= 0 && count.contains("16")){
                output.add(item.substring(index+20,item.length()));
            }
    }
        sc.close();
        return output;
    }
    public static void main(String[] args) throws java.io.FileNotFoundException, java.util.NoSuchElementException{
       
        
    ArrayList<String> toChange = findItem(new File("C:\\Users\\lucca\\Downloads\\ProgramFiles\\complete-collection-2.0\\BAC Torture Edition 1-8-7\\data\\blackbirds_torture_chamber\\advancement\\stuff\\a_complete_collection.json"));
    ArrayList<String> finals = new ArrayList<>();
    for (String i : toChange){
        if (!(i.contains("tropical_fish_bucket") || i.contains("potion") || i.contains("goat_horn") || i.contains("ominous_bottle") || i.contains("copper_golem_statue"))){
            if (i.endsWith("\""))
               i = i.substring(0, i.length()-1);
            if (i.endsWith("\","))
                i = i.substring(0, i.length()-2);
            finals.add(i);
        }
            
    }
    System.out.println(finals);
    for (int i = 0; i < finals.size(); i++){
            System.out.println("\"" + finals.get(i) + "\": {");
            System.out.println("\"trigger\": \"minecraft:inventory_changed\",");
            System.out.println("\"conditions\": {");
            System.out.println("\"items\": [");
            System.out.println("{");
            System.out.println("\"items\": \"minecraft:shulker_box\",");
            System.out.println("\"components\": {");
            System.out.println("\"minecraft:container\": [");
            for (int j = 0; j < 26; j++){
                System.out.println("{\"slot\": " + j + ", \"item\": {\"id\": \"minecraft:" + finals.get(i) + "\", \"count\": 16}},");
            }
            System.out.println("{\"slot\": " + 26 + ", \"item\": {\"id\": \"minecraft:" + finals.get(i) + "\", \"count\": 16}}");
            System.out.println("]");
            System.out.println("}");
            System.out.println("}");
            System.out.println("]");
            System.out.println("}");
            System.out.println("},");
    }
}
}
