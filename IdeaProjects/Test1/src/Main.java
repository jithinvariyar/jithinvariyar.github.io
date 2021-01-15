import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] arr = {3,9,2,5,6,7};
        int key = 11;
        int[] res = findPair(arr,key);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }

    public static int[] findPair(int[] arr, int k){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i] + arr[i+1] == k){
                list.add(arr[i]);
                list.add(arr[i+1]);
                break;
            }
        }
        int[] result = new int[list.size()];
        result[0] = list.get(0);
        result[1] = list.get(1);
        return result;
    }
}
