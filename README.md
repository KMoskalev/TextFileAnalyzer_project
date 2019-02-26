# TextFileAnalyzer_project

1. This app accepts a path to a txt-file or a directory via (String[] args).
2. Converts a path into File object(s).
3. Reads the txt-files (if there are any).
4. Analyzes their contents - it searches for the word "text" and replaces it with "***".
5. Writes the analyzed contents into new files - file.txt => file_edited.txt.
6. Conbines and creates a Statistics file containing the reports about the changes.

The app creates several concurrent threads - one thread contains converting, reading, analyzing and writing operations (steps 2 through 5).

The number of concurrent threads can be easily changed (default: 3).
