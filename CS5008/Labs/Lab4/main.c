#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "file_operation.h"
#include "file_operation_test.h"


int main(int argc, char **argv)
{
    // Check if there are enough arguments
    if (argc < 2) {
        printf("There are not enough arguments\n");
        return 1;
    } else {
        int totalLength = 1;
        for (int i = 1; i < argc; i++) {
            totalLength += strlen(argv[i]);

            if (i < (argc - 1)) {
                totalLength++; //This allocates necessary memory for all the "/" we will add later
            }
        }

        // Allocate memory for the concatenated file path
        char *filePath = (char *) malloc(totalLength * sizeof(char));

        filePath[0] = '\0';

        // Concatenate the file path
        for (int i = 1; i < argc; i++) {
            strcat(filePath, argv[i]);
            if (i < (argc - 1)) {
                // Postfix "/" to each file path pieces,
                // excluding the last one (which should be a file name instead of directory)
                strcat(filePath, "/");
            }
        }

        // Check if the filePath actually exists
        // If not, halt program and return 2
        FILE *file = fopen(filePath, "r");
        if (file == NULL) {
            printf("File not found on provided path or path is wrong. \n");
            return 2;
        } else {
            fclose(file);
        }

        // assembly instructions
        char *assembly_file[] =
                {"mov",
                 "add",
                 "sub",
                 "mul",
                 "div",
                 "push",
                 "pop",
                 "call",
                 "ret",
                };
        int num_of_assembly_instructions = sizeof(assembly_file) / sizeof(assembly_file[0]);

        // instruction cycles
        int instruction_cycles[] =
                {1,
                 1,
                 1,
                 2,
                 4,
                 1,
                 1,
                 2,
                 1,
                };
        int num_of_instruction_cycle = sizeof(instruction_cycles) / sizeof(instruction_cycles[0]);

        printf("Concatenated file path : %s \n", filePath);
        printf("Passing concatenated file path into program... \n");


        read_file_lines(filePath);

        read_first_word(filePath);

        int *assembly_counts = count_assembly_code(filePath, assembly_file, num_of_assembly_instructions);

        count_cycles_assembly(assembly_counts, instruction_cycles, num_of_instruction_cycle);

        // Free the memory allocated for filePath
        free(filePath);
    }


    // ================ Test Suite ================

    int total_test = 3;
    int passed_test = 0;

    passed_test += test_read_file_lines_regular();
    passed_test += test_read_file_lines_empty();
    passed_test += test_read_file_lines_nonexistent();

    printf("\nPassed %d out of %d tests.\n", passed_test, total_test);

}
