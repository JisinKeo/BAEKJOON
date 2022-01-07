#include <stdio.h>
#include <stdlib.h>
int euclidean(int a, int b) {
	int r1 = a, r2 = b, r;
	while (r2) {
		r = r1 % r2;
		r1 = r2;
		r2 = r;
	}
	return r1;
}

int main(){
	int t;
	
	scanf("%d", &t);
	
	int* a;
	int* b;
	int* result;
	a = (int*)malloc(sizeof(int)*t);
	b = (int*)malloc(sizeof(int)*t);
	result = (int*)malloc(sizeof(int)*t);
	int i;
	for(i=0; i<t; i++){
		scanf("%d %d", &a[i], &b[i]);
		int temp = euclidean(a[i], b[i]);
		result[i] = a[i]*b[i] / temp;
	}
	for(i=0; i<t; i++){
		printf("%d\n", result[i]);
	}
	free(a);
	free(b);
	free(result);
	return 0;
}
