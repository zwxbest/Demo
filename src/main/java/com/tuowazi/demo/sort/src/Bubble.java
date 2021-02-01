package com.tuowazi.demo.sort.src;

/**
 * User:zhangweixiao
 * Description:
 */
public class Bubble{

    public static void sort(int[] array)
    {
        int swapcount=0;
        int comparecount=0;
        for(int i=0;i<array.length-1;i++)
            for(int j=i;j<array.length-1;j++)
            {

                if(array[j]>array[j+1])
                {
                    System.out.println(String.format("pos %d value %d exchange with pos %d value %d ",j+1,array[j],j+2,array[j+1]));
                    int temp = array[j];
                    array[j] =array[j+1] ;
                    array[j+1] = temp;
                    swapcount++;
                }
                comparecount++;
            }

        System.out.println("swap "+swapcount+" times");
        System.out.println("compare"+comparecount+"times");
        for(int i:array)
        {
            System.out.print(i+">>");
        }
    }

}
