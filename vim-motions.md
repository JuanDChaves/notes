Here’s a comprehensive list of common Vim motions. These are commands that move the cursor in Vim’s normal mode. Motions can be used alone to navigate or combined with operators (like `d` for delete, `y` for yank, or `c` for change) to perform actions over a range of text.

Basic Cursor Motions
- h - Move left one character
- j - Move down one line
- k - Move up one line
- l - Move right one character

Word Motions
- w - Move to the start of the next word
- W - Move to the start of the next WORD (sequence of non-blank characters)
- e - Move to the end of the current word
- E - Move to the end of the current WORD
- b - Move to the start of the previous word
- B - Move to the start of the previous WORD

Line Motions
- 0 - Move to the start of the line (first character)
- ^ - Move to the first non-blank character of the line
- $ - Move to the end of the line
- g_ - Move to the last non-blank character of the line
- + or <Enter> - Move to the first non-blank character of the next line
- - - Move to the first non-blank character of the previous line

Vertical Motions
- gg - Move to the first line of the file
- G - Move to the last line of the file
- nG or :n - Move to line number n (e.g., 5G goes to line 5)
- H - Move to the top of the screen (High)
- M - Move to the middle of the screen (Middle)
- L - Move to the bottom of the screen (Low)
- zt - Scroll the current line to the top of the screen
- zz - Scroll the current line to the middle of the screen
- zb - Scroll the current line to the bottom of the screen

Scrolling Motions
- <Ctrl-u> - Scroll up half a screen
- <Ctrl-d> - Scroll down half a screen
- <Ctrl-b> - Scroll up a full screen (backward)
- <Ctrl-f> - Scroll down a full screen (forward)
- <Ctrl-e> - Scroll down one line
- <Ctrl-y> - Scroll up one line

Text Object Motions
- iw - Inner word (selects current word, used with operators)
- aw - A word (includes surrounding whitespace)
- is - Inner sentence
- as - A sentence
- ip - Inner paragraph
- ap - A paragraph
- i" - Inner quoted string (inside quotes)
- a" - A quoted string (including quotes)
- i) or i( - Inner parentheses block
- a) or a( - A parentheses block (including parentheses)
- i] or i[ - Inner square brackets block
- a] or a[ - A square brackets block

Search Motions
- /pattern - Search forward for pattern
- ?pattern - Search backward for pattern
- n - Repeat the last search in the same direction
- N - Repeat the last search in the opposite direction
- * - Search forward for the word under the cursor
- # - Search backward for the word under the cursor

Character Search Motions
- f{char} - Move to the next occurrence of char on the current line
- F{char} - Move to the previous occurrence of char on the current line
- t{char} - Move to just before the next occurrence of char on the current line
- T{char} - Move to just after the previous occurrence of char on the current line
- ; - Repeat the last f, F, t, or T motion in the same direction
- , - Repeat the last f, F, t, or T motion in the opposite direction

Mark Motions
- `{mark} - Move to the exact position of mark (e.g., `a for mark a)
- 'mark - Move to the first non-blank character of the line containing mark
- `` - Move to the previous cursor position (before the last jump)
- `. - Move to the position of the last edit

Jump Motions
- <Ctrl-o> - Go to the previous position in the jump list
- <Ctrl-i> or <Tab> - Go to the next position in the jump list
- '' - Move to the first non-blank character of the line of the last cursor position
- g; - Go to the previous change in the change list
- g, - Go to the next change in the change list

Miscellaneous Motions
- % - Move to the matching parenthesis, bracket, or brace
- [{ - Move to the previous unmatched {
- ]} - Move to the next unmatched }
- [( - Move to the previous unmatched (
- ]) - Move to the next unmatched )
- ]] - Move to the next section beginning (e.g., next { in column 1)
- [[ - Move to the previous section beginning

Notes
- Motions are case-sensitive where applicable (e.g., w vs. W).
- Many motions can be prefixed with a count to repeat them (e.g., 3w moves forward 3 words).
- Some motions (like text objects) are typically used with operators rather than standalone navigation.
