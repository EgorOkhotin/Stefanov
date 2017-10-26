public class Main {

    public static void main(String[] args) {
        int length = 10000;
        int[] a = new int[length];
        for(int i=0; i<length; i++)
        {
            a[i] = (int)(Math.random()*1000);
        }
        long start = System.currentTimeMillis();
        qsort(a,0,length-1);
        long finish = System.currentTimeMillis();
        System.out.print("Done! "+ (finish-start));
    }

    public static void qsort(int[] arr, int a,int b)
    {
        int i=a,
                r = b,
                p = arr[(i+r)/2];
        while(i<=r)
        {
            while(arr[i]< p) i++;
            while(arr[r]>p) r--;
            if(i<=r)
            {
                int c = arr[i];
                arr[i] = arr[r];
                arr[r] = c;
                i++; r--;
            }
        }

        if(a<r) qsort(arr,a,r);
        if(b>i) qsort(arr,i,b);
    }

}
