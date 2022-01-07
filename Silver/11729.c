#include<stdio.h>
#include<stdlib.h>

int win(int a,int b){
	if(b==0)
		return 1;
	else if(b==1)
		return a;
	else
		return win(a,b-1)*a;
	
}


void move(int first, int third){
	printf("%d %d\n", first, third);

}

void hanoi(int n, int first, int to , int third){
	if(n==1)
		move(first,third);
	else {
		hanoi(n-1,first,third,to);
		move(first,third);
		hanoi(n-1,to,first,third);
	}
}

int main(){
	int n;
	
	scanf("%d", &n);
	printf("%d\n", win(2,n)-1);
	
	hanoi(n,1,2,3);
	
	return 0;
}
