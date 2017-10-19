import java.io.File;
import java.security.Key;
import java.util.*;

/**
 * Created by Michael Sipes-Brandt on 10/18/17.
 */
public class CommonPermutations {

    public static void main(String[] args){

        Scanner fin;
        File inputFile;
        Hashtable<String, Integer> permutations;
        try{
            inputFile = new File(args[0]);
            fin = new Scanner(inputFile);


            while(fin.hasNext()){
                String s1 = fin.nextLine();
                String s2;
                permutations = new Hashtable();
                int i;
                if(fin.hasNext()){
                    s2 = fin.nextLine();
                    boolean s1IsLonger = false;
                    if(s1.length() >= s2.length()){
                        i = s1.length();
                        s1IsLonger = true;
                    } else{
                        i = s2.length();
                        s1IsLonger = false;
                    }
                    for(int j = 0; j < i; j++){
                        //If the first line is longer than the second
                        if(s1IsLonger){
                            if(s2.contains(s1.charAt(j) + "")){
                                //If the hash table contains the key already increment by 1
                                if(permutations.containsKey(s1.charAt(j) + "")) {
                                    permutations.put(s1.charAt(j) + "", permutations.get(s1.charAt(j) + "") + 1);
                                }
                                //If the hash table does not contain the key add it
                                else
                                    permutations.put(s1.charAt(j) + "", 1);
                            }
                        }
                        //If the second line is longer than the first
                        else{
                            if(s1.contains(s2.charAt(j) + "")){
                                //If the hash table contains the key increment by 1
                                if(permutations.containsKey(s2.charAt(j) + "")) {
                                    permutations.put(s2.charAt(j) + "", permutations.get(s2.charAt(j) + "") + 1);
                                }
                                //If the hash table does not contain the key add it
                                else
                                    permutations.put(s2.charAt(j) + "", 1);
                            }
                        }
                    }
                    List<Map.Entry> list = new ArrayList<Map.Entry>(permutations.entrySet());
                    Collections.sort(list, new Comparator<Map.Entry>() {
                        public int compare(Map.Entry e1, Map.Entry e2) {
                            Integer i1 = (Integer) e1.getValue();
                            Integer i2 = (Integer) e2.getValue();
                            if(i1.equals(i2)){
                                String s = (String)e1.getKey();
                                String s2 = (String)e2.getKey();
                                return s.compareTo(s2);
                            }
                            return i2.compareTo(i1);
                        }
                    });
                    for(Map.Entry e : list) {
                        System.out.print(e.getKey());
                    }
                    if(fin.hasNext()){
                        System.out.println();
                    }
                    permutations = new Hashtable<>();
                } else{
                    break;
                }
            }


        }catch (Exception e){

        }




    }


}
