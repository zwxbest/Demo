/**
 * User:zhangweixiao
 * Description:快速排序
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

            //1.三数取中，取出左中右三个数，交换以保证array[low]非max和min，是中间的大小
            int m=(low+high)/2;
            if(array[low]>array[high])
                swap(array,low,high);
            if(array[low]<array[m])
            swap(array,low,m);

        pivotkey=array[low];

        int temp=pivotkey;

        //注意povotKey是一直不变的，不会跟着下标变的。
        //todo：如果把内部的while中的low<high去掉呢
        while (low<high)
        {
            while (low<high&&array[high]>=pivotkey)
                high--;
            array[low]=array[high];//执行这段代码的时间说明已经跳出while循环了，一般是array[high]<pivotkey
            while (low<high&&array[low]<=pivotkey)
                low++;
            array[high]=array[low];
        }
        //到这里已经是low=high了，有因为是赋值，有两个相同的，将pivot还原回去。
        array[low]=temp;
        return low;
    }
    public static void swap(int[] array,int i,int j)
    {
        array[i]=(array[i]+array[j])-(array[j]=array[i]);

    }

}
