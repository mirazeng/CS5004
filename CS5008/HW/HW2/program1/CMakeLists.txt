cmake_minimum_required(VERSION 3.27)
project(program1 C)

set(CMAKE_C_STANDARD 11)

add_executable(program1 defrag.c
        defrag.h
        test_defragment.c)
