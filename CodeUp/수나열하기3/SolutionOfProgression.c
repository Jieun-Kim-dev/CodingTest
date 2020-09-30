#include <stdio.h>

int main() {
    long a; int m, d, n;
    scanf("%ld %d %d %d", &a, &m, &d, &n);
    for(int i=1; i<n; i++) {
        a *= m;
        a += d;
    }
    printf("%ld", a);
}
