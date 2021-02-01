package com.tuowazi.demo.sort.src;

/**
 * User:zhangweixiao
 * Description:
 */
public class SimpleSelect {
    public static void Sort(int[] array)
    {
        int swapcount=0;
        int comparecount=0;
        for(int i=0;i<array.length;i++)
        {
            int min=array[i];
            int minIndex=i;
            for(int j=i+1;j<array.length;j++)
            {
                if(array[j]<min)
                {
                    min=array[j];
                    minIndex=j;
                }
                comparecount++;
            }
            if(minIndex!=i)
            {
                comparecount++;
                System.out.println(String.format("pos at %d value %d exchange with pos at %d value %d",i+1,array[i],minIndex+1,array[minIndex]));
                array[minIndex] =array[i] ;
                array[i] = min;
                swapcount++;
            }

        }
        System.out.println("swap "+swapcount+" times");
        System.out.println("compare "+comparecount+" times");
        for(int i:array)
        {
            System.out.print(i+">>");
        }
    }
}
