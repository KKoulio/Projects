package gr.aueb.cf.projects;

public class SecondMinApp {

    public static void main(String[] args) {
        int[] arr = {0, 3, 7, 12, 2, 50, 1, 60};
        int secondMin;

        secondMin = getSecondMinPosition(arr);
        if (secondMin == -1) System.exit(1);
        System.out.printf("SecMinPos: %d, SecMinValue: %d",secondMin + 1, arr[secondMin]);
    }

    public static int getSecondMinPosition(int[] arr) {
        int min = 0;
        int secondMin = 1;
        int minValue = 0;
        int secondMinValue = 0;

        if (arr == null) return -1;
        if (arr.length < 2) return -1;

        minValue = arr[0];
        secondMinValue = arr[1];

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] < minValue) && (arr[i] < secondMinValue)) {
                secondMin = min;
                secondMinValue = minValue;
                min = i;
                minValue = arr[i];
            } else if ((arr[i] > minValue) && (arr[i] < secondMinValue)) {
                secondMin = i;
                secondMinValue = arr[i];
            }
        }
        return secondMin;
    }
}
