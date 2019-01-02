//Program to implement Cyclic Redundancy Check (reciever side)
//		by Aniruddha

#include<stdio.h>

int main()
{
	int mlen,glen,i,j,z,start,correct=1;
	
	printf("Recieved Message length	 : ");	scanf("%d",&mlen);
	printf("Generator length	 : ");	scanf("%d",&glen);
	
	mlen -=(glen-1);
	
	int rmsg[mlen+glen-1], gen[glen], rem[mlen+glen-1],msg[mlen];
	
	printf("Recieved Message : ");
	for(i=0;i<mlen+glen-1;i++) scanf("%d",&rmsg[i]);
	
	printf("Generator : ");
	for(i=0;i<glen;i++) scanf("%d",&gen[i]);
	
	for(i=0;i<mlen;i++)
		msg[i] = rmsg[i];
		
	for(z=0;z<mlen+glen-1;z++)
		printf("%d",rmsg[z]);printf("\n");
		
	for(i=0;i<mlen;i++)
	{
		if (!rmsg[i]) continue;
		
		for (j=0;j<glen;j++)
			rmsg[i+j] ^= gen[j];
		
		{ //Display
			for(z=0;z<i;z++) printf(" ");
			for(z=0;z<glen;z++) printf("%d",gen[z]);printf("\n");
			for(z=0;z<mlen+glen-1;z++)
				printf("-");printf("\n");
			start = 0;
			for(z=0;z<mlen+glen-1;z++)
				if(!start && !rmsg[z]) printf(" ");
				else start=1,printf("%d",rmsg[z]);
			if(!start) printf("\b0");printf("\n");
		}
	}
	
	
	for(i=0;i<glen-1;i++) 
		if (rmsg[mlen+i]) 
		{
			correct=0;
			printf("Error in transmission");
			break;
		}
		
	if (correct)
	{
		printf("Original message : ");
		for(i=0;i<mlen;i++)	
			printf("%d",msg[i]);printf("\n");
	}		
	
	return 0;
}

/*Output:


Recieved Message length	 : 14
Generator length	 : 5
Recieved Message : 1 1 0 1 0 1 1 0 1 1 1 1 1 0
Generator : 1 0 0 1 1
11010110111110
10011
--------------
 1001110111110
 10011
--------------
      10111110
      10011
--------------
        100110
        10011
--------------
             0
Original message : 1101011011


Recieved Message length	 : 14
Generator length	 : 5
Recieved Message : 1 1 0 1 0 1 1 0 1 1 1 0 1 0        
Generator : 1 0 0 1 1
11010110111010
10011
--------------
 1001110111010
 10011
--------------
      10111010
      10011
--------------
        100010
        10011
--------------
           100
Error in transmission




Recieved Message length	 : 14
Generator length	 : 5
Recieved Message : 1 1 0 1 0 1 1 0 1 1 1 0 1 1
Generator : 1 0 0 1 1
11010110111011
10011
--------------
 1001110111011
 10011
--------------
      10111011
      10011
--------------
        100011
        10011
--------------
           101
Error in transmission
*/

