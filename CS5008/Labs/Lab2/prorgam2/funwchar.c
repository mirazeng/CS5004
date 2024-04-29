#include <stdio.h>

// This function takes a character as input
// and returns the next character in the alphabet
char next(char ch)
{
    // initialize code to store the ASCII value of the input character
    int code;
    code = (int) ch;

    // check if the character is a letter by checking its ASCII value
    // including both lower and upper case
    if (code >= 97 && code < 122 || code >= 65 && code < 90) {
        // if it is, increment the ASCII value by 1
        // which move to the next letter
        code++;
    } else {
        // if the character is 'z' or 'Z'
        // set the ASCII value to 'a' or 'A'
        if (code == 90 || code == 122) {
            code = code - 25; // the alphabet has 26 letters with 25 spaces between them
        }
    }
    // convert the ASCII value back to a character
    ch = (char) code;
    printf("%c", ch);
    return ch;
}

// This function changes the case of a letter
char change_case(char ch)
{
    // initialize code to store
    // the ASCII value of the input character
    int code;
    code = (int) ch;

    // check if the character is in lower case
    // by checking its ASCII value
    if (code >= 97 && code <= 122) {
        // change the case by subtracting 32 from the ASCII value
        code = code - 32; // the difference in ASCII value between upper and lower case is 32
    } else {
        // check if the character is in upper case
        if (code >= 65 && code <= 90) {
            // change the case by adding 32 to the ASCII value
            code = code + 32;
        }
    }
    // convert the ASCII value back to a character
    ch = (char) code;
    printf("%c", ch);
    return ch;
}

