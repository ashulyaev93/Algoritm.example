import org.w3c.dom.ls.LSOutput;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) Math.round((Math.random()*100));
            System.out.print(arr[i]+" ");
        }

        System.out.println(" ");

//        System.out.println("Пузырьковая сортировка");
//        int[]arrSorted = sortBubble(arr);
//        for(int y = 0; y<arr.length; y++){
//            System.out.print(arrSorted[y]+" ");
//        }

//        System.out.println("Сортировка выбором");
//        int[]arrSorted = sortSelect(arr);
//        for(int y = 0; y<arr.length; y++){
//            System.out.print(arrSorted[y]+" ");
//        }

        System.out.println("Сортировка вставкой");
        int[]arrSorted = sortInsert(arr);
        for(int y = 0; y<arr.length; y++){
            System.out.print(arrSorted[y]+" ");
        }

        System.out.println("");

        //Рассчёт времени сортировки
        long startTimeSorted = System.nanoTime();
        long endTimeSorted = System.nanoTime();
        long durationSorted = (endTimeSorted - startTimeSorted);
        System.out.println(durationSorted*0.000000001 + " секунд проходила сортировка");
    }

    //Пузырьковая
    public static int[] sortBubble(int[]arr){
        int out, in;
        int[]arrSorted = arr;
        for (out = arrSorted.length - 1 ; out >= 1 ; out--) {
            for (in = 0 ; in < out; in++) {
                if ( arrSorted[in] > arrSorted[in + 1]) {
                    int tmp = arrSorted[in];
                    arrSorted[in] = arrSorted[in+1];
                    arrSorted[in+1] = tmp;
                }
            }
        }
        return arrSorted;
    }

    //Выбором
    public static int[] sortSelect(int[]arr){
        int out , in , mark;
        int[]arrSorted = arr;
        for ( out = 0 ; out < arrSorted.length; out ++){
            mark = out;
            for ( in = out + 1 ; in < arrSorted.length; in ++){
                if ( arrSorted [in]< arrSorted [mark]){
                    mark = in;
                }
            }
            int tmp = arrSorted[out];
            arrSorted[out] = arrSorted[mark];
            arrSorted[mark] = tmp;
        }
        return arrSorted;
    }

    //Вставкой
    public static int[] sortInsert(int[]arr){
        int in, out;
        int[]arrSorted = arr;
        for ( out = 1 ; out < arrSorted.length ; out ++){
            int temp = arrSorted[out];
            in = out;
            while ( in > 0 && arrSorted[in - 1] >= temp ){
                arrSorted[in] = arrSorted[in - 1];
                -- in;
            }
            arrSorted[in] = temp;
        }
        return arrSorted;
    }
}
