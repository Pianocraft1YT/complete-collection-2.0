sc.nextLine();
                sc.nextLine();
                sc.nextLine();
                sc.nextLine();
                String patt = sc.nextLine();
                String col = sc.nextLine();
                String pat_col = sc.nextLine();
                if (patt.contains("potion"))
                    patterns.add(patt);
                if (index >= 0 && item.contains("potion")){
                output.add(item.substring(index+20,item.length()));