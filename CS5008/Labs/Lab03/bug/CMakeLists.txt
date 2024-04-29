cmake_minimum_required(VERSION 3.27)
project(bug C)

set(CMAKE_C_STANDARD 11)

add_executable(bug main.c
        bugmain.c
)
