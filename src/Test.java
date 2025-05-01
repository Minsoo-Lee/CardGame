public class Test {
    public static void main(String[] args) {
        int[] i1 = {4, 4, 3, 2, 2};
        int[] i2 = {4, 2, 2, 1, 1};
        int[] i3 = {4, 4, 2, 2, 1};

//        System.out.println("point1 = " + getPoint(i1, 0));
//        System.out.println("point2 = " + getPoint(i1, getPoint(i1, 0) + 1));
//        System.out.println("point3 = " + getPoint(i1, getPoint(i1, getPoint(i1, 0) + 1) + 1));
//        System.out.println();
//
//        System.out.println("point1 = " + getPoint(i2, 0));
//        System.out.println("point2 = " + getPoint(i2, getPoint(i2, 0) + 1));
//        System.out.println("point3 = " + getPoint(i2, getPoint(i2, getPoint(i2, 0) + 1) + 1));
//        System.out.println();

        int[] pointers = new int[3];

        getPoint(i1, pointers, 0, 0);
        for (int i = 0; i < pointers.length; i++) {
            System.out.println(pointers[i]);
        }
        System.out.println();

        getPoint(i2, pointers, 0, 0);
        for (int i = 0; i < pointers.length; i++) {
            System.out.println(pointers[i]);
        }
        System.out.println();

        getPoint(i3, pointers, 0, 0);
        for (int i = 0; i < pointers.length; i++) {
            System.out.println(pointers[i]);
        }

//        System.out.println("point1 = " + getPoint(i3, 0));
//        System.out.println("point2 = " + getPoint(i3, getPoint(i3, 0) + 1));
//        System.out.println("point3 = " + getPoint(i3, getPoint(i3, getPoint(i3, 0) + 1) + 1));
        System.out.println();


    }

    public static void getPoint(int[] cards, int[] pointers, int start, int count) {
        if (count == 3) return ;
        for (int i = start; i < 4; i++) {
            if (cards[i] != cards[i + 1]) {
                pointers[count] = i;
                getPoint(cards, pointers, i + 1, count + 1);
                return ;
            }
        }
        pointers[count] = 4;
        getPoint(cards, pointers, 4, count + 1);
    }
}
