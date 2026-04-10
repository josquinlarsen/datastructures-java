package linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            ll.insertFront(i);
        }
        System.out.print("size: " +ll.size()+" ");
        System.out.println(ll);

        // LinkedList<Integer> ll2 = new LinkedList<>();
        // for (int i = 0; i < 10; i++) {
        //     ll2.insertBack(i);
        // }
        // System.out.print("size: " +ll2.size()+" ");
        // System.out.println(ll2);
        
        for (int i = 0; i < 7; i+= 2) {
            try {
                ll.insert(i, 27);
                System.out.println(ll);
            } catch (LinkedListException e) {
                System.out.println("error: "+ e.getMessage());
            }
        }
    }
}
