package com.self.learn.arithmetic.sort.QuickSort;

/**
 * Created by aaronl on 1/20/2016.
 */
//快速排序
public class QuickSorter {

    public int partition(int[] a, int i, int j) {//分割排序
        int key = a[i];
        while (i < j) {
            while (i < j && a[j] >= key) //找出第一个比key小,并记下j值
                j--;
            a[i] = a[j];//将a[j]移至a[i]处
            while (i < j && a[i] <= key)//找出第一个比key大,并记下i值
                i++;
            a[j] = a[i];//将a[i]移至a[j]处
        }
        a[i] = key;//此时完成一趟排序
        return i;//此时i=j,记下i的值
    }

    public void sort(int[] a, int i, int j) {//递归调用分割
        if (i < j) {
            int n = partition(a, i, j);//排一次序列,并获取关键值的位置
            sort(a, i, n - 1);//左递归
            sort(a, n + 1, j);//右递归
        }
    }

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27};
        new QuickSorter().sort(a, 0, 6);
        for (int item : a) {
            System.out.println(item);
        }
    }
}
