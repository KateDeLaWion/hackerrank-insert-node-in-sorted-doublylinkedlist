public class Solution {


        // https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists

        //    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

        // my code starts from here
        DoublyLinkedListNode nodeInsert = new DoublyLinkedListNode(data);

        // if the list is empty
        if (head == null) {
            return nodeInsert;
        }

        DoublyLinkedListNode current = head;
        while (current != null) {

            // if data is < the head
            if (data < current.data && current.prev == null) {
                current.prev = nodeInsert;
                nodeInsert.next = current;
                return nodeInsert;
            }

            // if data > all existing nodes, traverse to the last existing node
            if (data >= current.data && current.next == null) {
                current.next = nodeInsert;
                nodeInsert.prev = current;
                break; // break out of while loop, not just if statement, return head
            }

            // if data > the first node but data < the last node
            if (data >= current.data && data <= current.next.data) {
                DoublyLinkedListNode temp = current.next;
                current.next = nodeInsert;
                nodeInsert.prev = current;
                temp.prev = nodeInsert;
                nodeInsert.next = temp;
                break; // break out of while loop, not just if statement, return head
            }
            current = current.next;

        } // end of while loop scope
        return head; // when break is used from the above, return head
        // my code ends here


//    } // end of function   static DoublyLinkedListNode sortedInsert()

    }  // end of public class Solution


