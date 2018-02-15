import java.util.Arrays;

public class QuickMerge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] test1 = { "banana","apple", "cherry", "mahogany","zorro", "oreos", "pinata"};
		String[]  mergeResult=mergeSort(test1);
		long start = System.nanoTime();
		long end = System.nanoTime();
		long time = end - start;
		System.out.println("Merge Took :" + time + "nanoseconds");
		System.out.println(Arrays.toString(mergeResult));
	}
	public static String[] mergeSort(String[] list1)
	{
		//base case
		if(list1.length==1) {
			return list1;
		}
		
		//recursive
		String [] left = Arrays.copyOfRange(list1, 0, list1.length/2);
		String [] right = Arrays.copyOfRange(list1, list1.length/2, list1.length);
		return(merge(mergeSort(left),mergeSort(right)));
	}
	
	/*public static void quickSort(int[]list1,int front,int back)
	{
		if(back>front) {
			int pivotPos=partition(list1,front,back);
		//left side
		quickSort(list1,front,pivotPos-1);
		//right side
		quickSort(list1,pivotPos+1,back);
		}
	}
	*/
	public static String[] merge(String[]list1,String[]list2)
	{
		
		String empty[] = new String[list1.length + list2.length];
		int i=0;
		int li=0;
		int ri=0;
		while((li<list1.length)&&(ri<list2.length))
		{
			if(list1[li].compareTo(list2[ri])>0)
			{
				empty[i]=list2[ri];
				ri++;
				i++;
			}
			else if(list1[li].compareTo(list2[ri])<0) 
			{
				empty[i]=list1[li];
				li++;
				i++;
			}
		}
		while(li<list1.length)
		{
			empty[i]=list1[li];
			li++;
			i++;
			
		}
		while(ri<list2.length)
		{
			empty[i]=list2[ri];
			ri++;
			i++;
		}
		return empty;
}

}
