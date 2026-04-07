public class Main {
    public static void main(String[] args) throws StaticArrayException {
        StaticArray<Integer> sa = new StaticArray<>();
        for (int i = 0; i < sa.length(); i++) {
            sa.set(i, i + 1);
        }

        String[] fruits = {"apple", "banana", "kumquat"};
        StaticArray<String> sa2 = new StaticArray<>();
        for (int i = 0; i < 3; i++) {
            sa2.append(fruits[i]);
        }

        System.out.println(sa);
        System.out.println(sa2);
    }

}