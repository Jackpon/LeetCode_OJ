/*
729. My Calendar I

Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.

Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.

A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)

For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.

Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
Example 1:
MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(15, 25); // returns false
MyCalendar.book(20, 30); // returns true
Explanation: 
The first event can be booked.  The second can't because time 15 is already booked by another event.
The third event can be booked, as the first event takes every time less than 20, but not including 20.
*/
// Time Limit Exceeded
class MyCalendar {
    ArrayList<Integer> list;
	public MyCalendar() {
       list = new ArrayList<>(); 
    }
	    
    public boolean book(int start, int end) {
        boolean status =false;
    	for (int i = start; i < end; i++) 
			if(list.contains(i))
				status = true;
    	for (int i = start; i < end && !status; i++) {
			list.add(i);
		}
		if(status)
			return false;
        return true;
    }
}

//第二种思路是打算用长度为2的数组来限定范围，然后不断更新，但没有考虑到不只只有一段，fail
class MyCalendar {
   	int []a;
	public MyCalendar() {
       a = new int[2]; 
    }
	    
    public boolean book(int start, int end) {
        if (a[0]==0 && a[1]==0) {
			a[0]=start;
			a[1]=end;
			return true;
		}
    	if (start>=a[1]) {
			a[1]=end;
			return true;
		}
        if (end<=a[0]) {
        	a[0]=start;
			return true;
		}
			return false;
    }
}

/*
还是回归到原先的思路，只需改变list类型为数组类型
遍历list，判断（start，end）是否在已有的小数组里
*/
class MyCalendar {
	ArrayList<Integer[]> list;
	public MyCalendar() {
       list = new ArrayList<>(); 
    }
	    
    public boolean book(int start, int end) {
        for(Integer[] x:list) {
        	if(x[0]<end && start<x[1])
        		return false;
        }
        list.add(new Integer[] {start,end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */