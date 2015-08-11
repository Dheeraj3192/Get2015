package JoinArray;

public class JoinArray 
{
	public static void main(String args[])
	{
		JoinArray joinArray=new JoinArray();
		int a[]={2,3,5,7,11,34,67};
		int b[]={1,6,8,19,21,33,77};
		int c[]=joinArray.join(a,b);
		for(index=0;index<c.length;index++)
			System.out.println(c[index]);
	
	}
	int[] join(int a[] , int b[] )
	{
		int asize=a.length;
		int bsize=b.length;
		int c[]=new int[asize+bsize];
		int aIndex=0,bIndex=0,cIndex=0;
		while(aIndex<asize&&bIndex<bsize)
		{
			if(a[aIndex]<=b[bIndex])
			{
				c[cIndex]=a[aIndex];
				aIndex++;
			}
			else
			{
				c[cIndex]=b[bIndex];
				bIndex++;
				
			}
			cIndex++;
			
		}
		while(aIndex<asize)
		{
			c[cIndex++]=a[aIndex++];
		}
		while(bIndex<bsize)
		{
			c[cIndex++]=b[bIndex++];
		}
		return c;
	}

}
