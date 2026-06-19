import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
public class items_stack_1_fish {
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
            int index = item.indexOf("\"items\": \"minecraft:");
            if (index >= 0){
                sc.nextLine();
                String patt = sc.nextLine();
                String col = sc.nextLine();
                String pat_col = sc.nextLine();
                if (patt.contains("tropical_fish/pattern"))
                    patterns.add(patt);
                if (col.contains("tropical_fish/base_color"))
                    base_colors.add(col);
                if (pat_col.contains("tropical_fish/pattern_color"))
                    pattern_colors.add(pat_col);
            }
            if (index >= 0 && item.contains("tropical_fish_bucket")){
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
        if (!(i.contains("potion") || i.contains("goat_horn") || i.contains("ominous_bottle"))){
            if (i.endsWith("\""))
               i = i.substring(0, i.length()-1);
            if (i.endsWith("\","))
                i = i.substring(0, i.length()-2);
            finals.add(i);
        }
            
    }
    System.out.println(finals);
    
    patterns = new ArrayList<>(new HashSet<>(patterns));
    base_colors = new ArrayList<>(new HashSet<>(base_colors));
    pattern_colors = new ArrayList<>(new HashSet<>(pattern_colors));
System.out.println(patterns);
    System.out.println(base_colors);
    System.out.println(pattern_colors);
    for (int i = 0; i < 1; i++){
        for (String pat: patterns){
            for (String color : base_colors){
                for (String pat_col : pattern_colors){
                    System.out.println("\"" + finals.get(i) + "_" + pat.substring(pat.indexOf("/")+12, pat.length()-2) + "_" + color.substring(color.indexOf("/")+15,color.length()-2) + "_" + pat_col.substring(pat_col.indexOf("/")+18,pat_col.length()-1) + "\": {");
                    System.out.println("\"trigger\": \"minecraft:inventory_changed\",");
                    System.out.println("\"conditions\": {");
                    System.out.println("\"items\": [");
                    System.out.println("{");
                    System.out.println("\"items\": \"minecraft:shulker_box\",");
                    System.out.println("\"components\": {");
                    System.out.println("\"minecraft:container\": [");
                        for (int j = 0; j < 26; j++){
                            //{"slot":0,"item":{"id":"minecraft:copper_golem_statue","count":64,"components":{"minecraft:block_state":{"copper_golem_pat":"standing"}}}},
                            System.out.println("{\"slot\": " + j + ", \"item\": {\"id\": \"minecraft:" + finals.get(i) + "\", \"components\":{"+ pat + color + pat_col + "}}},");
                        }                                                                                                                       
                            System.out.println("{\"slot\": 26" + ", \"item\": {\"id\": \"minecraft:" + finals.get(i) + "\", \"components\":{"+ pat + color + pat_col + "}}}");
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
}
}