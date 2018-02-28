public class Main {

    public static void main(String[] args) {

        serach_case(new int[]{1,3,4,7,9},-1);
        serach_case(new int[]{1,3,4,7,9},10);
        serach_case(new int[]{1,3,4,7,9},3);
        serach_case(new int[]{1,3,4,7,9},1);
        serach_case(new int[]{1,3,4,7,9},9);
        serach_case(new int[]{1,3,4,7,9},5);
    }

    public static void serach_case(int[] array,int key)
    {
        int result = binarySearch(array, key);
        if (result == -1)
            System.out.println("Key "+key+" is not found");
        else
            System.out.println("Key "+key+" is at postion " + (result + 1));
    }


    public static int binarySearch(int[] array, int key) {
        int lowindex = 0;
        int highIndex = array.length - 1;
        int midIndex = (lowindex + highIndex) / 2;
        if (key < array[lowindex] || key > array[highIndex])
            return -1;
//        System.out.println(String.format("midIndex is %d,lowIndex is %d,highIndex is %d,array[midIndex] is %d", midIndex, lowindex, highIndex, array[midIndex]));
        while (midIndex >= lowindex && midIndex <= highIndex) {
            if (key == array[midIndex]) {
                return midIndex;
            } else if (key < array[midIndex]) {
                highIndex = midIndex - 1;
            } else if (key > array[midIndex]) {
                lowindex = midIndex + 1;
            }
            midIndex = (lowindex + highIndex) / 2;
//            System.out.println(String.format("midIndex is %d,lowIndex is %d,highIndex is %d,array[midIndex] is %d", midIndex, lowindex, highIndex, array[midIndex]));
        }
        return -1;
    }
}
