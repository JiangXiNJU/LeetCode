package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;
import static javafx.scene.input.KeyCode.L;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 Example:

 Input:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 Output: 1->1->2->3->4->4->5->6

 Approach 4: Merge lists one by one

 Algorithm

 Convert merge \text{k}k lists problem to merge 2 lists (\text{k-1}k-1) times. Here is the merge 2 lists problem page.

 Complexity Analysis

 Time complexity : O(kN)O(kN) where \text{k}k is the number of linked lists.

 We can merge two sorted linked list in O(n)O(n) time where nn is the total number of nodes in two lists.
 Sum up the merge process and we can get: O(\sum_{i=1}^{k-1} (i*(\frac{N}{k}) + \frac{N}{k})) = O(kN)O(∑
 ​i=1
 ​k−1
 ​​ (i∗(
 ​k
 ​
 ​N
 ​​ )+
 ​k
 ​
 ​N
 ​​ ))=O(kN).
 Space complexity : O(1)O(1)

 We can merge two sorted linked list in O(1)O(1) space.

 Approach 5: Merge with Divide And Conquer

 Intuition & Algorithm

 This approach walks alongside the one above but is improved a lot. We don't need to traverse most nodes many times repeatedly

 Pair up \text{k}k lists and merge each pair.

 After the first pairing, \text{k}k lists are merged into k/2k/2 lists with average 2N/k2N/k length, then k/4k/4, k/8k/8 and so on.

 Repeat this procedure until we get the final sorted linked list.

 Thus, we'll traverse almost NN nodes per pairing and merging, and repeat this procedure about \log_{2}{k}log
 ​2
 ​​ k times.
 */
public class Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        if(lists.length==1) return lists[0];
        int numlist=lists.length;
        ListNode[] nodes=new ListNode[numlist];
        int tmp_len=0;
        for(int i=0;i<numlist;i++){
            if(lists[i]!=null){
                nodes[tmp_len++]=lists[i];
            }
        }
        numlist=tmp_len;
        if(numlist==0) return null;
        else if(numlist==1) return nodes[0];
        ListNode head=nodes[0];
        int min=head.val+1;
        int index=0;
        for(int i=0;i<numlist;i++){
            if(nodes[i].val<min){
                min=nodes[i].val;
                index=i;
            }
        }
        head=nodes[index];
        nodes[index]=nodes[index].next;
        if(nodes[index]==null){
            nodes[index]=nodes[numlist-1];
            numlist--;
        }

        ListNode n=head;
        while(numlist>1){
            min=nodes[0].val;
            index=0;
            for(int i=1;i<numlist;i++){
                if(nodes[i].val<min){
                    min=nodes[i].val;
                    index=i;
                }
            }
            n.next=nodes[index];
            n=n.next;
            nodes[index]=nodes[index].next;
            if(nodes[index]==null){
                nodes[index]=nodes[numlist-1];
                numlist--;
            }
        }
        if(numlist==1) n.next=nodes[0];
        return head;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();

    }
}
