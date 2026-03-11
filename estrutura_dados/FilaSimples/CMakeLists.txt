cmake_minimum_required(VERSION 4.1)
project(FilaSimples C)

set(CMAKE_C_STANDARD 11)

add_executable(FilaSimples main.c
        Fila.h
        Fila.c)
