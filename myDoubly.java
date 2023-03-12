//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;
public class myDoubly 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); 
        int number;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) 
        { 
            System.out.print("Enter a number: "); 
            number = input.nextInt(); 
            list.add(number);
            
        }
        Node mainHead = Input(list);
        addNodeAfter(mainHead, 5, 12);
        removeNode(mainHead, 1);
        printLinkList(mainHead); 
        printReverse(mainHead);
        
    } 
    public static Node Input(ArrayList<Integer> num)
    {
        if (num == null || num.isEmpty()) {
            return null;
        }
    
        Node head = new Node();
        head.val = num.get(0);
        Node tail = head;
    
        for (int i = 1; i < num.size(); i++) {
            Node newNode = new Node();
            newNode.val = num.get(i);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        return head;
        
    }
    public static void printLinkList(Node head)
    {
        Node current = head;
        while (current != null)
        {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
        
    }
    public static void printReverse(Node head)
    {
        Node current = head;
        while(current.next != null)
        {
            current = current.next;
        }
        while(current != null)
        {
            System.out.print(current.val + " ");
            current = current.prev;
        }
        System.out.println();
    }
    public static Node addNodeAfter(Node head, int value, int newValue)
    {
        Node current = head;
        while (current != null) 
        {
            if (current.val == value)
            {
                Node newNode = new Node();
                newNode.val = newValue;
                newNode.prev = current;
                newNode.next = current.next;

                if (current.next != null)
                {
                    current.next.prev = newNode;
                }
                current.next = newNode;
                return head;
            }
            current = current.next;
        }
        // If val is not found
        Node newNode = new Node();
        newNode.val = newValue;
        if (head == null) 
        {
            return newNode;
        } 
        else
        {
            Node lastNode = head;
            while (lastNode.next != null)
            {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
            newNode.prev = lastNode;
            return head;
        }
    }
    public static Node removeNode(Node head, int value)
    {
        Node current = head;
        while (current != null)
        {
            if (current.val == value) 
            {
            // found the node to remove
                if (current.prev == null) 
                {
                    head = current.next;  
                    head.prev = null; 
                } 
                else 
                {
                    current.prev.next = current.next;
                    if (current.next != null) 
                    {
                        current.next.prev = current.prev;
                    }
                    current.next = null;
                    current.prev = null;
                    return head;
                }
            }
            current = current.next;
        }
        return head;
    }
}
