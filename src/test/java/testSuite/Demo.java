package testSuite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;

public class Demo {
	
//	private String name;
//	String myName;
//	
//	public String getName() {
//		return myName;
//	}
//	
//	public void setName(String name) {
//		myName=name;
//	}
//	
//	
//	public static void main(String[] args) {
//		Demo d=new Demo();
//		d.setName("Mahi");
//		System.out.println(d.getName());
//	}
	
//	public static void main(String[] args) {
//		        int arr[]=new int[]{2,6,1,7,4,9,3,8};
//		        List<Integer> dig=new ArrayList<Integer>();
//		        for(int i=arr.length-1;i>0;i--){
//		            System.out.println(arr[i]);
//		            dig.add(arr[i]);
//		        }
//		        System.out.println(dig);
//		    }
	
	public static void main(String[] args) {
//		String s="Madam";
//		char[] c=s.toCharArray();
//		String rev="";
//		for(int i=c.length-1;i>=0;i--) {
//			rev=rev+c[i];
//			//rev=rev.concat(""+c[i]);
//		}
//		System.out.println(rev);
//		if(s.equalsIgnoreCase(rev)) {
//			System.out.println("Its palindrome");
//		}
//		else
//			System.out.println("Not a palindrome");
//	}
		//removingLeadingZeros();
		//firstLetterintoString();
		//leadingZeros();
		//Int();
		//findDuplicates();
		//dup();
		removeSpace();
		
	}
		
		public static void removingLeadingZeros() {
			String str="0001234500";
			
			for(int i=0;i<str.length()-1;i++) {
				if(str.startsWith("0")) {
					str=str.substring(1);
				}
				else 
					break;
			}
			
			System.out.println(str);
		}
		
		public static void firstLetterintoString() {
			String result="";
			String str="Hello World! This is a test string.";
			String[] words=str.split("\\s");
			System.out.println(words.length);
			for(int i=0;i<words.length;i++) {
				 System.out.println(words[i].charAt(0));
				 result=result+words[i].charAt(0);
			}
			System.out.println(result);
		}
		
		public static void leadingZeros() {
			String input="Hello World! This is a test string.";
			String[]words=input.split("\\s");
			int len=words.length;
			String reverse="";
			for(int i=0;i<=len-1;i++) {
				reverse=reverse+words[i].charAt(0);
			}
			System.out.println(reverse);
		}
		
		public static void Int() {
			String i="19";
			Integer.parseInt(i);
			
			int io=90;
			String.valueOf(io);
			
			
		}
		
		public static void findDuplicates() {
			int[] array = {1, 2, 3, 4, 5, 2, 3, 6, 7, 8, 1,3,3,3};
			
			HashSet<Integer> set = new HashSet<>();
	        System.out.println("Duplicate elements in the array:");
	        
	        for (Integer element : array) {
				if(!set.add(element)) {
					System.out.println(element);
				}
			}
		}
		
		public static void dup() {
			int[] arr = { 1, 4, 3, 3, 4, 1, 7, 4, 4, 4, 8, 9 };
			int count = 1;
			int n = arr.length;
			Arrays.sort(arr);
			HashSet<Integer> withoutDup = new HashSet<>();

			for (int i = 1; i < n; i++) {
				if (arr[i] == arr[i - 1]) {
					count++;
				} else {
					if (count > 1) {
						System.out.println(arr[i - 1] + " " + count);
						count = 1;
					}
				}
			}
			if (count > 1) {
				System.out.println("***" + arr[n - 1] + " " + count);
			}

			for (Integer integer : arr) {
				withoutDup.add(integer);
			}
			System.out.println("####" + withoutDup);
			
		}
		
		public static void removeSpace() {
			String str="Race";
	        String str1="Care";
	        
	        String reqStr1=str.toLowerCase();
	        String reqStr2=str1.toLowerCase();
	        
	        if(reqStr1.length()==reqStr2.length()){
	            char[] arr1=reqStr1.toCharArray();
	            char[] arr2=reqStr2.toCharArray();
	            
	            Arrays.sort(arr1);
	            Arrays.sort(arr2);
	            
	           boolean result= Arrays.equals(arr1,arr2);
	           
	           if(result){
	               System.out.println("Anagram");
	           }
	           else
	            System.out.println("Not Anagram");
	        }

			}
}
