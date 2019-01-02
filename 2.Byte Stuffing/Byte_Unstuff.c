//Program for byte unstuffing
//	by Aniruddha

#include<stdio.h>
#define FLAG '#'
#define ESC '$'

int main()
{
	int len,x=0,z=0;
	
	printf("Enter length of input : ");
	scanf("%d",&len);
	
	char inp[len+1],out[len+1];
	
	printf("Enter input : ");
	scanf("%s",inp);
	
	while(z<len)
	{
		if(inp[z]==ESC)
			z++;
		out[x++] = inp[z++];
	}
	
	out[x] = '\0';
	
	printf("After Byte Unstuffing: %s",out);
}

/*Sample Output:
Enter length of input : 11
Enter input : Wel$#co$$me
After Byte Unstuffing: Wel#co$me
*/
