import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        String[] splitted = string.split(" ");

        for (String s : splitted) {
            arr.add(Integer.parseInt(s));
        }

        BinarySearch search = new BinarySearch(arr);
        System.out.println(search.getIndex(scanner.nextInt()));
    }
}

class BinarySearch {

    ArrayList<Integer> arrayList;
    int index;

    BinarySearch(ArrayList<Integer> sortedArray) {
        arrayList = sortedArray;
    }

    public int search(int left, int right, int x) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (arrayList.get(mid) == x)
                return mid;

            if (arrayList.get(mid) > x)
                return search( left, mid - 1, x);

            return search(mid + 1, right, x);
        }

        return -1;
    }

    public int getIndex(int x) {
        index = search(0, arrayList.size(), x);
        return index;
    }
}
