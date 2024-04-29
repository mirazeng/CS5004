
#ifndef LAB4_FILE_OPERATION_H
#define LAB4_FILE_OPERATION_H

// read the number of lines in a file
int read_file_lines(char *filename);

// read the first word of each line in a file
int read_first_word(char *filename);

// count the number of assembly instructions appearance in a file
int *count_assembly_code(char *filename, char **assembly_instruction, int number_of_assembly);

// count the number of cycles in a file
int count_cycles_assembly(int *assembly_counts, int *instruction_cycles, int assembly_count_size);

#endif //LAB4_FILE_OPERATION_H
