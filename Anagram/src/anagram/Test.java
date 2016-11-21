
package anagram;

import anagram.List.LinkedList;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    
    public static void main(String[] args) throws Exception{
        File file = new File("words.txt");
        Scanner fileReader = new Scanner(file);
        String word = "aeprs";
        long t1 = System.currentTimeMillis();
        LinkedList<String> list = new LinkedList<>();
        
        while(fileReader.hasNext()){
            String currentWord = fileReader.nextLine();
            if(sortWord(word).equals(sortWord(currentWord)) && !word.equals(currentWord)){
                list.add(currentWord);
            }
        }
        
        System.out.println(list);
        System.out.println("Time: " + (System.currentTimeMillis() - t1) / 1000.0);
        System.out.println("# of anagrams: " + list.size);
        
    }
    
    public static String sortWord(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
}
