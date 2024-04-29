cmake_minimum_required(VERSION 3.27)
project(Lab4 C)

set(CMAKE_C_STANDARD 11)

add_executable(Lab4 main.c
        file_operation.c
        file_operation_test.c
        file_operation_test.h)
