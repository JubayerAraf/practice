import java.util.*;

public class main {
    public static void main(String[] args){
        System.out.println(timeConversion("04:05:45AM"));
        System.out.println(countingSort(List.of(34, 95, 34, 64, 45, 95, 16, 80, 80, 75, 3, 25, 75, 25, 31, 3, 64, 16, 31)));
        findZigZagSequence(new int[]{1,3,5,2,6,9,7}, 7);
        System.out.println(gridChallenge(List.of("xbc","dab","fge")));
        System.out.println(superDigit("9875",4));
        System.out.println(Arrays.toString(selectionSort(new int[]{4, 2, 23, 4, 5,12,1,4})));
        System.out.println(Arrays.toString(bubbleSort(new int[]{4, 2, 23, 4, 5,12,1,4})));
        System.out.println(Arrays.toString(insertionSort(new int[]{4, 2, 23, 4, 5,12,1,4})));

    }

    public static String timeConversion(String s) {
        // Write your code here
        String []timeArray = s.split(":");
        if(timeArray[2].contains("PM")){
            return new StringBuilder()
                    .append(timeArray[0].equals("12") ? "12" : Integer.parseInt(timeArray[0])+12)
                    .append(":")
                    .append(timeArray[1])
                    .append(":")
                    .append(timeArray[2].replace("PM",""))
                    .toString();
        }

        return new StringBuilder()
                .append(timeArray[0].equals("12") ? "00" : (Integer.parseInt(timeArray[0])-12)<10 ? "0" + Integer.parseInt(timeArray[0]): (Integer.parseInt(timeArray[0])-12))
                .append(":")
                .append(timeArray[1])
                .append(":")
                .append(timeArray[2].replace("AM",""))
                .toString();
    }


    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        HashMap<Integer,Integer> unique = new HashMap<>();
        for(Integer item:a){
            if(unique.containsKey(item)){
                Integer count = unique.get(item);
                count++;
                unique.put(item, count);
            }else{
                unique.put(item, 1);
            }
        }

        int lonelyInteger = -1;
        for(Map.Entry<Integer, Integer> entry : unique.entrySet()) {
            if(entry.getValue().equals(1)) {
                lonelyInteger = entry.getKey();
            }
        }
        return lonelyInteger;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int result = 0;
        for(int i=0;i<arr.size();i++){
            result+= arr.get(i).get(i) - arr.get(i).get(arr.size()-i-1);
        }
        return Math.abs(result);
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        int maxValue = 0;
        for(Integer item: arr){
            if(item>maxValue){
                maxValue = item;
            }
        }
        Integer[] outputArr = new Integer[maxValue+1];
        Arrays.fill(outputArr, 0);
        for (Integer integer : arr) {
            outputArr[integer]++;
        }
        return Arrays.asList(outputArr);
    }

    public static void findZigZagSequence(int [] a, int n){
        Arrays.sort(a);
        int mid = n/2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 2;
        while(st <= ed){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1;
        }
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static String caesarCipher(String s, int k) {
        // Write your code here
        StringBuilder ciphString = new StringBuilder();
        k=k%26;
        for(char c: s.toCharArray()){
            if(c>='a'&&c<='z'){
                c+=k;
                if(c>'z'){
                    c-=26;
                }
            }
            if(c>='A'&&c<='Z'){
                c+=k;
                if(c>'Z'){
                    c-=26;
                }
            }

            ciphString.append(c);
        }
        return ciphString.toString();
    }
    public static String gridChallenge(List<String> grid) {
        // Write your code here
        char[][] vertical = new char[grid.size()][grid.size()];
        int i=0;
        for(String g:grid){
            vertical[i] = g.toCharArray();
            Arrays.sort(vertical[i]);
            i++;
        }
        for(int x=0;x<grid.size();x++){
            for(int z=1;z<grid.size();z++){
                if (vertical[z-1][x]>vertical[z][x]){
                    return "No";
                }
            }
        }
        return "YES";
    }


    public static int superDigit(String n, int k) {
        // Write your code here
        if(n.length()<=1){
            return Integer.parseInt(n);
        }else {

        }
        long integerSuperDigit = Integer.parseInt(n);
        int sum = 0;
        for(int i=0;i<k;i++){
            sum+= integerSuperDigit%10;
            integerSuperDigit/=10;
        }
        String sumString = String.valueOf(sum);
        return superDigit(sumString, sumString.length());
    }
    public static int[] selectionSort(int[] unsortedArr){
        for (int i=0; i<unsortedArr.length;i++){
            int j = i;
            for (int k = i+1; k<unsortedArr.length;k++){
                if(unsortedArr[j]>unsortedArr[k]){
                    int temp = unsortedArr[j];
                    unsortedArr[j] = unsortedArr[k];
                    unsortedArr[k] = temp;
                }
            }
            System.out.println(i+" step of selection sort : "+Arrays.toString(unsortedArr));
        }
        return unsortedArr;
    }
    public static int[] bubbleSort(int[] unsortedArr){
        for (int i=0; i<unsortedArr.length-1;i++){
            for (int k = 0; k<unsortedArr.length-1;k++){
                if(unsortedArr[k]>unsortedArr[k+1]){
                    int temp = unsortedArr[k];
                    unsortedArr[k] = unsortedArr[k+1];
                    unsortedArr[k+1] = temp;
                }
            }
            System.out.println(i+" step of bubble sort : "+Arrays.toString(unsortedArr));
        }
        return unsortedArr;
    }
    public static int[] insertionSort(int[] unsortedArr){
        for (int i=1;i<unsortedArr.length;i++){
            int key = unsortedArr[i];
            int j = i-1;
            while (j>=0 && key<unsortedArr[j]){
                unsortedArr[j+1]=unsortedArr[j];
                j--;
            }
            unsortedArr[j+1] = key;
            System.out.println(i+" step of insertion sort : "+Arrays.toString(unsortedArr));
        }
        return unsortedArr;
    }
}
