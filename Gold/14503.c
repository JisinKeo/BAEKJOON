#include <stdio.h>
	
int road[50][50] = {0,};
	
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};

int main(){

	int n, m;
	scanf("%d %d", &n, &m);
	int r, c, d;
	scanf("%d %d %d", &r, &c, &d);
	
	int i, j;
	
	for(i=0; i<n; i++){
		for(j=0; j<m; j++){
			scanf("%d", &road[i][j]);
		}
	}
	

	
	while(1){
		
		if(road[r][c]==0){		
			road[r][c] = 2;
		}
		
		if(road[r-1][c] !=0 && road[r][c-1] !=0 && road[r][c+1] !=0 && road[r+1][c]!=0){
			if(road[r-dx[d]][c-dy[d]] == 1){
				break;
			}
			else{
				r -= dx[d];
				c -= dy[d];
			}
		}
		
		else{
			d = (d+3) % 4;

			if(road[r+dx[d]][c+dy[d]] == 0){
				r = r + dx[d];
				c = c + dy[d];
			}
		}
	}
	int sum = 0;
	for(i=0; i<n; i++){
		for(j=0; j<m; j++){
			if(road[i][j]==2)
				sum++;
		}
	}
	
	
	printf("%d", sum);
	
	return 0;
}
