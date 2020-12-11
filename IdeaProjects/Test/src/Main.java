import java.util.*;

public class Main {

    public static int[] resArray;
    public static int pos = 0;
    public static Set<Integer> numbersSet = new LinkedHashSet<>();
    public static void main(String[] args){
        int arr[] = {6,5,4,4,6,5,2,1,4};
        int n = 1;
        for(int i : arr){
            numbersSet.add(i);
        }
        resArray = new int[n];
        int finalArr[] = findTopNos(arr,n);
        if(finalArr == null){
            System.out.println("Enter a Valid number(n)");
        } else{
            for(int i: finalArr){
                System.out.println(i);
            }
        }

    }

    public static int[] findTopNos(int arr[], int n){
        int lengthOfArray = arr.length;
        Arrays.sort(arr);
        int maxCount = 1;
        int res = arr[0];
        List<Integer> arrList = new ArrayList<>();
        int[] updatedArray;
        int currentCount = 1;
        if(n>numbersSet.size() || n==0){
            return  null;
        }
        for(int i = 1 ; i < lengthOfArray ; i++){
            if(arr[i] == arr[i-1]){
                currentCount++;
            } else{
                if(currentCount > maxCount){
                    maxCount = currentCount;
                    res = arr[i-1];
                }
                currentCount = 1;
            }
        }

        if(currentCount > maxCount){
            maxCount = currentCount;
            res = arr[lengthOfArray-1];
        }
        resArray[pos++] = res;
        for(int i = 0 ; i < lengthOfArray ; i++){
            if(arr[i] != res){
                arrList.add(arr[i]);
            }
        }
        int index = 0;
        updatedArray = new int[arrList.size()];
        for(int elemnt: arrList){
            updatedArray[index++] = elemnt;
        }
        n--;
        if(n>0) {
            return findTopNos(updatedArray, n);
        }

        return resArray;
    }
}
