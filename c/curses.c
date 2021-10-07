#include <stdio.h>
#include <stdlib.h>
#include <ncurses.h> // or curses.h

#define DELAY 40000

/*
README
linux dependencies: sudo apt-get install libncurses-dev
*/

int main(void) {

  // mvprintw - print to window
  // print to current window with specifying cursor position and the string to print
  // int mvprintw(int y, int x, char *fmt [, arg] ...);

  // initscr - initialize window
  // access window with stdscr

  initscr();
  noecho();
  curs_set(FALSE);

  start_color();
  init_pair(1, COLOR_GREEN, COLOR_BLACK);
  attron(COLOR_PAIR(1));

  int max_x = 0, max_y = 0;
  getmaxyx(stdscr, max_y, max_x);
  
  char chars[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
  int chars_size = sizeof(chars);

  srand(time(NULL));

  int x[max_x];
  int i;
  int char_index;

  while(1) {
    // initialize with random y
    for (i = 0; i < max_x; i++) {
      x[i] = get_rand_in_range(0, max_y);
    }

    // draw
    for (i = 0; i < max_x; i++) {
      char_index = get_rand_in_range(0, chars_size);
      mvprintw(x[i], i, "%c", chars[char_index]);
    }

    usleep(DELAY);
    refresh();
  }

  endwin();
  return 0;
}

int get_rand_in_range(int min, int max) {
  return (rand() % ((max + 1) - min) + min);
}