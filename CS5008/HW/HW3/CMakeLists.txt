cmake_minimum_required(VERSION 3.27)
project(HW3 C)

set(CMAKE_C_STANDARD 11)

add_executable(HW3
        deque.c
        deque.h
        try_deque.c
        stack.c
        stack.h
        try_stack.c
        tests_deque.c)
