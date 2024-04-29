cmake_minimum_required(VERSION 3.27)
project(program2 C)

set(CMAKE_C_STANDARD 11)

add_executable(program2
        bits.c
        bits.h
        bitscounter.c)
