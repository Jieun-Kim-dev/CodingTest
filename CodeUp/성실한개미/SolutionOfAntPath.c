#include <stdio.h>
#include <stdbool.h>

int main() {
    int map[10][10] = {};
    
    for(int row = 0; row < 10; row++) {
        for(int col = 0; col < 10; col++) {
            scanf("%d", &map[row][col]);
        }
    }

    bool done = false;
    int col = 1;
    for(int row = 1; row < 9; row++) {
        bool next = false;
        for(; col < 9; col++){
            if(map[row][col] == 2) {
                map[row][col] = 9;
                done = true;
                break;
            } else if(map[row][col] == 0) {
                map[row][col] = 9;
                
                if(map[row][col+1] == 1) {
                    next = true;
                    break;
                }
            }
        }
        
        if(done) break;
        if(next) continue;
    }
    
    for(int row = 0; row < 10; row++) {
        for(int col = 0; col < 10; col++) {
            printf("%d ", map[row][col]);
        }
        printf("\n");
    }
}
