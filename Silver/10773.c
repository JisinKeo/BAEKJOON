#include <stdio.h>
#include <stdlib.h>

int main(){
	int n;
	
	scanf("%d", &n);
	
	int* input;
	
	input = (int*)malloc(sizeof(int)*n);
	
	int i;
	
	for(i=0; i<n; i++){
		scanf("%d", &input[i]);
	}
	
	int sum = 0;
	int count = 0;
	for(i=0; i<n; i++){
		if(input[i] != 0){
			count = 0;
			sum += input[i];
		}
		else if(input[i] == 0){
			int j = i-1;
			while(1){
				if(input[j] != 0){
					sum -= input[j];
					input[j] = 0;
					break;
				}
				j--;
			}
		}			
	}
	
	printf("%d", sum);
	free(input);
	return 0;
}
