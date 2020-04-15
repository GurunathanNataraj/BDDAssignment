package StepDefinitions;

//Sorting Numbers using bubble sort technique
public class SortingNumbers {
public static void main(String[] args) {
	
	double arr[]=new double[args.length];
	double temp;
	int flag=0;
	while(flag<args.length)
	{
		arr[flag]=Double.parseDouble(args[flag]);
		flag++;
	}
	
	for(int i=0;i<arr.length-1;i++)
	{
		for(int j=i+1;j<arr.length;j++)
		{
			if(arr[i]>arr[j])
			{
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
	}
	
	for(int i=0;i<arr.length;i++)
	{
		System.out.print(arr[i]+" ");
	}
}
}
