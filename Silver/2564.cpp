#include<iostream>
#define min(a, b) (((a) <= (b)) ? (a) : (b))
using namespace std;

int main(){
	int n, m, k;
	cin >> n >> m;
	cin >> k;
	int i;
	int store_pt[100];
	int store_dt[100];
	for(i=0; i<k; i++){
		cin >> store_pt[i] >> store_dt[i];
	}
	int person_pt;
	int person_dt;
	int person_dt_ten;
	int sum = 0;
	cin >> person_pt >> person_dt;
	if(person_pt==1){	
		for(i=0; i<k; i++){
			if(store_pt[i]==1){
				if(store_dt[i]>=person_dt){
					sum += (store_dt[i]-person_dt);
				}
				else{
					sum += (person_dt-store_dt[i]);
				}
			}
			else if(store_pt[i]==2){
				sum += m;
				int cache = store_dt[i] + person_dt;
				cache = min(cache, (n-store_dt[i]) + (n-person_dt));
				sum += cache;
			}
			else if(store_pt[i]==3){
				sum += store_dt[i];
				sum += person_dt;
			}
			else if(store_pt[i]==4){
				sum += store_dt[i];
				sum += (n-person_dt);
			}
		}	
	}
	else if(person_pt==2){
		for(i=0; i<k; i++){
			if(store_pt[i]==1){
				sum += m;
				int cache = store_dt[i] + person_dt;
				cache = min(cache, (n-store_dt[i]) + (n-person_dt));
				sum += cache;
			}
			else if(store_pt[i]==2){
				if(store_dt[i]>=person_dt){
					sum += (store_dt[i]-person_dt);
				}
				else{
					sum += (person_dt-store_dt[i]);
				}
			}
			else if(store_pt[i]==3){
				sum += (m-store_dt[i]);
				sum += person_dt;
			}
			else if(store_pt[i]==4){
				sum += (m-store_dt[i]);
				sum += (n-person_dt);
			}
		}
	}
	else if(person_pt==3){
		for(i=0; i<k; i++){
			if(store_pt[i]==1){
				sum += store_dt[i];
				sum += person_dt;
			}
			else if(store_pt[i]==2){
				sum += store_dt[i];
				sum += (m-person_dt);
			}
			else if(store_pt[i]==3){
				if(store_dt[i]>=person_dt){
					sum += (store_dt[i]-person_dt);
				}
				else{
					sum += (person_dt-store_dt[i]);
				}				
			}
			else if(store_pt[i]==4){
				sum += n;
				int cache = store_dt[i] + person_dt;
				cache = min(cache, (m-store_dt[i]) + (m-person_dt));
				sum += cache;
			}
		}
	}
	else if(person_pt==4){
		for(i=0; i<k; i++){
			if(store_pt[i]==1){
				sum += (n-store_dt[i]);
				sum += person_dt;
			}
			else if(store_pt[i]==2){
				sum += (n-store_dt[i]);
				sum += (m-person_dt);
			}
			else if(store_pt[i]==3){
				sum += n;
				int cache = store_dt[i] + person_dt;
				cache = min(cache, (m-store_dt[i]) + (m-person_dt));
				sum += cache;			
			}
			else if(store_pt[i]==4){

				if(store_dt[i]>=person_dt){
					sum += (store_dt[i]-person_dt);
				}
				else{
					sum += (person_dt-store_dt[i]);
				}						
			}
		}
	}		
	cout << sum;
	return 0;
	
}
