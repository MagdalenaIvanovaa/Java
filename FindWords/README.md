**Task**

On the standart input you will receive an absolute path to a folder in the following format ``` D:/DataStructures/books/```, a number ```n```, and n words each on new line. Words will not contain any whitespace characters.

Your task is to read all ```txt``` files in this folder and search for each word if it is contained in some of the files. For each word that is found you have to print the word itself and in what file it is found. If the word is not found print only the word. Words and files should be printed in alphabetical order.

*Note*: If some of the words is found more than once print all files that the word is found in.

*Note 2*: In the input folder you will have only files, that means that you won't have any subdirectories containing more txt files.

An example input will look like this:
```
D:/DataStructures/books/
3
word1
word2  
abracadabra
```
```
An example output should look like this:

abracadabra - focusi.txt magic.txt
word1 - file1.txt file2.txt
word2 - not found
```
