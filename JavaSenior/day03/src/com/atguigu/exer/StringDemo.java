package com.atguigu.exer;

public class StringDemo {
    public static String reverse(String str,int startIndex, int endIndex){
        char[] arr = str.toCharArray();
        for(int i=startIndex, j= endIndex; i<j;i++,j--){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
//        return arr.toString();
        return new String(arr);
    }

    public static String reverse1(String str,int startIndex, int endIndex){
        String result = str.substring(0,startIndex);
        for(int i = endIndex;i>=startIndex;i--){
            result += str.charAt(i);
        }
        result+= str.substring(endIndex+1);
        return result;
    }
    public static String reverse2(String str,int startIndex, int endIndex){
        StringBuilder builder = new StringBuilder(str.length());
        builder.append(str.substring(0,startIndex));
        for(int i = endIndex;i>=startIndex;i--){
            builder.append(str.charAt(i));
        }
        builder.append(str.substring(endIndex));
        return builder.toString();
    }
    public static void main(String[] args) {
        String x = "abcdefg";
        System.out.println(reverse2(x, 2,5));
    }
}
