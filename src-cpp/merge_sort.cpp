#include <stdio.h>
#include <stdlib.h>
#include<time.h>
#define max 100000

int a[max];
int b[max];

void merging(int low, int mid, int high) 
{
   int l1, l2, i;

   for(l1 = low, l2 = mid + 1, i = low; l1 <= mid && l2 <= high; i++) {
      if(a[l1] <= a[l2])
         b[i] = a[l1++];
      else
         b[i] = a[l2++];
   }
   
   while(l1 <= mid)    
      b[i++] = a[l1++];

   while(l2 <= high)   
      b[i++] = a[l2++];

   for(i = low; i <= high; i++)
      a[i] = b[i];
}

void sort(int low, int high) {
   int mid;
   
   if(low < high) {
      mid = (low + high) / 2;
      sort(low, mid);
      sort(mid+1, high);
      merging(low, mid, high);
   } else { 
      return;
   }   
}

int main() { 
   int i;

   for(i = 0; i < max; i++)
      a[i]=(rand()%100)+1;
  
 double time_spent=0.0;
 clock_t begin=clock();
 
   sort(0, max);
   
   clock_t end=clock();
 time_spent=(double)(end-begin)/CLOCKS_PER_SEC;
  printf("%d", CLOCKS_PER_SEC);
  printf("\nTime spent:%ld", time_spent);
return 0;
}

