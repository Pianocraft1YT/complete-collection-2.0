import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class items_copper_golem {
    public static ArrayList<String> poses = new ArrayList<>();

    public static ArrayList<String> findItem(File s)  throws java.io.FileNotFoundException, java.util.NoSuchElementException{
        
        Scanner sc = new Scanner(s);
        String count = "";
        String pose = "";
        ArrayList<String> output = new ArrayList<>();
        while (sc.hasNextLine()){
            String item = sc.nextLine();
            int index = item.indexOf("\"items\": \"minecraft:");
            if (sc.hasNextLine()){
                count = sc.nextLine();
            }
            if (sc.hasNextLine()){
                sc.nextLine();
            }
            if (sc.hasNextLine()){
                sc.nextLine();
            }
            if (sc.hasNextLine()){
                pose = sc.nextLine();
            }

            if (index >= 0 && count.contains("\"count\": 64") && item.contains("copper_golem")){
                output.add(item.substring(index+20,item.length()));
                poses.add(pose);
            }
    }
        
        sc.close();
        return output;
    }
    public static void main(String[] args) throws java.io.FileNotFoundException, java.util.NoSuchElementException{
        
    ArrayList<String> toChange = findItem(new File("C:\\Users\\lucca\\Downloads\\ProgramFiles\\complete-collection-2.0\\BAC Torture Edition 1-8-7\\data\\blackbirds_torture_chamber\\advancement\\stuff\\a_complete_collection.json"));
    ArrayList<String> finals = new ArrayList<>();
    for (String i : toChange){
        if (!(i.contains("tropical_fish_bucket") || i.contains("potion") || i.contains("goat_horn") || i.contains("ominous_bottle"))){
            if (i.endsWith("\""))
               i = i.substring(0, i.length()-1);
            if (i.endsWith("\","))
                i = i.substring(0, i.length()-2);
            finals.add(i);
        }
            
    }
    System.out.println(finals);
    finals.add("waxed_copper_golem_statue");
    System.out.println(poses);
    poses.removeLast();
    poses.removeLast();
    poses.removeLast();
    for (int i = 0; i < finals.size(); i++){
        for (String pose: poses){
            System.out.println("\"" + finals.get(i) + "_" + pose.substring(pose.indexOf(":")+2, pose.length()-1) + "\": {");
            System.out.println("\"trigger\": \"minecraft:inventory_changed\",");
            System.out.println("\"conditions\": {");
            System.out.println("\"items\": [");
            System.out.println("{");
            System.out.println("\"items\": \"minecraft:shulker_box\",");
            System.out.println("\"components\": {");
            System.out.println("\"minecraft:container\": [");
                for (int j = 0; j < 26; j++){
                    //{"slot":0,"item":{"id":"minecraft:copper_golem_statue","count":64,"components":{"minecraft:block_state":{"copper_golem_pose":"standing"}}}},
                    System.out.println("{\"slot\": " + j + ", \"item\": {\"id\": \"minecraft:" + finals.get(i) + "\", \"count\": 64, \"components\":{\"minecraft:block_state\":{"+ pose + "}}}},");
                }
            System.out.println("{\"slot\": " + 26 + ", \"item\": {\"id\": \"minecraft:" + finals.get(i) + "\", \"count\": 64, \"components\":{\"minecraft:block_state\":{" + pose + "}}}}");
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