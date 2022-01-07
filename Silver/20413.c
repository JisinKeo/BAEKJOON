#include <stdio.h>

int sum = 0;
int sum2 = 0;
int s, g, p, d;
void uiui(char A);

int main(){
	int N;

	int i;

	scanf("%d", &N);
	
	scanf("%d %d %d %d", &s, &g, &p, &d);
	
	char A[N];
	
	scanf("%s", A);

	for(i=0; i<N; i++){

		uiui(A[i]);
	}

	printf("%d", sum);
	
	return 0;
}

void uiui(char A){
	
		if(A=='B'){
			sum = sum + ((s-1)-sum2);
			sum2 = ((s-1)-sum2);
		}
		else if(A=='S'){		
			sum = sum + ((g-1)-sum2);	
			sum2 = ((g-1)-sum2);	
		}
		else if(A=='G'){
			sum = sum + ((p-1)-sum2);
			sum2 = ((p-1)-sum2);
		}
		else if(A=='P'){
			sum = sum + ((d-1)-sum2);
			sum2 = ((d-1)-sum2);
		}
		else if(A=='D'){
			sum = sum + d;
		}		
								
}
