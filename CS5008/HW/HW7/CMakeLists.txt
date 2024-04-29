cmake_minimum_required(VERSION 3.27)
project(HW7 C)

set(CMAKE_C_STANDARD 11)

add_executable(HW7
        bst.c
        topdown.c
        bottomup.c
        mergesort.h
        mergesort.c)
