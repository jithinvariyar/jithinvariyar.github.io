import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println(printOccurence("aasdvasvadva"));
        System.out.println(printOccurence("sajhags"));
    }

    public static String printOccurence(String s){
        StringBuilder sb = new StringBuilder();
        Set<String> set = new LinkedHashSet<>();
        for(int i=0;i<s.length();i++){
            String sub = s.substring(i,i+1);
            set.add(sub);
        }
        for(String entry: set){
            sb.append(entry);
        }
        return sb.toString();
    }
}
