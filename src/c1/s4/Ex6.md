1.4.6 给出下列代码的运行时间增长数量级

```java
int sum = 0;
for (int n = N; n > 0; n /= 2)
   for (int i = 0; i < n; i++) 
      sum++;
```

N (N + N/2 + N/4 + ...) 

```java
int sum = 0;
for (int i = 1; i < N; i *= 2)
    for(int j = 0; j < i; j++)
        sum++;
```
N (1 + 2 + 4 + 8 + ...)

```java
int sum = 0;
for (int i = 1; i < N; i *= 2)
    for (int j = 0; j < N; j++)
        sum++
```
NlogN (the outer loop loops lg N times).