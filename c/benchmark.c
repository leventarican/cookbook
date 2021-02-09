#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/time.h>

int benchmark() {
    int len = (123 - 48) * 10;
    char line[len];
    for (int i = 0; i < 10; i++) {
        for (char c = 48; c < 123; c++) {
            strncat(line, &c, 1);
        }
    }
    printf("%s", line);

    char filename[255];
    for (int i = 0; i < 1000; i++) {
        sprintf(filename, "generated.%03d", i);
        printf("%s\n ", filename);

        FILE *fp = fopen(filename, "w");

        if (fp == NULL) { 
            fprintf(stderr, "\nerror: open file\n"); 
            exit (1); 
        }

        fwrite (&line, sizeof(char[len]), 1, fp); 

        if(fwrite <= 0)  
            printf("error: writing file\n"); 

        fclose(fp);
    }
}

/*
creating 1000 files
time elapsed [ms]: 107.129000
*/
int main(int argc, char const *argv[]) {
    // https://stackoverflow.com/questions/2150291/how-do-i-measure-a-time-interval-in-c
    struct timeval t1, t2;
    double elapsedTime;
    gettimeofday(&t1, NULL);

    benchmark();

    gettimeofday(&t2, NULL);
    elapsedTime = (t2.tv_sec - t1.tv_sec) * 1000.0; // sec to ms
    elapsedTime += (t2.tv_usec - t1.tv_usec) / 1000.0;  // us to ms
    printf("time elapsed [ms]: %f\n", elapsedTime);

    return 0;
}
