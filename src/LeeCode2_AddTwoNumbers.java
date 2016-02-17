/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * @author kesar
 *
 */
public class LeeCode2_AddTwoNumbers
{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
        if(l1==null)
		{
			return l2;
		}
		if(l2==null)
		{
			return l1;
		}
		ListNode one=l1;
		ListNode two=l2;
		int carry=0;
		while(one!=null||carry!=0)
		{
		    one.val+=carry;
		    carry=0;
		    if(two!=null)
		    {
		        one.val+=two.val;
		        two=two.next;
		    }
		    if(one.val>9)
		    {
		        one.val-=10;
		        carry=1;
		    }

		    if(one.next==null)
		    {
                if(two==null)
                {
                    if(carry!=0)
                    {
                        one.next=new ListNode(carry);
                    }
                    return l1;
                }
                else
                {
                    one.next=two;
                    two=null;
                    one=one.next;                 
                }
		    }
		    else
		    {
		        one=one.next;
		    }
		}
		
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
	}

}

class ListNode
{
	int val;
	ListNode next;

	ListNode(int x)
	{
		val = x;
	}
}
