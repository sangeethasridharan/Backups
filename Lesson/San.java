class San
{
public static void main(String ar[])
{
int i,j,k,n=4;
System.out.println("Diamond Pattern");
 for(i=0;i<n;i++)
  {
   for(j=i;j<n;j++)
    {
     System.out.print(" ");
    }
   for(k=0;k<=i*2;k++)
    {
     System.out.print("*");
    }
   System.out.println();
   }
int l=5;
for(i=l;i>0;i--)
  {
   for(j=l;j>i;j--)
    {
     System.out.print(" ");
    }
   for(k=i*2-1;k>=1;k--)
    {
     System.out.print("*");
    }
   System.out.println();
   }
}
}