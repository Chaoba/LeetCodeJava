from ListNode import ListNode

class TestUtil:
    def creatList(self, s):
        head=None
        node=None
        for sub in s:
            if head is None:
                head=ListNode(sub)
                node=head
            else:
                node.next=ListNode(sub)
                node=node.next
        return head

    def printList(self,head):
        s=""
        while head is not None:
            s=s+"%s"%head.val
            head=head.next
        return s