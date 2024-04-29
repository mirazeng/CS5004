cmake_minimum_required(VERSION 3.27)
project(Lab03 C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(Lab03
        main.c
        mylist.c
        mylist.h
        testmain.c)
