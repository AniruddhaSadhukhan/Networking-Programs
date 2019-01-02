//Program for bit unstuffing
//	by Aniruddha

#include<stdio.h>

int main()
{
	int len,i,x=0,z=0,count=0;
	
	printf("Message length 	:"); 	scanf("%d",&len);
	
	int msg[len],out[len];
	
	printf("Message		:"); 	
	for(i=0;i<len;i++)	scanf("%d",&msg[i]);
	
	while(z<len)
	{
		if(msg[z]) count++;
		else count = 0;
		out[x++]=msg[z++];
		if(count==5)
			z++;
		
	}
	
	printf("After bit unstuffing : ");
	for(i=0;i<x;i++) printf("%d",out[i]);
}

/*
Message length 	:21
Message		:1 0 1 1 1 1 1 0 1 1 1 0 1 0 1 1 1 1 1 0 1
After bit unstuffing : 1011111111010111111
*/
