import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class items_bees {
    public static ArrayList<String> amplifier = new ArrayList<>();
    public static ArrayList<String> findItem(File s)  throws java.io.FileNotFoundException, java.util.NoSuchElementException{
        
        Scanner sc = new Scanner(s);
        String count = "";
        ArrayList<String> output = new ArrayList<>();
        while (sc.hasNextLine()){
            String item = sc.nextLine();
            int index = item.indexOf("\"items\": \"minecraft:");
            if (index >= 0){
            if (sc.hasNextLine()){
                count = sc.nextLine();
            }
            if (sc.hasNextLine()){
                sc.nextLine();
            }
            if (sc.hasNextLine()){
                String text = sc.nextLine();
                if (text.contains("block_state") && item.contains("bee")){
                    amplifier.add(sc.nextLine());
                }
            }
        }
            if (index >= 0 && count.contains("\"count\": 64") && (item.contains("bee_") || item.contains("beehive"))){
                output.add(item.substring(index+20,item.length()));
        }
    }
        sc.close();
        return output;
    }
    public static void main(String[] args) throws java.io.FileNotFoundException, java.util.NoSuchElementException{
        ArrayList<String> items = new ArrayList<>();
        items.add("obsidian");
        
    ArrayList<String> toChange = findItem(new File("C:\\Users\\lucca\\Downloads\\complete-collection-2.0\\BAC Torture Edition 1-9\\data\\blackbirds_torture_chamber\\advancement\\stuff\\a_complete_collection.json"));
    ArrayList<String> finals = new ArrayList<>();
    for (String i : toChange){
        if (!(i.contains("tropical_fish_bucket") || i.contains("potion") || i.contains("goat_horn") || i.contains("copper_golem_statue"))){
            if (i.endsWith("\""))
               i = i.substring(0, i.length()-1);
            if (i.endsWith("\","))
                i = i.substring(0, i.length()-2);
            finals.add(i);
        }
            
    }
    System.out.println(finals);
    System.out.println(items_ominous_bottle.amplifier);
    finals = new ArrayList<>();
    finals.add("bee_nest");
    finals.add("beehive");
        System.out.println(finals);

    int count = 1;
        for (int i = 0; i < 2; i++){

    for (String amp : amplifier){
            //int incrementedValue = Integer.parseInt(amp.substring(45, amp.length())) + 1;
            //String finalString = String.valueOf(incrementedValue);
            String finalString = "honey_" + count;
            System.out.println("\"" + finals.get(i) + "_" + finalString + "\": {");
            System.out.println("\"trigger\": \"minecraft:inventory_changed\",");
            System.out.println("\"conditions\": {");
            System.out.println("\"items\": [");
            System.out.println("{");
            System.out.println("\"items\": \"#minecraft:shulker_boxes\",");
            System.out.println("\"components\": {");
            System.out.println("\"minecraft:container\": [");
            for (int j = 0; j < 26; j++){
                System.out.println("{\"slot\": " + j + ", \"item\": {\"id\": \"minecraft:" + finals.get(i) + "\", \"count\": 64, \"components\":{ \"minecraft:block_state\": {" + amp + "}}}},");
            }
                System.out.println("{\"slot\": 26, \"item\": {\"id\": \"minecraft:" + finals.get(i) + "\", \"count\": 64, \"components\":{ \"minecraft:block_state\": {" + amp + "}}}}");
            System.out.println("]");
            System.out.println("}");
            System.out.println("}");
            System.out.println("]");
            System.out.println("}");
            System.out.println("},");
            count++;

            if (count == 6)
                count = 1;
    }
    
}
}
}