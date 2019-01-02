//Program to detect and correct codes using Hamming Code
//		by Aniruddha

#include <stdio.h>
int main ()
{
	int len,i,j,k,z,count,error_bit=0;
	
	printf("Message length: ");	scanf("%d",&len);
	
	int msg[len];
	
	printf("Message: ");
	for(i=0;i<len;i++)	scanf("%d",&msg[i]);
	
	for(i=1;i<=len;i*=2)
	{
		count = 0;
		for(j=i;j<=len;j+=i)
		{
			for(z=0;z<i;z++)
			{
				printf("%d(m%d) ",msg[len-j],j);
				count += msg[len-j];
				j++;
				if (j>len) break;
			}
		}
		if (count%2)
		{
			error_bit += i;
			printf(" => Error in P%d\n",i);
		}
		else printf(" => P%d is OK\n",i);
		
		
	}
	
	if(error_bit)
	{
		printf("Error is in bit %d (from right)\n",error_bit);
		msg[len - error_bit] ^= 1;
	}
	printf("Correct Transmitted Message: ");
	for(i=0;i<len;i++)	printf("%d",msg[i]);printf("\n");
	
}

/*Output
Enter message length: 11
Enter message: 1 0 0 1 1 1 0 1 1 0 1
Calculation:
1(m1) 1(m3) 0(m5) 1(m7) 0(m9) 1(m11)  	=> P1 is OK 
0(m2) 1(m3) 1(m6) 1(m7) 0(m10) 1(m11)  	=> P2 is OK 
1(m4) 0(m5) 1(m6) 1(m7)  	=> Error in P4 
1(m8) 0(m9) 0(m10) 1(m11)  	=> P8 is OK 

Error is in 4 bit

Correct message: 10011100101

*/
