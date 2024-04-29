cmake_minimum_required(VERSION 3.27)
project(Lab6 C)

set(CMAKE_C_STANDARD 11)

add_executable(Lab6 binsearch_dll.c
        double_linked_list.c
        search_range.c)
