#include <stdlib.h>
#include <ctype.h>
#include "stdio.h"
#include "string.h"

// ======================Test cases:====================
// 1. read a regular with lines
// 2. read an empty file
// 3. read a file that does not exist

// Function to read the number of lines in a file
int read_file_lines(char *filename)
{
    FILE *file;
    int count = 0;
    // create a buffer/placeholder to hold  the line
    // 2048 is for future use
    char line_buffer[2048];

    file = fopen(filename, "r");
    // handle the case where the file does not exist
    if (file == NULL) {
        printf("File not found\n");
        return 0;
    } else {
        // read the file line by line
        while (fgets(line_buffer, sizeof(line_buffer), file) != NULL) {
            count++;
        }
        fclose(file);
        printf("The file named %s has %d lines\n", filename, count);
    }
    return count;
}

// ======================Test cases:====================
// 1. read the first word of each line in a file
// 2. read the first word of each line in a file that does not exist
// 3. read the first word of each line in an empty file
// 4. lines in a file that has no first word, starting with a tab and space
// 5. lines in a file that first word is not a character, for example: starting with a #

// Function to read the first word of each line in a file
int read_first_word(char *filename)
{
    FILE *file;

    // create a buffer/placeholder to hold each line and first word
    char line_buffer[2048];
    char first_word[256];

    file = fopen(filename, "r");
    // handle the case where the file does not exist
    if (file == NULL) {
        printf("File not found\n");
        return 0;
    } else {
        while (fgets(line_buffer, sizeof(line_buffer), file) != NULL) {
            // read the first word from each line
            if (sscanf(line_buffer, "%s", first_word) == 1) {
                printf("%s\n", first_word);
                } else {
                printf("\n");
            }
        }
        fclose(file);
    }
    return 1;
}

// ======================Test cases:====================
// 1. count the number of times each assembly instruction appears in a file
// 2. count the number of times each assembly instruction appears in a file that does not exist
// 3. count the number of times each assembly instruction appears in an empty file
// 4. count the number of times each assembly instruction appears in a file with lower case
// 5. count the number of times each assembly instruction appears in a file with upper case

// Function to count the number of times each assembly instruction appears in a file
// and the case is not sensitive
int *count_assembly_code(char *filename, char **assembly_instruction, int number_of_assembly)
{
    // create an array to hold the counts
    int *counts = (int *)malloc(number_of_assembly * sizeof(int));
    // initialize the counts to 0
    for (int i = 0; i < number_of_assembly; i++) {
        counts[i] = 0;
    }

    // open the file
    FILE *file;
    file = fopen(filename, "r");
    if (file == NULL) {
        printf("File not found\n");
        // free the memory allocated for counts since it is not used
        free(counts);
        return NULL;
    } else {
        char line_buffer[128];
        // Read through each line of file
        while (fgets(line_buffer, sizeof(line_buffer), file) != NULL) {
            // If there is a match, increment the count
            char first_word[128];
            // Skip empty line to ensure first_word does not remain from last line
            // Which causes count to double count
            if (line_buffer[0] == '\n') {
                continue;
            }
            // Check whether line buffer only has a "\t" and nothing else
            if (line_buffer[0] == '\t' && line_buffer[1] == '\n') {
                continue;
            }

            // Ignore all leading white spaces
            // Read the first word
            sscanf(line_buffer, "%s", first_word);

            // Compare the first word with each word in assembly_instruction
            for (int i = 0; i < number_of_assembly; i++) {
                // If there is a match, increment the count and case is not sensitive
                if (strncasecmp(first_word, assembly_instruction[i], strlen(assembly_instruction[i])) == 0) {
                    counts[i]++;
                    break;
                }
            }
        }
        // Close the file
        fclose(file);

        int counts_array[number_of_assembly];
        // Print the count for each word in assembly_instruction
        for (int i = 0; i < number_of_assembly; i++) {
            printf("%s: %d\n", assembly_instruction[i], counts[i]);
            counts_array[i] = counts[i];
        }
    }
    printf("\n");
    return counts;
}


// ======================Test cases:====================
// 1. count the number of cycles for each assembly instruction
// 2. when the assembly instruction count is 0

// Function to count the number of cycles for each assembly instruction
int count_cycles_assembly(int *assembly_counts, int *instruction_cycles, int assembly_count_size)
{
    int tracker = 0;
    // Multiply the count of each assembly instruction by the number of cycles
    for (int i = 0; i < assembly_count_size; i++) {
        // Add the result to the tracker
        tracker += assembly_counts[i] * instruction_cycles[i];
    }
    printf("%d \n", tracker);
    free(assembly_counts);
    return 0;
}