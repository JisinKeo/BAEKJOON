#include<stdio.h>
#include<stdlib.h>

int main(){
	int n;
	
	scanf("%d", &n);
	
	int* score;
	int* submit;
	int* last;
	score = (int*)malloc(sizeof(int)*n);
	submit = (int*)malloc(sizeof(int)*n);
	last = (int*)malloc(sizeof(int)*n);
	
	int i;
	
	for(i=0; i<n; i++){
		scanf("%d %d %d", &score[i], &submit[i], &last[i]);
	}
	
	int max = 0;
	int result;
	for(i=0; i<n; i++){
		if(score[i]>max){
			result = i;
			max = score[i];
		}
		else if(score[i]==max){
			if(submit[result]>submit[i]){
				result = i;
			}
			else if(submit[result]<submit[i]){
				continue;
			}
			else{
				if(last[i]>last[result]){
					continue;
				}
				else if(last[i]<last[result]){
					result = i;
				}
			}
		}
	}
	free(score);
	free(submit);
	free(last);
	printf("%d", result+1);
	
	return 0;
	
}
