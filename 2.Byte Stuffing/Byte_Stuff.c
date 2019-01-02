//Program for byte stuffing
//	by Aniruddha

#include<stdio.h>
#define FLAG '#'
#define ESC '$'

int main()
{
	int len,x=0,z=0;
	
	printf("Enter length of input : ");
	scanf("%d",&len);
	
	char inp[len+1],out[2*len+1];
	
	printf("Enter input : ");
	scanf("%s",inp);
	
	while(z<len)
	{
		if(inp[z]==FLAG || inp[z]==ESC)
			out[x++] = ESC;
		out[x++] = inp[z++];
	}
	
	out[x] = '\0';
	
	printf("After Byte Stuffing: %s",out);
}

/*Sample Output:
Enter length of input : 9
Enter input : Wel#co$me
After Byte Stuffing: Wel$#co$$me

*/
