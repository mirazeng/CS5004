cmake_minimum_required(VERSION 3.27)
project(HW9 C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(HW9
        graph.h
        tests_graph.c)
