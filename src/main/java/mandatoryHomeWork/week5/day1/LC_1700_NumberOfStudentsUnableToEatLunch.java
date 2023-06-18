package week5.day1;

import java.util.*;
import java.util.List;
import queueImplementation.Queue;
import queueImplementation.Queue.Node;
import queueImplementation.*;

import org.junit.Test;

public class LC_1700_NumberOfStudentsUnableToEatLunch{

	@Test
	public void positive() {
		int[] st = {1,1,0,0};
		int[] sa = {0,1,0,1};	
		
	System.out.println(studentsCount(st,sa));
	System.out.println("*********");
	System.out.println(studentsCountusingQueue(st,sa));
	System.out.println("Next case");
	}
	
	@Test
	public void negative() {
		int[] st = {1,1,1,0,0,1};
		int[] sa = {1,0,0,0,1,1};
		System.out.println(studentsCount(st,sa));
		System.out.println("*********");
		System.out.println(studentsCountusingQueue(st,sa));
		System.out.println("Next case");
	}
	
	@Test
	public void edge() {
		int[] st = {1};
		int[] sa = {0};	
		System.out.println(studentsCount(st,sa));
		System.out.println("*********");
		System.out.println(studentsCountusingQueue(st,sa));
		System.out.println("Next case");
	}
	
	@Test
	public void edge1() {
		int[] st = {};
		int[] sa = {};	
		System.out.println(studentsCount(st,sa));
		System.out.println("*********");
		System.out.println(studentsCountusingQueue(st,sa));
		System.out.println("Next case");
	}
	
	/*
	 * convert the given array into list
	 * use 2 pointer left and right
	 * loop till left pointer is less than student list
	 * use counter to check when no of mismatch is equal to the no of students
	 * --> If yes return the size of students
	 * --> else if left value == right value remove left and right value
	 * --> else remove the 1st value and add it in the last index
	 */
	//Time Complexity --> O(n)
	//Space Complexity --> O(n)
	private int studentsCount(int[] st, int[] sa) {
		
		int left=0;
		int right=0;
		int count=0;
		int temp;
		
		List<Integer> stList = new ArrayList<Integer>();
		for (int i : st) {
			stList.add(i);
		}
		//System.out.println(stList);
		List<Integer> saList = new ArrayList<Integer>();
		for (int j : sa) {
			saList.add(j);
		}
		//System.out.println(stList.get(0));
		//System.out.println(saList.get(0));
		while(left<stList.size()) {
			
			if(count==stList.size()) {
				return stList.size();
			}
			
			else if(stList.get(left)==saList.get(right)) {
				stList.remove(left);
				saList.remove(right);
				count=0;
			}
			else {
				temp=stList.get(left);
				stList.remove(left);
				stList.add(temp);
				count++;
			}
			
		}
		return 0;
		
	}
	
	/*
	 * Add the student values in queue 
	 * loop till head node !=tail node
	 * if student[i]==sandwich[j] 
	 * --> if yes, remove the head element by assigning head as head.next and remove the sandwich element
	 * els if student[i]!=sandwich[j]
	 * --> if yes, increment the counter and add head node to tail
	 */
	public int studentsCountusingQueue(int[] student, int[] sandwich) {
		Queue queue=new Queue();
		//Add the student values in queue
		for(int i: student) {
		queue.enqueue(i);
		}
		//System.out.println(queue.size);
		//assign starting queue point as head
		//assign end queue point as tail
		Node head = queue.start;
		Node tail = queue.end;
		int j=0;
		int count=0;
		Node temp;
		while(head !=tail ) {
			if(count==queue.size()) {
				return count;
			}
			//if yes, remove the head element by assigning head as head.next and remove the sandwich element
			else if(head.number==sandwich[j]) {
				head=head.next;
				count=0;
				j++;
			}
			else {
				count++;
				temp=head;
				head=head.next;
				tail.next=temp;
				tail=temp;
			}
		}
		
		return 0;
		
		
	}
}
