// combine two arrays into one array
// by comparing the values in the two arrays
// and then put the smaller value into the final array
void combine(int *queue_1, int size_1, int *queue_2, int size_2, int *finalqueue)
{
    // initialize pointers for the two arrays
    int pointer_1 = 0;
    int pointer_2 = 0;
    // initialize pointer for the final array
    int pointer_final = 0;

    // a while loop to make sure the final array is filled by two arrays
    while (pointer_1 < size_1 && pointer_2 < size_2) {
        // start from the left and compare values in the two arrays
        // put the smaller value into the final array first
        if (queue_1[pointer_1] < queue_2[pointer_2]) {
            finalqueue[pointer_final] = queue_1[pointer_1];
            // move the pointers to the next value
            pointer_final++;
            pointer_1++;
        } else {
            // put the smaller value into the final array
            finalqueue[pointer_final] = queue_2[pointer_2];
            // move the pointers to the next value
            pointer_final++;
            pointer_2++;
        }
    }
    // if array_1 is empty first then put the array_2 into the final array
    while (pointer_1 < size_1) {
        finalqueue[pointer_final] = queue_1[pointer_1];
        pointer_final++;
        pointer_1++;
    }
    // if array_2 is empty first then put the array_1 into the final array
    while (pointer_2 < size_2) {
        finalqueue[pointer_final] = queue_2[pointer_2];
        pointer_final++;
        pointer_2++;
    }

}