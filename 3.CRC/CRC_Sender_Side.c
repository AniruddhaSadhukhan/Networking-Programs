//Program to implement Cyclic Redundancy Check (sender side)
//		by Aniruddha

#include<stdio.h>

int main()
{
	int mlen,glen,i,j,z,start;
	
	printf("Message length : ");	scanf("%d",&mlen);
	printf("Generator length : ");	scanf("%d",&glen);
	
	int msg[mlen+glen-1], gen[glen], rem[mlen+glen-1],out[mlen+glen-1];
	
	printf("Message : ");
	for(i=0;i<mlen;i++) scanf("%d",&msg[i]);
	
	printf("Generator : ");
	for(i=0;i<glen;i++) scanf("%d",&gen[i]);
	
	for(i=0;i<mlen+glen-1;i++)
	{
		if(i>=mlen) msg[i] = 0;	
		rem[i] = msg[i];
	}
		
	for(z=0;z<mlen+glen-1;z++)
		printf("%d",msg[z]);printf("\n");
		
	for(i=0;i<mlen;i++)
	{
		if (!rem[i]) continue;
		
		for (j=0;j<glen;j++)
			rem[i+j] ^= gen[j];
		
		{ //Display
			for(z=0;z<i;z++) printf(" ");
			for(z=0;z<glen;z++) printf("%d",gen[z]);printf("\n");
			for(z=0;z<mlen+glen-1;z++)
				printf("-");printf("\n");
			start = 0;
			for(z=0;z<mlen+glen-1;z++)
				if(!start && !rem[z]) printf(" ");
				else start=1,printf("%d",rem[z]);printf("\n");
		}
	}
	
	printf("CRC : ");
	for(i=0;i<glen-1;i++) 
		printf("%d",rem[mlen+i]);printf("\n");
		
	for(i=0;i<mlen+glen-1;i++)
		out[i] = msg[i] + rem[i];

	printf("Transmitted message : ");
	for(i=0;i<mlen+glen-1;i++)	
		printf("%d",out[i]);printf("\n");
	
	return 0;
}

/*Output:
Message length : 10
Generator length : 5
Message : 1 1 0 1 0 1 1 0 1 1
Generator : 1 0 0 1 1
11010110110000
10011
--------------
 1001110110000
 10011
--------------
      10110000
      10011
--------------
        101000
        10011
--------------
          1110
CRC : 1110
Transmitted message : 11010110111110

*/

