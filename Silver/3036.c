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
	int n;
	
	scanf("%d", &n);
	
	int* ring;
	int* b;
	int* c;
	ring = (int*)malloc(sizeof(int)*n);
	b = (int*)malloc(sizeof(int)*n);
	c = (int*)malloc(sizeof(int)*n);
	int i;
	for(i=0; i<n; i++){
		scanf("%d", &ring[i]);
	}
	int temp = 0;
	for(i=1; i<n; i++){
		temp = euclidean(ring[0],ring[i]);
		b[i] = ring[0]/temp;
		c[i] = ring[i]/temp;
	}
	for(i=1; i<n; i++){
		printf("%d/%d\n", b[i], c[i]);
	}
	free(ring);
	free(b);
	free(c);
	return 0;
}
