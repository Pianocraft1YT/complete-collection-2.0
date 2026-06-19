import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
public class items_stack_1_potions {
    public static List<String> patterns = new ArrayList<>();
    public static List<String> base_colors = new ArrayList<>();
        public static List<String> pattern_colors = new ArrayList<>();

    public static ArrayList<String> findItem(File s)  throws java.io.FileNotFoundException, java.util.NoSuchElementException{
        
        Scanner sc = new Scanner(s);
        String count = "";
        String pat = "";
        ArrayList<String> output = new ArrayList<>();
        while (sc.hasNextLine()){
            String item = sc.nextLine();
            int index = item.indexOf("},");
            if (index >= 0){
                item = sc.nextLine();
                if (item.contains("potion")){
                    sc.nextLine();
                sc.nextLine();
                sc.nextLine();
                sc.nextLine();
                item = sc.nextLine();
                sc.nextLine();
                String patt = sc.nextLine();
                if (patt.contains("potion"))
                    patterns.add(patt);
                if (index >= 0 && item.contains("potion")){
                    output.add(item);
                }
                
            }
            
            }
    }
        
        sc.close();
        return output;
    }
    public static void main(String[] args) throws java.io.FileNotFoundException, java.util.NoSuchElementException{
        
    ArrayList<String> toChange = findItem(new File("C:\\Users\\lucca\\Downloads\\ProgramFiles\\complete-collection-2.0\\BAC Torture Edition 1-8-7\\data\\blackbirds_torture_chamber\\advancement\\stuff\\a_complete_collection.json"));
    ArrayList<String> finals = new ArrayList<>();
    for (String i : toChange){
        if (!(i.contains("goat_horn") || i.contains("ominous_bottle"))){
            if (i.endsWith("\""))
               i = i.substring(0, i.length()-1);
            if (i.endsWith("\","))
                i = i.substring(0, i.length()-2);
            finals.add(i);
        }
            
    }
    System.out.println(finals);
    finals = new ArrayList<>(new HashSet<>(finals));

    patterns = new ArrayList<>(new HashSet<>(patterns));
    base_colors = new ArrayList<>(new HashSet<>(base_colors));
    pattern_colors = new ArrayList<>(new HashSet<>(pattern_colors));
    System.out.println(patterns);
    System.out.println(base_colors);
    System.out.println(pattern_colors);
    for (int i = 0; i < finals.size(); i++){
        for (String pat: patterns){
                    System.out.println("\""+ finals.get(i).substring(26,finals.get(i).length()) + "_"+ pat.substring(37, pat.length()-1) + "\":{");
                    System.out.println("\"trigger\": \"minecraft:inventory_changed\",");
                    System.out.println("\"conditions\": {");
                    System.out.println("\"items\": [");
                    System.out.println("{");
                    System.out.println("\"items\": \"minecraft:shulker_box\",");
                    System.out.println("\"components\": {");
                    System.out.println("\"minecraft:container\": [");
                                                String temp = finals.get(i).substring(15);

                        for (int j = 0; j < 26; j++){
                            //{"slot":0,"item":{"id":"minecraft:copper_golem_statue","count":64,"components":{"minecraft:block_state":{"copper_golem_pat":"standing"}}}},
                            System.out.println("{\"slot\": " + j + ", \"item\":{\"id\":"+ temp + "\", \"components\":{"+ pat  + "}}},");
                        }                                                                                                                       
                            System.out.println("{\"slot\": 26" + ", \"item\":{\"id\":" + temp +"\", \"components\":{"+ pat + "}}}");
                    System.out.println("]");
                    System.out.println("}");
                    System.out.println("}");
                    System.out.println("]");
                    System.out.println("}");
                    System.out.println("},");
                }
            }
            
    }
}
