package com.nacht.sn_0021;

import com.nacht.util.ListNode;

/**
 * @author Nacht
 * Created on 2024/8/31 09:44
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode current;
        if (list1.val < list2.val){
            current = list1;
            list1 = list1.next;
            current.next = null;
        }else{
            current = list2;
            list2 = list2.next;
            current.next = null;
        }
        ListNode result = current;
        while (list1 != null || list2 != null){
            if (list1 == null || (list2 != null && list1.val >= list2.val)){
                current.next = list2;
                list2 = list2.next;
                current = current.next;
                continue;
            }
            current.next = list1;
            list1 = list1.next;
            current = current.next;

        }

        return result;
    }
}
