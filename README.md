# File-Recovery
CPSC 4363 Cybersecurity: Systems - File Recovery Project 09/24/2021

File Recovery:  
Restore the deleted file by founding its associated clusters.  

Input:  
1. the first cluster of each existing file in the root table  
2. the first row of the FAT table  
3. the second row of the FAT table  

Output:  
1. clusters with the data of the deleted file (in the correct sequence)

Example:
  - Input:  
  2 7  
  2 3 4 5 6 7 8  
  3 4 0 6 8 0 0  
  - Output:  
  5 6 8  
