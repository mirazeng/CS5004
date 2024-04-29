cmake_minimum_required(VERSION 3.27)
project(code C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(code
        dlist.c
        dlist.h
        dlist_hidden.h
        dlist_main.c
        logger.c
        logger.h
        macros.h
        tests_dlist.h
        tests_dlist.c)
