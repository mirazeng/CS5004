cmake_minimum_required(VERSION 3.27)
project(Lab8 C)

set(CMAKE_C_STANDARD 11)

add_executable(Lab8 main.c
        create_bst.h
        create_bst.c
        identical_twins.c
        identical_twins.h)
