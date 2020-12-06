#!/bin/sh

cd Questoes/src

for javaFile in `ls questao01/*.java`
    do
    echo "$javaFile"
    javac "$javaFile" 
done
echo "Terminado de compilar as classes da Questao 01"

for javaFile in `ls questao02/*.java`
    do
    echo "$javaFile"
    javac "$javaFile" 
done
echo "Terminado de compilar as classes da Questao 02"

for javaFile in `ls questao03/*.java`
    do
    echo "$javaFile"
    javac "$javaFile" 
done
echo "Terminado de compilar as classes da Questao 03"
