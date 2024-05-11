package collection;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(); // Create a new LinkedList instance
        linkedList.add(2);   // Add elements to the linked list
        linkedList.add(20);
        linkedList.add(15);
        linkedList.add(36);
        linkedList.addFirst(80);       // Correctly call addFirst on the instance 'linkedList'
        linkedList.addLast(67);
//        System.out.println(linkedList);     // Print the linked list

//        System.out.println(linkedList.getFirst()); // get the first element;
//        System.out.println(linkedList.indexOf(15));

        linkedList.offerFirst(45);
//        System.out.println(linkedList);
        linkedList.offerLast(92);
        System.out.println(linkedList);

        System.out.println(linkedList.peek());
        System.out.println(linkedList);

        // remove elements from the linkedList
        linkedList.pop();
        System.out.println(linkedList); // [80, 2, 20, 15, 36, 67, 92]

        // pop() 和 push() 是一組對應的方法
        // add element into the first element of linkedList
        linkedList.push(100);
        System.out.println(linkedList); // [100, 80, 2, 20, 15, 36, 67, 92]

        // 數組的長度是length屬性，沒有小括號
        // 集合的大小是size（）方法，有小括號
    }
}

