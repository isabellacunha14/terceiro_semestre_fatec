cmake_minimum_required(VERSION 4.1)
project(FilaCircular C)

set(CMAKE_C_STANDARD 11)

add_executable(FilaCircular main.c
        Fila.c
        Fila.h)
