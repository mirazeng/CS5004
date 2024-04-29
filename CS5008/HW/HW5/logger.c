#include "logger.h"

// Function to reset the logger
void logger_reset() {
  logger.num_steps = 0;
}

// Function to add to the logger
void logger_add() {
  logger.num_steps +=1;
}
