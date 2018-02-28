/**
 * User:zhangweixiao
 * Description:
 */
public class QuickSort {

    public static void Sort(int[] array)
    {

        QSort(array,0,array.length-1);
    }
    public static void QSort(int[] array,int low,int high)
    {
        int pivot;
        if(low<high)
        {
            pivot=Partition(array,low,high);
            QSort(array,low,pivot-1);
            QSort(array,pivot+1,high);
        }

    }

    public static int Partition(int[] array,int low,int high)
    {
        int pivotkey;
        //median of three
        int m=(low+high)/2;
        if(array[low]>array[high])
            swap(array,low,high);
        if(array[low]<array[m])
        swap(array,low,m);

        pivotkey=array[low];

        int temp=pivotkey;

        while (low<high)
        {
            while (low<high&&array[high]>=pivotkey)
                high--;
            array[low]=array[high];
            while (low<high&&array[low]<=pivotkey)
                low++;
            array[high]=array[low];
        }
        array[low]=temp;
        return low;
    }
    public static void swap(int[] array,int i,int j)
    {
        array[i]=(array[i]+array[j])-(array[j]=array[i]);

    }

}
