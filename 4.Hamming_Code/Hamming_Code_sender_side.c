//Program to implement using Hamming Code (Sender side)
//		by Aniruddha

#include <stdio.h>
#include<math.h>

int main ()
{
	int olen,p,i,j,z=1,count;
	printf("Original Message length: ");	scanf("%d",&olen);
	
	int omsg[olen];
	
	printf("Message: ");
	for(i=0;i<olen;i++)	scanf("%d",&omsg[i]);
	
	p = 2;
	while(1)
	{
		if(int(pow(2,p))>(olen+p))
			break;
		p++;
	}

	int msg[olen+p],len=olen+p;
	
	for(i=1;i<=len;i*=2)
	{
		msg[len-i] = 0;
		for(j=i+1;j<i*2;j++)
			msg[len-j] = omsg[olen-z],z++;
	}
	for(i=0;i<len;i++)
		printf("%d ",msg[i]);printf("\n");
		
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
		
		printf(" => P%d = %d\n",i,count%2);
		msg[len-i] = count%2;
		
	}	
		
	printf("Transmitted code is: ");
	for(i=0;i<len;i++)
		printf("%d ",msg[i]);
	
	return 0;
}

/*Output 

Original Message length: 7
Message: 1 0 0 1 1 0 1
1 0 0 0 1 1 0 0 1 0 0 
0(m1) 1(m3) 0(m5) 1(m7) 0(m9) 1(m11)  => P1 = 1
0(m2) 1(m3) 1(m6) 1(m7) 0(m10) 1(m11)  => P2 = 0
0(m4) 0(m5) 1(m6) 1(m7)  => P4 = 0
0(m8) 0(m9) 0(m10) 1(m11)  => P8 = 1
Transmitted code is: 1 0 0 1 1 1 0 0 1 0 1 

*/
