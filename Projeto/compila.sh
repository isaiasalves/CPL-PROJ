#!/bin/bash
java -cp antlr.jar antlr.Tool gramatica.g
javac -cp antlr.jar *.java
java -cp .:antlr.jar Compilador ProgramaGerado < prog.vich
