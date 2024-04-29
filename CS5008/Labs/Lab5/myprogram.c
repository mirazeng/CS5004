// gcc myprogram.c -o myprogram
// ./myprogram

// Take a look at some of the previous examples to create your own program!
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

int main() {

    // Create an array of strings to store the arguments for the ls command
    char* ls_argv[] = {"/bin/ls", "-la", NULL};

    // Create an array of strings to store the arguments for the echo command
    char* echo_argv[] = {"/bin/echo", "testing", NULL};

    // Create an array of strings to store the arguments for the whoami command
    char* whoami_argv[] = {"/usr/bin/whoami", NULL, NULL};

    // Create an array of strings to store the arguments for the pwd command
    char* pwd_argv[] = {"/bin/pwd", NULL, NULL};

    // Create variables to store the process IDs of the child processes
    pid_t pid_ls, pid_echo, pid_whoami, pid_pwd;

    // Initialize a variable to store the status of the child processes
    int status;

    // Track the process IDs of the child processes

    // ls command
    pid_ls = fork();
    if (pid_ls == 0) {
        // Execute the ls command in the child process
        execve(ls_argv[0], ls_argv, NULL);
        perror("ls command failed");
        exit(EXIT_FAILURE);
    } else {
        // Wait for the ls command to complete in the parent process
        waitpid(pid_ls, &status, 0);
        if (WIFEXITED(status)) {
            printf("ls command passed\n");
        }
    }

    // echo command
    pid_echo = fork();
    if (pid_echo == 0) {
        // Execute the echo command in the child process
        execve(echo_argv[0], echo_argv, NULL);
        perror("echo command failed");
        exit(EXIT_FAILURE);
    } else {
        waitpid(pid_echo, &status, 0);
        // Wait for the echo command to complete in the parent process
        if (WIFEXITED(status)) {
            printf("echo command passed\n");
        }
    }

    // whoami command
    pid_whoami = fork();
    if (pid_whoami == 0) {
        // Execute the whoami command in the child process
        execve(whoami_argv[0], whoami_argv, NULL);
        perror("whoami command failed");
        exit(EXIT_FAILURE);
    } else {
        waitpid(pid_whoami, &status, 0);
        // Wait for the whoami command to complete in the parent process
        if (WIFEXITED(status)) {
            printf("whoami command passed\n");
        }
    }

    // pwd command
    pid_pwd = fork();
    if (pid_pwd == 0) {
        // Execute the pwd command in the child process
        execve(pwd_argv[0], pwd_argv, NULL);
        perror("pwd command failed");
        exit(EXIT_FAILURE);
    } else {
        // Wait for the pwd command to complete in the parent process
        waitpid(pid_pwd, &status, 0);
        if (WIFEXITED(status)) {
            printf("pwd command passed\n");
        }
    }

    return 0;
}
