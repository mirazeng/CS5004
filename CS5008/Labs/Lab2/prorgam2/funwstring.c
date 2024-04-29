#include <string.h>
#include <stdio.h>

// This function shifts the letters in a string by x positions
// also known as Caesar cipher
void shift(char *str, int x)
{
    // Normalize x to be within the range of 0 to 25
    x = (x % 26 + 26) % 26;


    // start a loop to iterate through the string
    // with iterator i
    for (int i = 0; i < strlen(str); i++) {
        // initialize code to store letter's ASCII value
        int code = (int) str[i];

        // check if the character is a letter and in upper case
        if (code >= 65 && code <= 90) {
            // find the difference between the letter's ASCII value and base upper case ASCII value
            // plus the input shift value
            // modulo 26 to wrap around the alphabet with 26 letters
            // keep it in range 0 to 25, then add to base
            code = ((code - 65 + x) % 26) + 65;
        } else {
            // check if the character is a letter and in lower case
            if (code >= 97 && code <= 122) {
                code = ((code - 97 + x) % 26) + 97;
            }
        }
        // convert the ASCII value back to a character
        str[i] = (char) code;
    }
    printf("%s", str);
}