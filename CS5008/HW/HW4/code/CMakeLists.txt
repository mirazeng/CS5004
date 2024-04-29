cmake_minimum_required(VERSION 3.27)
project(code C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(code
        hashtable.h
        try_hashtable.c
        hashtable.c
        tests_hashtable.c
        tests_hashtable.h)
